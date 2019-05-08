package shop.teddy0527.mapper;

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
public class BoardMapperTest {
	@Setter @Autowired
	private BoardMapper boardMapper;
	
	@Test
	public void testGetList() {
		boardMapper.getList().forEach(log :: info);
	}
	
	@Test
	public void testGetListWithPage() {
		Criteria cri = new Criteria(1, 10);
		cri.setType("T");
		cri.setKeyword("테스트");
		boardMapper.getListWithPage(cri);
	}
	
	@Test
	public void testInsert() {
		BoardVo vo = new BoardVo();
		vo.setTitle("새로 작성하는 글");
		vo.setContent("새로 작성하는 내용");
		vo.setWriter("newbie");
		
		boardMapper.insert(vo);
		log.info(vo);
	}
	
	@Test
	public void testInsertSelectKey() {
		BoardVo vo = new BoardVo();
		vo.setTitle("새로 작성하는 글 selectKey");
		vo.setContent("새로 작성하는 내용");
		vo.setWriter("newbie");
		
		boardMapper.insertSelectKey(vo);
		log.info(vo);
	}
	
	@Test
	public void testRead() {
		BoardVo vo = boardMapper.read(1L);
		log.info(vo);
	}
	
	@Test
	public void testDelete() {
		log.info(boardMapper.delete(1L));
	}
	
	@Test
	public void testUpdate() {
		BoardVo vo = new BoardVo();
		vo.setBno(4L);
		vo.setTitle("수정된 제목");
		vo.setContent("수정된 내용");
		vo.setWriter("user00");
		
		log.info(boardMapper.update(vo));
	}
	
	@Test
	public void testCount() {
		Criteria cri = new Criteria(1, 10);
		cri.setType("T");
		cri.setKeyword("테스트");
		boardMapper.getTotalCount(cri);
	}
}
