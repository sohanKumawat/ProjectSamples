package com.app.aop.test;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.app.aop.model.Account;
import com.app.aop.service.AccountService;
import com.app.aop.web.AccountController;
import com.fasterxml.jackson.databind.ObjectMapper;
//https://docs.spring.io/spring-boot/docs/current-SNAPSHOT/maven-plugin/usage.html
//@RunWith(SpringJUnit4ClassRunner.class)
//@SpringBootTest
//@WebAppConfiguration
//@WebMvcTest
//@Component
@RunWith(SpringJUnit4ClassRunner.class)
@WebMvcTest(value = AccountController.class, secure = false)
public class RestClientTest {
	
	@Autowired
	private MockMvc mockMvc;
	@MockBean
	private AccountService accountService;
	private ObjectMapper mapper=new ObjectMapper();
	@Test
	public void testCustomerAccount(){
		//List<Account> result = Arrays.asList(new Account("000001", "Account 1"));
		Account result = new Account("000001", "Account 1");
	try{
		//String outputJson=mapper.writeValueAsString(result);
		Mockito.when(
				accountService.customerAccount(Mockito.anyLong())).thenReturn(result);

		RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
				"v1/api/account/231").accept(
				MediaType.APPLICATION_JSON);

		MvcResult testResult = mockMvc.perform(requestBuilder).andReturn();

		System.out.println(testResult.getResponse());
		//String expected = new ObjectMapper().writeValueAsString(result);
		String expected = "{accountNumber:1,accountDescription:a}";
		// {"id":"Course1","name":"Spring","description":"10 Steps, 25 Examples and 10K Students","steps":["Learn Maven","Import Project","First Example","Second Example"]}

		System.out.println("Response Json data "+testResult.getResponse().getContentType()+"  "+testResult.getResponse().getContentLength());
		
		JSONAssert.assertEquals(expected, testResult.getResponse()
				.getContentAsString(), false);
	}catch(Exception ex){
		ex.printStackTrace();
	}
	}
	
}
