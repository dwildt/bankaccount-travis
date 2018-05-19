package com.danielwildt.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;

@SpringBootApplication
public class DemoApplication {

	@RequestMapping("/hello")
	String home() {
		return "Hello World";//String.format("BankAccount Console Mode. \n Current balance is %s", (new BankAccount(500)).getBalance());
	}

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
}