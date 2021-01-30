package com.bugcloud.junit.demo;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;

import com.bugcloud.junit.core.BugCloudSpringRunner;
import com.bugcloud.junit.core.annotation.PushReport;

@RunWith(BugCloudSpringRunner.class)
@PushReport(appKey = "6585667c-6f18-4c4f-b809-3be1de3b3ca7", appSecret = "fce8d3b5-6c9b-4a49-a50b-ad519630c898", pusher = "yu", handler = "张三")
@WebAppConfiguration
@SpringBootTest
@Transactional
public class BugCloudSpringRunnerTest {
	private MockMvc mock;
	@Autowired
	private WebApplicationContext webContext;
	
	@Before
	public void init() {
		mock = org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup(webContext).build();
	}
	
	@Test
	public void testGetAllUsers() throws Exception {
		MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.get("/users")
				.contentType(MediaType.APPLICATION_JSON);
		mock.perform(builder).andExpect(MockMvcResultMatchers.status().isOk())
				.andDo(MockMvcResultHandlers.print())
				.andReturn().getResponse().getContentAsString();
	}
}
