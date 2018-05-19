package com.danielwildt.console;

import com.danielwildt.model.BankAccount;

public class BankAccountConsole {

	public static void main(String[] args) {
		System.out.printf("BankAccount Console Mode. \n Current balance is %s", (new BankAccount(500)).getBalance());
	}

}
