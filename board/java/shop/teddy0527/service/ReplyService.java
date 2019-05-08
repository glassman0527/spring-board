package shop.teddy0527.service;

import java.util.List;

import shop.teddy0527.domain.Criteria;
import shop.teddy0527.domain.ReplyVO;

public interface ReplyService {
	int register(ReplyVO vo);
	
	ReplyVO get(Long rno);
	
	int modify(ReplyVO vo);
	
	int remove(Long rno);
	
	List<ReplyVO> getList(Criteria cri, Long bno);
}
