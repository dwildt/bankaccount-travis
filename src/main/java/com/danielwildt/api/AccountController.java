package com.danielwildt.api;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.danielwildt.db.AccountRepository;
import com.danielwildt.db.InMemoryAccountRepository;
import com.danielwildt.model.BankAccount;

@RestController
public class AccountController {

    @RequestMapping("/")
    public String index() {
        return String.format("Greetings from Wildtech Bank!\nAccount API.\nCommands available: balance | add | withdraw");
    }
    
    @RequestMapping(path = "/add", produces=MediaType.TEXT_PLAIN_VALUE)
    public String add(String name, Integer balance) {
    	//TODO move to DTO 
    	if(name == null) return "name should be informed";
    	if(balance < 0) return "balance should zero ou more than zero";
    	BankAccount ba = new BankAccount(name, balance);
    	InMemoryAccountRepository.getInstance().add(ba);
        return String.format("account added with name %s and balance %s", ba.getName(), ba.getBalance());
    }

    @RequestMapping(path = "/withdraw",produces=MediaType.TEXT_PLAIN_VALUE)
    public String withdraw(String name, int value) {
    	AccountRepository ar = InMemoryAccountRepository.getInstance();
    	BankAccount ba = ar.findByName(name);
    	if (ba == null) return "Account Not Found!";
    	
    	String withdrawResult = ba.withdraw(value);
    	if(withdrawResult != null) {
    		return withdrawResult;
    	}
    	
    	ar.add(ba);
    	return String.format("Greetings from Wildtech Bank!\nAccount Balance for Account %s is %s", ba.getName(), ba.getBalance());
    }
    

    @RequestMapping(path = "/balance", produces=MediaType.TEXT_PLAIN_VALUE)
    public String getBalance(String name) {
    	AccountRepository ar = InMemoryAccountRepository.getInstance();
    	BankAccount ba = ar.findByName(name);
    	if (ba == null) return "Account Not Found!";
    	return String.format("Greetings from Wildtech Bank!\nAccount Balance for Account %s is %s", ba.getName(), ba.getBalance());
    }

   

}