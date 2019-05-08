package shop.teddy0527.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

import lombok.extern.log4j.Log4j;
import net.coobird.thumbnailator.Thumbnailator;
import shop.teddy0527.domain.AttachFileDTO;

@Controller
@Log4j
public class UploadController {
	@GetMapping("uploadForm")
	public void uploadForm() {	
		log.info("uploadForm...");
	}
	
	@PostMapping("uploadForm")
	public void upload(MultipartFile[] uploadFile, Model model) {
		for(MultipartFile multipartFile : uploadFile) {
			log.info("------------------------------------");
			log.info("Upload File Name :: " + multipartFile.getName());
			log.info("Upload File Origin Name :: " + multipartFile.getOriginalFilename());
			log.info("Upload File Size :: " + multipartFile.getSize());
			
			File saveFile = new File("D:\\upload", multipartFile.getOriginalFilename());
			
			try {
				multipartFile.transferTo(saveFile);
			} catch (IllegalStateException | IOException e) {
				// TODO Auto-generated catch block
				log.error(e.getMessage());
			}
		}
	}
	
	@GetMapping("uploadAjax")
	public void uploadAjax() {
		log.info("uploadAjax...");
	}
	
	@PostMapping("uploadAjax")
	public ResponseEntity<List<AttachFileDTO>> uploadAjax(MultipartFile[] uploadFile) {
		List<AttachFileDTO> list = new ArrayList<>();
		
		String uploadRoot = "D:\\upload";
		File uploadFolder = new File(uploadRoot, getFolder());
		if(!uploadFolder.exists()) {
			uploadFolder.mkdirs();
		}
		
		for(MultipartFile multipartFile : uploadFile) {
			AttachFileDTO dto = new AttachFileDTO();
			
			log.info("------------------------------------");
			log.info("Upload File Name :: " + multipartFile.getName());
			log.info("Upload File Origin Name :: " + multipartFile.getOriginalFilename());
			log.info("Upload File Size :: " + multipartFile.getSize());
			String uploadFileName = multipartFile.getOriginalFilename().substring(multipartFile.getOriginalFilename().lastIndexOf("\\")+1);
			
			//1
			dto.setFileName(uploadFileName);
			
			log.info(uploadFileName);
			log.info(multipartFile.getOriginalFilename().lastIndexOf("\\")+1);
			
			UUID uuid = UUID.randomUUID();
			//2
			dto.setUuid(uuid + "");
			
			uploadFileName = uuid + "_" + uploadFileName;
			
			//3
			dto.setUploadPath(getFolder());
			File saveFile = new File(uploadFolder, uploadFileName); 
			
			try {
				multipartFile.transferTo(saveFile); // 파일 저장
				if (checkImageType(saveFile)) { // 이미지 여부 확인
					//4
					dto.setImage(true);
					
					FileOutputStream thumb = new FileOutputStream(new File(uploadFolder, "s_" + uploadFileName)); // 섬네일용 fileoutputstream 
					Thumbnailator.createThumbnail(multipartFile.getInputStream(), thumb, 100, 100); // 섬네일 생성 (100px x 100px)
					thumb.close();
				}
			} catch (IllegalStateException | IOException e) {
				// TODO Auto-generated catch block
				log.error(e.getMessage());
			}
			list.add(dto);
		}
		return new ResponseEntity<>(list, HttpStatus.OK);
	}
	
	private String getFolder() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy" + File.separator + "MM" + File.separator + "dd");
		return sdf.format(new Date());
	}
	
	private boolean checkImageType(File file) {
		try {
			return Files.probeContentType(file.toPath()).startsWith("image");
		} catch (IOException | NullPointerException e) {
			return false;
		}
	}
}
