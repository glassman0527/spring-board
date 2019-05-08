package shop.teddy0527.service;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.Setter;
import lombok.extern.log4j.Log4j;
import shop.teddy0527.domain.Criteria;
import shop.teddy0527.domain.ReplyVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class ReplyServiceTest {

	@Setter @Autowired
	private ReplyService service;
	
	@Test
	public void testExist() {
		log.info(service);
		assertNotNull(service);
	}
	
	@Test
	public void testRegister() {
		ReplyVO vo = new ReplyVO();
		vo.setBno(2300264L);
		vo.setReply("Test Reply");
		vo.setReplyer("userTest");
		
		service.register(vo);
		
		log.info("새로 작성된 댓글의 게시글 번호 :: " + vo.getBno());
	}
	
	@Test
	public void testGet() {
		log.info(service.get(1L));
	}
	
	@Test
	public void testModify() {
		ReplyVO vo = new ReplyVO();
		vo.setRno(2L);
		vo.setReply("Modified Reply");
		
		service.modify(vo);
		
		log.info(vo);
	}
	
	@Test
	public void testRemove() {
		log.info(service.remove(2L));
	}
	
	@Test
	public void testGetList() {
		log.info(service.getList(new Criteria(), 2300264L));
	}
}
