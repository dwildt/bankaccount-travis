package com.danielwildt;

public class BankAccount {

	public static final String ERROR_NEGATIVE_ACCOUNT_BALANCE = "Can't have negative account balance";

	private int balance;
	public BankAccount(int balance) {
		this.balance = balance;
	}

	public int getBalance() {
		return this.balance;
	}

	//FIXME Should return exception, not string
	public String withdraw(int valueToWithdraw) {
		if(balance - valueToWithdraw < 0)
			return ERROR_NEGATIVE_ACCOUNT_BALANCE;
		
		this.balance -= valueToWithdraw;
		return null;
	}

}
