package com.danielwildt.model;

public class BankAccount {

	public static final String ERROR_NEGATIVE_ACCOUNT_BALANCE = "Can't have negative account balance";
	public static final String ERROR_MAXIMUM_WITHDRAW_LIMIT_REACHED = "Maximum withdraw limit reached";
	public static final int DAILY_WITHDRAW_LIMIT = 800;

	private int balance;
	private String name;
	private int dailyWithdrawnAmount;
	
	public BankAccount(String name, int balance) {
		this.balance = balance;
		this.name = name;
		this.dailyWithdrawnAmount = 0;
	}

	public int getBalance() {
		return this.balance;
	}
	
	public String getName() {
		return this.name;
	}

	//FIXME Should return exception, not string
	public String withdraw(int valueToWithdraw) {
		if(dailyWithdrawnAmount + valueToWithdraw > DAILY_WITHDRAW_LIMIT)
			return ERROR_MAXIMUM_WITHDRAW_LIMIT_REACHED;
		
		if(balance - valueToWithdraw < 0)
			return ERROR_NEGATIVE_ACCOUNT_BALANCE;
		
		this.balance -= valueToWithdraw;
		this.dailyWithdrawnAmount += valueToWithdraw;
		return null;
	}

	public int getDailyWithdrawnAmount() {
		return this.dailyWithdrawnAmount;
	}
	
	public void resetDailyWithdrawnAmount() {
		this.dailyWithdrawnAmount = 0;
	}

}
