package shop.teddy0527.mapper;

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
public class ReplyMapperTest {
	@Setter @Autowired
	private ReplyMapper mapper;
	
	@Test
	public void testMapper () {
		log.info(mapper);
	}
	
	@Test
	public void testInsert() {
		ReplyVO vo = new ReplyVO();
		vo.setBno(2300264L);
		vo.setReply("Test Reply");
		vo.setReplyer("userTest");
		
		mapper.insert(vo);
		
		log.info(vo);
	}
	
	@Test
	public void testRead() {
		log.info(mapper.read(1L));
	}
	
	@Test
	public void testUpdate() {
		ReplyVO vo = new ReplyVO();
		vo.setRno(1L);
		vo.setReply("Modified Reply");
		
		mapper.update(vo);
		
		log.info(vo);
	}
	
	@Test
	public void testDelete() {
		log.info(mapper.delete(6L));
	}
	
	@Test
	public void testList() {
		log.info(mapper.getListWithPaging(new Criteria(), 2300264L));
	}
}
