package shop.teddy0527.service;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.Setter;
import lombok.extern.log4j.Log4j;
import shop.teddy0527.domain.BoardVo;
import shop.teddy0527.domain.Criteria;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class BoardServiceTest {
	
	@Setter @Autowired
	private BoardService service;
	
	@Test
	public void testExist() {
		log.info(service);
		assertNotNull(service);
	}
	
	@Test
	public void testRegister() {
		BoardVo vo = new BoardVo();
		vo.setTitle("새로 작성하는 글");
		vo.setContent("새로 작성하는 내용");
		vo.setWriter("user00");
		service.register(vo);
		log.info("새로 작성된 게시글 번호 :: " + vo.getBno());
	}
	
	@Test
	public void testGet() {
		BoardVo vo = service.get(23L);
		log.info(vo);
	}
	
	@Test
	public void testModify() {
		BoardVo vo = new BoardVo();
		vo.setTitle("수정 하는 글");
		vo.setContent("수정 하는 내용");
		vo.setWriter("user00");
		vo.setBno(23L);
		log.info(service.modify(vo));
	}
	
	@Test
	public void testRemove() {
		log.info(service.remove(23L));
	}
	
	@Test
	public void testGetList() {
		service.getList(new Criteria(3, 10)).forEach(log::info);
	}
}
