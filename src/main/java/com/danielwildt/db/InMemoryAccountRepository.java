package com.danielwildt.db;

import java.util.HashMap;
import java.util.Map;

import com.danielwildt.model.BankAccount;

public class InMemoryAccountRepository implements AccountRepository {

	private Map<String, BankAccount> storage = null;
	private static AccountRepository instance = null;

	public static AccountRepository getInstance() {
		if (instance == null) {
			instance = new InMemoryAccountRepository();
		}
		return instance;
	}

	private InMemoryAccountRepository() {
		storage = new HashMap<String, BankAccount>();
	}

	@Override
	public int count() {
		return storage.size();
	}

	@Override
	public AccountRepository add(BankAccount bankAccount) {
		storage.put(bankAccount.getName(), bankAccount);
		return this;
	}

	@Override
	public BankAccount findByName(String name) {
		return storage.get(name);
	}

	@Override
	public AccountRepository removeAll() {
		storage.clear();
		return this;
	}

}
