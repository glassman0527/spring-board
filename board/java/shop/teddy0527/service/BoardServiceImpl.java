package shop.teddy0527.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j;
import shop.teddy0527.domain.BoardVo;
import shop.teddy0527.domain.Criteria;
import shop.teddy0527.mapper.BoardMapper;

@Log4j @NoArgsConstructor @AllArgsConstructor @Service
public class BoardServiceImpl implements BoardService{
	@Setter @Autowired
	private BoardMapper mapper;

	@Override
	public void register(BoardVo vo) {
		log.info("register.......");
		mapper.insertSelectKey(vo);
	}

	@Override
	public BoardVo get(Long bno) {
		log.info("get.....");
		return mapper.read(bno);
	}

	@Override
	public boolean modify(BoardVo vo) {
		log.info("modify.....");
		return mapper.update(vo) == 1;
	}

	@Override
	public boolean remove(Long bno) {
		log.info("delete.....");
		return mapper.delete(bno);
	}

	@Override
	public List<BoardVo> getList(Criteria cri) {
		log.info("getList....." + cri);
		return mapper.getListWithPage(cri);
	}

	@Override
	public int getTotal(Criteria cri) {
		log.info("getTotal.....");
		return mapper.getTotalCount(cri);
	}
}
