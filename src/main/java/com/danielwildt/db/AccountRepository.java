package com.danielwildt.db;

import com.danielwildt.model.BankAccount;

public interface AccountRepository {

	int count();

	AccountRepository add(BankAccount bankAccount);

	BankAccount findByName(String name);

	AccountRepository  removeAll();

}
