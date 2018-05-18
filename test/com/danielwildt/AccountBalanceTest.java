package com.danielwildt;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class AccountBalanceTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void shouldBeAbleToWithdraw500Reais() {
//		Given that I have a 500 reais balance
		BankAccount bankAccount = new BankAccount(500);

//		When I withdraw 500 reais from my account
		bankAccount.withdraw(500);
		//		Then my balance should be 0 (zero)
		assertEquals("should be able to withdraw 500", 0, bankAccount.getBalance());
	}
	
	

}
