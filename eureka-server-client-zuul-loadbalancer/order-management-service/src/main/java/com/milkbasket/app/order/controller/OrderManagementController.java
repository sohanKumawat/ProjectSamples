package com.milkbasket.app.order.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/api/v1/order/")
public class OrderManagementController {
	
	@GetMapping("/status/1")
	public ResponseEntity<String> orderStatus(){
		return new ResponseEntity<String>(new String("delivered api v1 order"), HttpStatus.OK );
	}

}
