package com.milkbasket.app.analytics.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/analytics/")
public class TestController {
	
	@GetMapping("/status/1")
	public ResponseEntity<String> customerStatus(){
		return new ResponseEntity<String>("Active",HttpStatus.OK);
	}

}
