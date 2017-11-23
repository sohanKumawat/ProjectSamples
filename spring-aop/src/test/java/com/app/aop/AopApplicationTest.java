package com.app.aop;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.app.aop.model.Account;
import com.app.aop.service.ExampleService;
/**
 * @author Sohan Kumawat
 * https://docs.spring.io/spring-boot/docs/current/reference/html/boot-features-testing.html
 *
 */

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest//@SpringBootTest(webEnvironment=WebEnvironment.RANDOM_PORT)
//@JsonTest
public class AopApplicationTest {

	@Autowired
	ExampleService exampleService;

	@Test
	public void adminTest() throws Exception {
		Account account = new Account("000001", "Account 1");
		exampleService.updateAccountBalance(account, 100L);
		List<Account> accounts = exampleService.findCustomerAccounts(1L);
		System.out.println("after findCustomerAccounts ** account class " + accounts.toString());
		account.setAccountDescription("Test Description");
		Account act = exampleService.updateAccountDescription(account);
		System.out.println("after updateAccountDescription ** exampleService " + act.toString());
		exampleService.methodUsingGenerics(account);
	}
	/*@Autowired
	private TestRestTemplate restTemplate;

	@Test
	public void exampleTest() {
		String body = this.restTemplate.getForObject("/", String.class);
		//Assert(body).isEqualTo("Hello World");
	}
	
	@Autowired
    private TestRestTemplate template;

    @Test
    public void testRequest() throws Exception {
        HttpHeaders headers = template.getForEntity("/example", String.class).getHeaders();
        assertThat(headers.getLocation().toString(), containsString("myotherhost"));
    }

	
*/
	
	 /*@TestConfiguration
	    static class Config {

	        @Bean
	        public RestTemplateBuilder restTemplateBuilder() {
	            return new RestTemplateBuilder()
	                .additionalMessageConverters(...)
	                .customizers(...);
	        }*/
}
