package com.danielwildt;


import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.danielwildt.model.BankAccount;

public class BankAccountTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testSimpleAccountBalance() {
		BankAccount bankAccount = new BankAccount(500);
		assertEquals(500, bankAccount.getBalance());
	}

}
