package com.danielwildt.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.danielwildt.model.BankAccount;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
}



//"BankAccount Console Mode. \n Current balance is %s", (new BankAccount(500)).getBalance()