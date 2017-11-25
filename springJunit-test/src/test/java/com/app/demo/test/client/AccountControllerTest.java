package com.app.demo.test.client;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.app.demo.controller.AccountController;
import com.app.demo.controller.StudentController;
import com.app.demo.model.Account;
import com.app.demo.model.Course;
import com.app.demo.service.AccountService;
import com.app.demo.service.StudentService;
//https://spring.io/guides/gs/testing-web/
//https://docs.spring.io/spring-boot/docs/current/reference/html/boot-features-testing.html
//http://www.baeldung.com/spring-boot-testing
@RunWith(SpringRunner.class)
@WebMvcTest(value ={ AccountController.class,StudentController.class})
public class AccountControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private StudentService studentService;
	@MockBean
	private AccountService accountService;
	
	Course mockCourse = new Course("Course1", "Spring", "10 Steps",
			Arrays.asList("Learn Maven", "Import Project", "First Example",
					"Second Example"));
	Account mockAccount = new Account("1", "a");

	String exampleCourseJson = "{\"name\":\"Spring\",\"description\":\"10 Steps\",\"steps\":[\"Learn Maven\",\"Import Project\",\"First Example\",\"Second Example\"]}";

	@Test
	public void retrieveDetailsForCourse() throws Exception {

		Mockito.when(
				studentService.retrieveCourse()).thenReturn(mockCourse);

		RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
				"/students/Student1/courses/Course1").accept(
				MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		System.out.println(result.getResponse());
		String expected = "{id:Course1,name:Spring,description:10 Steps}";
		System.out.println("Response Json data "+result.getResponse().getContentType()+"  "+result.getResponse().getContentLength());
		// {"id":"Course1","name":"Spring","description":"10 Steps, 25 Examples and 10K Students","steps":["Learn Maven","Import Project","First Example","Second Example"]}
		JSONAssert.assertEquals(expected, result.getResponse()
				.getContentAsString(), false);
	}
	@Test
	public void accountDetails(){
	try{
		Mockito.when(accountService.customerAccount()).thenReturn(mockAccount);

		RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
				"/v1/api/account/").accept(
				MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		String expected = "{accountNumber:1,accountDescription:a}";

		System.out.println("Account Response Json data "+result.getResponse().getContentType()+"  "+result.getResponse().getContentLength());
		
		JSONAssert.assertEquals(expected, result.getResponse()
				.getContentAsString(), false);
	}catch(Exception ex){
		ex.printStackTrace();
	}
	}
	@Test
	public void createStudentCourse() throws Exception {
		Course mockCourse = new Course("1", "Smallest Number", "1",
				Arrays.asList("1", "2", "3", "4"));

		// studentService.addCourse to respond back with mockCourse
		Mockito.when(
				studentService.addCourse(Mockito.anyString(),
						Mockito.any(Course.class))).thenReturn(mockCourse);

		// Send course as body to /students/Student1/courses
		RequestBuilder requestBuilder = MockMvcRequestBuilders
				.post("/students/Student1/courses")
				.accept(MediaType.APPLICATION_JSON).content(exampleCourseJson)
				.contentType(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		MockHttpServletResponse response = result.getResponse();

		assertEquals(HttpStatus.CREATED.value(), response.getStatus());

		assertEquals("http://localhost/students/Student1/courses/1",
				response.getHeader(HttpHeaders.LOCATION));

	}

}
