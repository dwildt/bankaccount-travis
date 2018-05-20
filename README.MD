bankaccount-travis
==================
  
[![Build Status](https://travis-ci.org/dwildt/bankaccount-travis.svg?branch=master)](https://travis-ci.org/dwildt/bankaccount-travis)

Manage Bank Accounts. Simple Java project to show more about Test Driven Development and object oriented design, using:  

* Java
* Ant
* Maven 
* Spring Boot
* Heroku deploy
* More to come (ant + ivy / cpd / pmd / coverage / other test approaches / gradle option)


Run Ant Build + Unit Tests (use build.xml)
------------------------------------------
* To run tests: "ant test"

Run Maven Build + Spring Boot API (pom.xml)
-------------------------------------------
* download dependencies: "mvn install"
* run spring-boot API: "mvn spring-boot:run"
* Sample request:  
  * add Account: "/add?name=51987654321&balance=500"
  * check balance: "/balance?name=51987654321"
  * withdraw: "withdraw?name=51987654321&value=200"
* Default port is 8088. If you want to change, check resources/application.properties.

To run this project @ Heroku
----------------------------
* Install [Heroku Client](https://devcenter.heroku.com/articles/heroku-cli) on your setup. 
* Create a new remote to heroku: "heroku create choose-a-project-name". This will create a choose-a-project-name.herokuapp.com so you can access your app after deployment. If you only use a "heroku create", Heroku will create a slick name for you. 
* Send the project to heroku: "git push heroku master" 
* If something is not right, check heroku logs, using "heroku logs --tail"
* You can test a sample using my install at https://bankaccount-travis.herokuapp.com 