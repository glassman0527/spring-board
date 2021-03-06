package shop.teddy0527.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;
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
}
