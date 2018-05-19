package com.danielwildt.db;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.danielwildt.model.BankAccount;

public class AccountRepositoryTest {

	private BankAccount bankAccount500 = null, bankAccount300 = null;
	
	@Before
	public void setUp() throws Exception {
		bankAccount500 = new BankAccount("51987654321",500);
		bankAccount300 = new BankAccount("51997654321",300);
	}

	@After
	public void tearDown() throws Exception {
		InMemoryAccountRepository.getInstance().removeAll();
	}

	@Test
	public void shouldAddOneAccount() {
		AccountRepository accountRepo = InMemoryAccountRepository.getInstance();
		accountRepo.add(bankAccount500);
		assertEquals("adding account", 1,accountRepo.count());
	}
	
	@Test
	public void shouldFindAccount() {
		AccountRepository accountRepo = InMemoryAccountRepository.getInstance();
		accountRepo.add(bankAccount500).add(bankAccount300);
		assertEquals(500, accountRepo.findByName(bankAccount500.getName()).getBalance());
		
	}

}
