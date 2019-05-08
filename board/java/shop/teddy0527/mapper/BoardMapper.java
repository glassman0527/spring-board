package shop.teddy0527.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import shop.teddy0527.domain.BoardVo;
import shop.teddy0527.domain.Criteria;

public interface BoardMapper {
//	@Select("SELECT * FROM TBL_BOARD WHERE BNO > 0")
//	List<BoardVo> getList();
	
	List<BoardVo> getList();
	
	List<BoardVo> getListWithPage(Criteria cri);
	
	public int getTotalCount(Criteria cri);
	
	void insert(BoardVo vo);
	
	void insertSelectKey(BoardVo vo);
	
	BoardVo read(Long bno);
	
	boolean delete(Long bno);
	
	int update(BoardVo vo);
	
	void updateReplyCnt(@Param("bno") Long bno, @Param("amount") int amount);
}
