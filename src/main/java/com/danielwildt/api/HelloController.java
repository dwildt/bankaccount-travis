package com.danielwildt.api;

import org.springframework.web.bind.annotation.RestController;

import com.danielwildt.model.BankAccount;

import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class HelloController {

    @RequestMapping("/")
    public String index() {
        return String.format("Greetings from Spring Boot!\nBankAccount API mode.\n Current balance is %s", (new BankAccount(500)).getBalance());
    }
    
    @RequestMapping("/addbalance")
    public String addBalance(int value) {
        return "Greetings from Spring Boot!";
    }


}