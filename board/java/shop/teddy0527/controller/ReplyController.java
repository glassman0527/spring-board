package shop.teddy0527.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;
import shop.teddy0527.domain.Criteria;
import shop.teddy0527.domain.ReplyVO;
import shop.teddy0527.service.ReplyService;

@RestController
@RequestMapping("replies/*")
@Log4j
@AllArgsConstructor
public class ReplyController {
	private ReplyService service;
	
	@PostMapping(value="new", consumes="application/json", produces= { MediaType.TEXT_PLAIN_VALUE })
	public ResponseEntity<String> create(@RequestBody ReplyVO vo) {
		log.info("ReplyVo :: " + vo);
		
		int insertCount = service.register(vo);
		
		log.info("Reply INSERT COUNT :: " + insertCount);
		
		return insertCount == 1 ?
				new ResponseEntity<>("success", HttpStatus.OK) : 
				new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@GetMapping(value="{bno}/{page}")
	public ResponseEntity<List<ReplyVO>> getList(@PathVariable int page, @PathVariable Long bno) {
		log.info("getList...");
		return new ResponseEntity<>(service.getList(new Criteria(page, 10), bno), HttpStatus.OK);
	}
	
	@GetMapping(value="{rno}")
	public ResponseEntity<ReplyVO> get(@PathVariable Long rno) {
		log.info("get...");
		return new ResponseEntity<>(service.get(rno), HttpStatus.OK);
	}
	
	@DeleteMapping(value="{rno}")
	public ResponseEntity<String> remove(@PathVariable Long rno) {
		log.info("remove...");
		return service.remove(rno) == 1 ?
				new ResponseEntity<>("success", HttpStatus.OK) : 
				new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@PutMapping(value="{rno}")
	public ResponseEntity<String> modify(@PathVariable Long rno, @RequestBody ReplyVO vo) {
		log.info("modify...");
		vo.setRno(rno);
		return service.modify(vo) == 1 ?
				new ResponseEntity<>("success", HttpStatus.OK) : 
				new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
