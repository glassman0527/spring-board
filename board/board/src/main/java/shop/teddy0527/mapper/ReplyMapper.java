package shop.teddy0527.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import shop.teddy0527.domain.Criteria;
import shop.teddy0527.domain.ReplyVO;

public interface ReplyMapper {
	int insert(ReplyVO vo);
	
	ReplyVO read(Long rno);
	
	int update(ReplyVO vo);
	
	int delete(Long rno);
	
	List<ReplyVO> getListWithPaging(@Param("cri") Criteria cri, @Param("bno") Long bno);
}
