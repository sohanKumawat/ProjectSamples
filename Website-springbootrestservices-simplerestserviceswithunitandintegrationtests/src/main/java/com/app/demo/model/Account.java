package com.app.demo.model;


public class Account {

	private String accountNumber;
	private String accountDescription;
	public Account(){}
	public Account(String accountNumber, String accountDescription) {
		this.accountNumber = accountNumber;
		this.accountDescription = accountDescription;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getAccountDescription() {
		return accountDescription;
	}

	public void setAccountDescription(String accountDescription) {
		this.accountDescription = accountDescription;
	}

	@Override
	public String toString() {
		return "Account [accountNumber=" + accountNumber + ", accountDescription=" + accountDescription + "]";
	}
}
