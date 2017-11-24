package com.app.demo.service;

import org.springframework.stereotype.Service;

import com.app.demo.model.Account;

@Service
public class AccountService {

	public Account customerAccount() {
		return new Account("1", "a");
	}

}
