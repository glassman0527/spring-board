package shop.teddy0527.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j;
import shop.teddy0527.mapper.SampleMapper1;
import shop.teddy0527.mapper.SampleMapper2;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Service
@Log4j
public class SampleTxServiceImpl implements SampleTxService{
	
	@Setter @Autowired
	private SampleMapper1 sampleMapper1;
	
	@Setter @Autowired
	private SampleMapper2 sampleMapper2;

	@Override
	@Transactional(isolation=Isolation.DEFAULT, propagation=Propagation.REQUIRED)
	public void addData(String value) {
		// TODO Auto-generated method stub
		log.info("mapper1...");
		sampleMapper1.insertCol1(value);
		
		log.info("mapper2...");
		sampleMapper2.insertCol2(value);
		
		log.info("end...");
	}
	
}
