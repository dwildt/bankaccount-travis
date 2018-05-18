package com.danielwildt;

public class BankAccount {

	private int balance;
	public BankAccount(int balance) {
		this.balance = balance;
	}

	public int getBalance() {
		return this.balance;
	}

	public void withdraw(int valueToWithdraw) {
		this.balance -= valueToWithdraw;
	}

}
