package com.app.demo.service;

import org.springframework.stereotype.Component;

import com.app.demo.model.Account;

@Component
public class AccountService {

	public Account customerAccount() {
		return new Account("1", "a");
	}

}
