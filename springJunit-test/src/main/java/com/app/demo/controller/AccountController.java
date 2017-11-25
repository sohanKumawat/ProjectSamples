package com.app.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.demo.model.Account;
import com.app.demo.service.AccountService;

@RestController
public class AccountController {
	
	@Autowired
	AccountService accountService;
	
	@GetMapping("v1/api/account/")
	public  Account accountDetails(){
		return accountService.customerAccount();
	}
	
}
