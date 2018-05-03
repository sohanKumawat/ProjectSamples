package com.milkbasket.app.order.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/order")
public class TestController {
	
	@GetMapping("/status/1")
	public ResponseEntity<String> orderStatus(){
		return new ResponseEntity<String>(new String("delivered only order"), HttpStatus.OK );
	}

}
