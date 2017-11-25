package com.app.demo.test.client;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.app.demo.model.Account;
//https://dzone.com/articles/testing-improvements-in-spring-boot-14
//https://g00glen00b.be/spring-boot-rest-assured/
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class RestControllerTest {
	@Autowired
    private TestRestTemplate restTemplate;
   /*
     @Before
    public void setup() {
        given(this.vehicleDetailsService.
            getVehicleDetails("123")
        ).willReturn(
            new VehicleDetails("Honda", "Civic"));
    }
    * */
	
	@Test
    public void createClient() {
    	 ResponseEntity<Account> responseEntity =
    	            restTemplate.getForEntity("/v1/api/account/", Account.class);
    	 Account account = responseEntity.getBody();
    	        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
    	        assertEquals("a", account.getAccountDescription());
    }
   /* 
    @Rule
    public ExpectedException exception = ExpectedException.none();
    @Rule
    public ExpectedTestFailureWatcher watcher = ExpectedTestFailureWatcher.instance();
   // @Test(expected = InvalidClientNameException.class)
    @Test
    @ExpectedFailure("The matcher should fail becasue exception is not a SimpleException")
    public void assertSimpleExceptionAssert_exceptionIsOfType() {
        exception.instanceOf(SimpleException.class);
        throw new RuntimeException("this is an exception");
    }
    */

}
