package shop.teddy0527.service;

import java.util.List;

import shop.teddy0527.domain.BoardVo;
import shop.teddy0527.domain.Criteria;

public interface BoardService {
	void register(BoardVo vo);
	
	BoardVo get(Long bno);
	
	boolean modify(BoardVo vo);
	
	boolean remove(Long bno);
	
	List<BoardVo> getList(Criteria cri);
	
	int getTotal(Criteria cri);
}
