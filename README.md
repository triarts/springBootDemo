# Spring boot tutorial (basic)
This tutorial will contain about how to make REST api with spring boot in java
* Java project (gradle)
* MySQL database
* Steps to integrate java srping REST API with MySQL database
* Steps to import project into .jar (deploy to server)

## Description
* This Project for bulding REST API using Spring boot framework, that connect to the MySQL database, and testing using postman.
* This project demo have one table called member that have name, phone, email, status, etc.
* We will implement all basic CRUD examples, with REST API that run on spring boot framework
* What includes in this tutorial
    * Custom native SQL query
    * build DB connection and access using JPA
    * CRUD implmentation in MVC concept
        * FindBy based on table field/column
        * Sort data

## Prequisite 
1. Clone the code from github [(Github Repo link)](https://github.com/triarts/springBootDemo)
    * You can use Eclipse or Intellij, in my case, im using **gradle** build automation system with intellij IDE
2. Download Xampp, heidiSQL, Postman (try to google it)

## Setup environtment
* Start the xampp and start the MySQL
![](https://i.imgur.com/Kt6EaPc.png)
* Change the MYsql default password
    * https://veerasundar.com/blog/2009/01/how-to-change-the-root-password-for-mysql-in-xampp/
* Open heidiSQL, and conncet to  MySQL
![](https://i.imgur.com/kNV2WtR.png)

## Steps to run the demo
1. Create the database in query tab
```
CREATE TABLE `member` (
	`id` VARCHAR(200) NOT NULL, 
	`name` VARCHAR(200) NOT NULL, 
	`phone` VARCHAR(15) NOT NULL,
	`email` VARCHAR(50) NOT NULL DEFAULT '', 
	`status` INT(1) UNSIGNED ZEROFILL NOT NULL DEFAULT '1'
)
COLLATE='latin1_swedish_ci'
ENGINE=InnoDB
;
```
2. Run the java project
3. Wait until the server is on, the code is running on port 9090
4. Open postman, and try the the REST API, start with post to insert the data.
    * example of POST
    ![](https://i.imgur.com/fggOFO3.png)
    * example of PUT
    ![](https://i.imgur.com/OyJ0bH5.png)


### List of the API
* GET
```
localhost:9090/api/v1/member/all
localhost:9090/api/v1/member/all/asc
localhost:9090/api/v1/member/asc
localhost:9090/api/v1/member
```
* POST
```
localhost:9090/api/v1/member/
-> response body json member, without id and status (single)
localhost:9090/api/v1/member/addMultiple/
-> response body json member, without id and status (multiple)
```
* PUT
```
localhost:9090/api/v1/member/ 
-> response body json member
localhost:9090/api/v1/member/setToActive/{id}
localhost:9090/api/v1/member/setToNotActive/{id}
```
* DELETE
```
localhost:9090/api/v1/member/{id}
```

### dummy data
* single POST (one data each run)
```
{
    "name": "johnny",
    "phone": "987987987",
    "email": "jjohn@ony.com"
}

{
    "name": "lina",
    "phone": "5558858",
    "email": "lina@fire.com"
}

```
* multiple POST
```
[
    {
        "name": "james bond",
        "phone": "007555007",
        "email": "james@bond.com"
    },
    {
        "name": "leonardo",
        "phone": "1951951951",
        "email": "leo@aaa.com"
    },
    {
        "name": "jamal",
        "phone": "123456789",
        "email": "jamal@yaaahoo.com"
    },
    {
        "name": "gomes",
        "phone": "123456789",
        "email": "hoho@gman.com"
    },
	{
        "name": "kate",
        "phone": "123456789",
        "email": "kate@gman.com"
    },
	{
        "name": "Timberman",
        "phone": "123456789",
        "email": "timber@gman.com"
    },
	{
        "name": "andrew",
        "phone": "123456789",
        "email": "andrew@gman.com"
    }
]
```

## Additonal info
### Export to .jar 
Make it into .jar executeable program (run in server or other machine that support JVM)

1. add this code in build.gradle
```java=
jar {
	manifest {
		attributes "Main-Class": "com.example.demo"
	}

	from {
		configurations.compile.collect { it.isDirectory() ? it : zipTree(it) }
	}
}
```
2. Refresh the gradle.build
3. In gradle window choose then click build
![](https://i.imgur.com/gNGPkf8.png)
4. If build succesful you can check the .jar file in project file underthe build->libs folder
![](https://i.imgur.com/luZlmR2.png)
5. Try to run the .jar file, it will run the server as long as the MYSQL database still active 
    * NOTE: Since we didn't implement UI you need to kill the program via task manager or kill with PID

## Other
### Create springboot project template 
* go to : https://start.spring.io/
* Setup the project like this, using gradle, add the spring web dependencies, using java 8, you can choose the spring boot version as you wish ![](https://i.imgur.com/VpVN1Qi.png)
* 
### dependencies for JPA in build.gradle
```java
implementation 'org.springframework.boot:spring-boot-starter-data-jpa'
implementation 'org.springframework.boot:spring-boot-starter-web'
runtimeOnly 'mysql:mysql-connector-java'
```

### other useful link (maybe)
* maven series spring boot
    * https://github.com/sofastack/sofa-boot/issues/477
    * https://stackoverflow.com/questions/58023617/how-to-solve-problem-with-importing-spring-application-with-maven
* gradle create .jar
    * https://www.jetbrains.com/help/idea/getting-started-with-gradle.html#deploy_gradle
    * https://stackoverflow.com/questions/21721119/creating-runnable-jar-with-gradle
    * https://mkyong.com/gradle/gradle-create-a-jar-file-with-dependencies/
