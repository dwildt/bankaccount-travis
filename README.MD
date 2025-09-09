bankaccount-travis
==================
  
[![Build Status](https://travis-ci.org/dwildt/bankaccount-travis.svg?branch=master)](https://travis-ci.org/dwildt/bankaccount-travis)

Manage Bank Accounts. Simple Java project to show more about Test Driven Development and object oriented design, using:  

* Java
* Ant
* Maven 
* Spring Boot
* Docker & Docker Compose
* Heroku deploy
* More to come (ant + ivy / cpd / pmd / coverage / other test approaches / gradle option)


Run with Docker Compose (recommended)
-------------------------------------
* Prerequisites: Docker and Docker Compose installed
* Build and run: `docker compose up --build`
* The application will be available at http://localhost:8080
* Sample requests:  
  * add Account: `curl "http://localhost:8080/add?name=51987654321&balance=500"`
  * check balance: `curl "http://localhost:8080/balance?name=51987654321"`
  * withdraw: `curl "http://localhost:8080/withdraw?name=51987654321&value=200"`
* Stop: `docker compose down`

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
  * if using curl for testing, use something like "curl \ --data-urlencode "name=51987654321" \ --data-urlencode "value=500" \ http://localhost:8088/add"
* Default port is 8080. If you want to change, check resources/application.properties.

Running this project using AWS Cloud9 IDE
-----------------------------------------
* Update yum and java and dependencies. [Reference](https://docs.aws.amazon.com/pt_br/cloud9/latest/user-guide/sample-java.html)
  * I'm using Amazon Linux, so:
    * update packages: sudo yum -y update
    * install java 8: sudo yum -y install java-1.8.0-openjdk-devel
    * update java version used: sudo update-alternatives --config java
    * update javac version used: sudo update-alternatives --config javac
    * install maven: 
      * sudo wget http://repos.fedorapeople.org/repos/dchen/apache-maven/epel-apache-maven.repo -O /etc/yum.repos.d/epel-apache-maven.repo
      * sudo sed -i s/\$releasever/6/g /etc/yum.repos.d/epel-apache-maven.repo
      * sudo yum install -y apache-maven
    * now you can run mvn install and mvn spring-boot:run 


To run this project @ Heroku
----------------------------
* Install [Heroku Client](https://devcenter.heroku.com/articles/heroku-cli) on your setup. 
* Create a new remote to heroku: "heroku create choose-a-project-name". This will create a choose-a-project-name.herokuapp.com so you can access your app after deployment. If you only use a "heroku create", Heroku will create a slick name for you. 
* Send the project to heroku: "git push heroku master" 
* If something is not right, check heroku logs, using "heroku logs --tail"
* You can test a sample using my install at https://bankaccount-travis.herokuapp.com 