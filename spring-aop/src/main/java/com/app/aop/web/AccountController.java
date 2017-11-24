package com.app.aop.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.app.aop.model.Account;
import com.app.aop.service.AccountService;

@RestController
public class AccountController {
	
	@Autowired
	AccountService accountService;
	@GetMapping("v1/api/account/{accountId}")
	public  Account accountDetails(@PathVariable Long accountId){
		return accountService.customerAccount(accountId);
	}
	
}
