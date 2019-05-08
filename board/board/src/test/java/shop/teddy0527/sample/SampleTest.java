package shop.teddy0527.sample;


import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
//@ContextConfiguration("classpath:/WEB-INF/spring/root-context.xml")
@Log4j
public class SampleTest {
	@Setter @Autowired
	private Restaurant restaurant;
	
	@Test
	public void testExist() {
		assertNotNull(restaurant); // NN Check
		log.fatal("");
		log.error("");
		log.debug("");
		log.warn("");
		log.info(restaurant);
		log.info("------------------------------------------------");
		log.info(restaurant.getChef());
	}
	
	@Test
	public void testExist2() {
		assertNotNull(restaurant);
		
		log.info(restaurant);
		log.info("------------------------------------------------");
		log.info(restaurant.getChef());
	}
	
	@Setter @Autowired
	private Hotel hotel;
	
	@Test
	public void hotelExist() {
		assertNotNull(hotel);
		
		log.info(hotel);
		log.info("------------------------------------------------");
		log.info(hotel.getChef());
	}
}
