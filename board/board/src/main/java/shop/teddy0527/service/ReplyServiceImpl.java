package shop.teddy0527.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.Setter;
import lombok.extern.log4j.Log4j;
import shop.teddy0527.domain.Criteria;
import shop.teddy0527.domain.ReplyVO;
import shop.teddy0527.mapper.ReplyMapper;

@Service
@Log4j
public class ReplyServiceImpl implements ReplyService{
	@Setter @Autowired
	private ReplyMapper mapper;
	
	@Override
	public int register(ReplyVO vo) {
		log.info("register...");
		return mapper.insert(vo);
	}

	@Override
	public ReplyVO get(Long rno) {
		log.info("read...");
		return mapper.read(rno);
	}

	@Override
	public int modify(ReplyVO vo) {
		log.info("modify...");
		return mapper.update(vo);
	}

	@Override
	public int remove(Long rno) {
		log.info("remove...");
		return mapper.delete(rno);
	}

	@Override
	public List<ReplyVO> getList(Criteria cri, Long bno) {
		log.info("getList...");
		return mapper.getListWithPaging(cri, bno);
	}
}
