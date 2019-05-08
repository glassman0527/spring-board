package shop.teddy0527.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.google.gson.Gson;

import lombok.Setter;
import lombok.extern.log4j.Log4j;
import shop.teddy0527.domain.Ticket;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration({
	"file:src/main/webapp/WEB-INF/spring/root-context.xml", 
	"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"})
@Log4j
public class SampleControllerTest {
	@Setter @Autowired
	private WebApplicationContext context;
	
	private MockMvc mvc;
	
	@Before
	public void setup() {
		mvc = MockMvcBuilders.webAppContextSetup(context).build();
	}
	
	@Test
	public void testConvert() throws Exception {
		Ticket ticket = new Ticket(123, "Admin", "A");
		
		String json = new Gson().toJson(ticket); // JSON.stringify(); in javascript
		ticket = new Gson().fromJson(json, Ticket.class); // JSON.parse(); in javascript
		
		log.info(json);
		
		mvc.perform(
			MockMvcRequestBuilders.post("/sample/ticket")
				.contentType(MediaType.APPLICATION_JSON)
				.content(json)
			)
			.andExpect(status().is(200)
		);
	}
}
