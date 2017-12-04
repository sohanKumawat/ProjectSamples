package com.app.aop.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.app.aop.aspect.Auditable;
import com.app.aop.aspect.Auditable.AuditDestination;
import com.app.aop.model.Account;

@Service
public class AccountService {

	@Auditable(AuditDestination.DATABASE)
	public void updateAccountBalance(Account account, Long amount) {
		System.out.println("Inside updateAccountBalance(). Account: "
				+ account.getAccountNumber() + ", amount: " + amount);
	}

	public List<Account> findCustomerAccounts(Long customerId) {
		System.out.println("Finding accounts for customer: " + customerId);
		List<Account> result = new ArrayList<>();
		result.add(new Account("000001", "Account 1"));
		return result;
	}
	public Account customerAccount(Long customerId) {
		System.out.println("Finding accounts for customer: " + customerId);
		return new Account("1", "a");
	}

	public Account updateAccountDescription(Account account) {
		System.out.println("Updating account description to :"
				+ account.getAccountDescription());
		return account; 
	}

	public <T> void methodUsingGenerics(T parameter) {
		System.out.println("Inside methodUsingGenerics: "
				+ parameter.getClass().getName());
		
	}

}
