package com.danielwildt;

public class BankAccountConsole {

	public static void main(String[] args) {
		System.out.printf("BankAccount Console Mode. \n Current balance is %s", (new BankAccount(500)).getBalance());
	}

}
