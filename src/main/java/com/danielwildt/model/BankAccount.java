package com.danielwildt.model;

public class BankAccount {

	public static final String ERROR_NEGATIVE_ACCOUNT_BALANCE = "Can't have negative account balance";

	private int balance;
	private String name;
	
	public BankAccount(String name, int balance) {
		this.balance = balance;
		this.name = name;
	}

	public int getBalance() {
		return this.balance;
	}
	
	public String getName() {
		return this.name;
	}

	//FIXME Should return exception, not string
	public String withdraw(int valueToWithdraw) {
		if(balance - valueToWithdraw < 0)
			return ERROR_NEGATIVE_ACCOUNT_BALANCE;
		
		this.balance -= valueToWithdraw;
		return null;
	}

}
