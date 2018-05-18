bankaccount-travis
==================
  
[![Build Status](https://travis-ci.org/dwildt/bankaccount-travis.svg?branch=master)](https://travis-ci.org/dwildt/bankaccount-travis)

Manage Bank Accounts. Simple Java project to show more about Test Driven Development, adding java + ant + extra tools. 


User Story #001 Regular Customer Withdraw   
-----------------------------------------

As a Bank customer
I can request no more than my account balance 
In order to keep my account without debt
	
	Given that I have a 500 reais balance
	When I withdraw 501 reais from my account
	Then a message shows saying "Can't have negative account balance" 
	
	Given that I have a 500 reais balance
	When I withdraw 500 reais from my account
	Then my balance should be 0 (zero)


User Story #002 Special Customer Withdraw   
-----------------------------------------
	
As a Special Customer 
I can request more money than my Account Balance 
In order to use my extra balance
	 
	Given that I have a 300 reais balance 
	    AND an extra limit of 200 reais 
	When I withdraw 301 reais
	Then my balance should be -1 reais 
	
	Given that I have a 300 reais balance 
	    AND an extra limit of 200 reais 
	When I withdraw 500 reais
	Then my balance should be -200 reais 
		 
	Given that I have a 300 reais balance 
	    AND an extra limit of 200 reais 
	When I withdraw 501 reais
	Then a message shows saying "Can't withdraw more than account limit"


User Story #003 Maximum Withdraw actions    
----------------------------------------

As a Bank Customer 
I can withdraw the maximum of 800 reais per day no matter the ammount of withdraw activities 
In order to keep my account safe from bad usage
	
	Given that I have done a first withdraw of 300 reais  
	    AND I have a current account balance of 1000 reais 
	When I withdraw 501 reais
	Then a message shows saying "Maximum withdraw limit reached"

