package shop.teddy0527.mapper;

import org.apache.ibatis.annotations.Insert;

public interface SampleMapper1 {
	@Insert("INSERT INTO TBL_SAMPLE1 (COL) VALUES(#{data})")
	int insertCol1(String data);
}
