package com.demo.slk.apachecamel.service;

import org.springframework.stereotype.Service;

import com.demo.slk.apachecamel.entity.Account;

@Service
public class AccountService {
    public void example(Account account) {
    	account.setName( "Hello, " + account.getName() );
    	account.setId(account.getId()+""+10);
    }
}
