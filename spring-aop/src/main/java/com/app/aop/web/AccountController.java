package com.app.aop.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.app.aop.model.Account;
import com.app.aop.service.AccountService;

@RestController
@RequestMapping(value="v1/api")
public class AccountController {
	
	@Autowired
	AccountService accountService;
	@RequestMapping(value="/account/{accountId}",method={RequestMethod.GET})
	public  Account accountDetails(@PathVariable Long accountId){
		return accountService.customerAccount(accountId);
	}
	
}
