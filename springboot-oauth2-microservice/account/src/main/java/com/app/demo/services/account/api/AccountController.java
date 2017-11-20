package com.app.demo.services.account.api;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.demo.services.account.model.Account;

@RestController
public class AccountController {

	@RequestMapping("/{id}")
	public Account findAccountById(@PathVariable("id") Integer id) {
		return new Account(id, 1, "123456789", 1234);
	}
	
	@RequestMapping("/customer/{customerId}")
	public Account findAccountByCustomerId(@PathVariable("customerId") Integer customerId) {
		return new Account(1, customerId, "123456789", 1234);
	}
	
}
