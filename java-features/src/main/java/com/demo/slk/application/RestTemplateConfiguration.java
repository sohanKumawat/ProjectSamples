package com.demo.slk.application;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;
import org.springframework.web.client.AsyncRestTemplate;

public class RestTemplateConfiguration {
	String url = "http://localhost:8080/user";
	AsyncRestTemplate restTemplate = new AsyncRestTemplate();
	User user = null;
	public  void restCall(){
		user=new User();
		user.setId(1L);
		user.setFirstName("John");
		user.setLastName("Smith");
		 
		HttpEntity<User> request = new HttpEntity<>(user);
		ListenableFuture<ResponseEntity<String>> response = restTemplate
			.exchange(url, HttpMethod.POST, request, String.class);
		response.addCallback(new ListenableFutureCallback<ResponseEntity<String>>() {
			@Override
			public void onFailure(Throwable throwable) {
			  //do something
			}
		 
			@Override
			public void onSuccess(ResponseEntity<String> response) {
			  System.out.println(response.getBody());
			}
		});
	}
	public static void main(String[] str){
		
	}
}
