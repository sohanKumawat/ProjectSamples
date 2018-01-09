package com.demo.slk.application.apachecamel.controller;
import javax.servlet.http.HttpServletRequest;

import org.apache.camel.ProducerTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CamelController {
	@Autowired
	ProducerTemplate producerTemplate;
	@RequestMapping(value = "/")
	public void startCamel() {
		producerTemplate.sendBody("direct:b", "Calling via Spring Boot Rest Controller");
	}
	@RequestMapping(value = "/sopify")
	public void sopifyCall(HttpServletRequest request, @RequestBody String requestBody) {
		System.out.println("** requestBody ** "+requestBody);
		//producerTemplate.sendBody("direct:b", "Calling via Spring Boot Rest Controller");
	}
	
	
}
