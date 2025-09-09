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
		bankAccount = new BankAccount("sampleName",500);
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
	
	@Test
	public void shouldNotExceedMaximumDailyWithdrawalLimitOf800Reais() {
		//Given that I have done a first withdraw of 300 reais
		//AND I have a current account balance of 1000 reais
		BankAccount accountWithHighBalance = new BankAccount("highBalance", 1000);
		String firstWithdrawResult = accountWithHighBalance.withdraw(300);
		assertNull("First withdrawal should succeed", firstWithdrawResult);
		assertEquals("Balance should be 700 after first withdrawal", 700, accountWithHighBalance.getBalance());
		
		//When I withdraw 501 reais 
		String message = accountWithHighBalance.withdraw(501);
		//Then a message shows saying "Maximum withdraw limit reached"
		assertEquals("should show maximum limit error", BankAccount.ERROR_MAXIMUM_WITHDRAW_LIMIT_REACHED, message);
		//And balance should remain unchanged
		assertEquals("Balance should remain 700", 700, accountWithHighBalance.getBalance());
	}
	
	@Test
	public void shouldAllowWithdrawalUpToExactly800ReaisPerDay() {
		//Given an account with sufficient balance
		BankAccount accountWithHighBalance = new BankAccount("highBalance", 1000);
		
		//When I withdraw exactly 800 reais
		String message = accountWithHighBalance.withdraw(800);
		//Then it should succeed
		assertNull("Should allow withdrawal of exactly 800 reais", message);
		assertEquals("Balance should be 200", 200, accountWithHighBalance.getBalance());
	}
	
	@Test
	public void shouldRejectWithdrawalOf801ReaisInSingleTransaction() {
		//Given an account with sufficient balance
		BankAccount accountWithHighBalance = new BankAccount("highBalance", 1000);
		
		//When I try to withdraw 801 reais in one transaction
		String message = accountWithHighBalance.withdraw(801);
		//Then it should be rejected due to daily limit
		assertEquals("should show maximum limit error", BankAccount.ERROR_MAXIMUM_WITHDRAW_LIMIT_REACHED, message);
		assertEquals("Balance should remain unchanged", 1000, accountWithHighBalance.getBalance());
	}

}
