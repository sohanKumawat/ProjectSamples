package com.demo.slk.application.apachecamel.controller;
import javax.servlet.http.HttpServletRequest;

import org.apache.camel.FluentProducerTemplate;
import org.apache.camel.ProducerTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CamelController {
	@Autowired
	ProducerTemplate producerTemplate;
	@Autowired
	FluentProducerTemplate fProducerTemplate;
	
	@RequestMapping(value = "/")
	public void startCamel() {
		producerTemplate.sendBody("direct:b", "Calling via Spring Boot Rest Controller");
		//producerTemplate.asyncCallbackSendBody(endpoint, body, onCompletion)
		//producerTemplate.asyncRequestBodyAndHeaders(endpoint, body, headers)
		//producerTemplate
		
	}
	@SuppressWarnings("unused")
	@RequestMapping(value = "/sopify")
	public void sopifyCall(HttpServletRequest request, @RequestBody String requestBody) {
		System.out.println("** requestBody ** "+requestBody);
		//producerTemplate.sendBody("direct:b", "Calling via Spring Boot Rest Controller");
		
		Integer result = fProducerTemplate.withHeader("key-1", "value-1")
			    .withHeader("key-2", "value-2")
			    .withBody("Hello")
			    .to("direct:inout")
			    .request(Integer.class);
	}
	
	
}
