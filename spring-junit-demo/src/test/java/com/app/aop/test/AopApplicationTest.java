package com.app.aop.test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.app.aop.model.Account;
import com.app.aop.service.AccountService;
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
	AccountService accountService;

	@Test
	public void adminTest() throws Exception {
		Account account = new Account("000001", "Account 1");
		accountService.updateAccountBalance(account, 100L);
		List<Account> accounts = accountService.findCustomerAccounts(1L);
		System.out.println("after findCustomerAccounts ** account class " + accounts.toString());
		account.setAccountDescription("Test Description");
		Account act = accountService.updateAccountDescription(account);
		System.out.println("after updateAccountDescription ** accountService " + act.toString());
		accountService.methodUsingGenerics(account);
	}
/* @Autowired
	private TestRestTemplate restTemplate;

	@Test
	public void exampleTest() {
		String body = this.restTemplate.getForObject("/", String.class);
		//Assert(body).isEqualTo("Hello World");
	}
    @Test
    public void testRequest() throws Exception {
        HttpHeaders headers = template.getForEntity("/example", String.class).getHeaders();
        assertThat(headers.getLocation().toString(), containsString("myotherhost"));
    }
*/
 /* @TestConfiguration
	static class Config {
	        @Bean
	        public RestTemplateBuilder restTemplateBuilder() {
	            return new RestTemplateBuilder()
	                .additionalMessageConverters(...)
	                .customizers(...);
	        }*/
}
