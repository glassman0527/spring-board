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
import shop.teddy0527.domain.ReplyVO;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration({
	"file:src/main/webapp/WEB-INF/spring/root-context.xml", 
	"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"})
@Log4j
public class ReplyControllerTest {
	@Setter @Autowired
	private WebApplicationContext context;
	
	private MockMvc mvc;
	
	@Before
	public void setup() {
		mvc = MockMvcBuilders.webAppContextSetup(context).build();
	}
	
	@Test
	public void testRegister() throws Exception {
		ReplyVO vo = new ReplyVO();
		vo.setBno(2300264L);
		vo.setReply("Test Reply");
		vo.setReplyer("userTest");
		
		String json = new Gson().toJson(vo); // JSON.stringify(); in javascript
		
		log.info(json);
		
		mvc.perform(
			MockMvcRequestBuilders.post("/replies/new")
				.contentType(MediaType.APPLICATION_JSON)
				.content(json)
			)
			.andExpect(status().is(200)
		);
	}
}
