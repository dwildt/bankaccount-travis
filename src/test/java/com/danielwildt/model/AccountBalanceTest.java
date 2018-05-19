package com.danielwildt.model;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.danielwildt.model.BankAccount;

public class AccountBalanceTest {
	private BankAccount bankAccount = null; 
			
	@Before
	public void setUp() throws Exception {
		bankAccount = new BankAccount(500);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void shouldBeAbleToWithdraw500Reais() {
		//	Given that I have a 500 reais balance -- SETUP
		//	When I withdraw 500 reais from my account
		bankAccount.withdraw(500);
		//	Then my balance should be 0 (zero)
		assertEquals("should be able to withdraw 500", 0, bankAccount.getBalance());
	}
	
	@Test
	public void shouldAvoidToWithdrawMoreThanAccountBalance() {
		//Given that I have a 500 reais balance -- SETUP
		//When I withdraw 501 reais from my account
		String message = bankAccount.withdraw(501);
		//Then a message shows saying "Can't have negative account balance"
		assertEquals("should avoid withdraw", BankAccount.ERROR_NEGATIVE_ACCOUNT_BALANCE, message);
	}
	
	
	

}
