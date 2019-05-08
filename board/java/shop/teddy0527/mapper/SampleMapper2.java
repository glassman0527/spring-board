package shop.teddy0527.mapper;

import org.apache.ibatis.annotations.Insert;

public interface SampleMapper2 {
	@Insert("INSERT INTO TBL_SAMPLE2 (COL) VALUES(#{data})")
	int insertCol2(String data);
}
