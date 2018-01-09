package com.demo.slk.application.apachecamel.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.camel.CamelContext;
import org.apache.camel.Exchange;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.builder.ExchangeBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomRestController {
	@Autowired
	private ProducerTemplate producer;
	
	@Autowired
	private CamelContext camelContext;
	@RequestMapping(value = "/hello")
	public ResponseEntity<?> restApiEndPoint(final HttpServletRequest request, @RequestBody String requestBody) {
		final Exchange requestExchange = ExchangeBuilder.anExchange(camelContext).withBody(requestBody).build();
		final Exchange responseExchange = producer.send("route-end-point", requestExchange);
		final String responseBody = responseExchange.getOut().getBody(String.class);
		final int responseCode = responseExchange.getOut().getHeader(Exchange.HTTP_RESPONSE_CODE, Integer.class).intValue();
		return ResponseEntity.status(responseCode).body(responseBody);
	}
}
