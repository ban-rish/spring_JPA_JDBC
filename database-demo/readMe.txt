Connecting to My SQL and Other Databases
Spring Boot makes it easy to switch databases! Yeah really simple.

Steps
Install MySQL and Setup Schema
Remove H2 dependency from pom.xml
Add MySQL (or your database) dependency to pom.xml

<dependency>
    <groupId>mysql</groupId>
    <artifactId>mysql-connector-java</artifactId>
</dependency>

Configure application.properties

spring.jpa.hibernate.ddl-auto=none
spring.datasource.url=jdbc:mysql://localhost:3306/person_example
spring.datasource.username=personuser
spring.datasource.password=YOUR_PASSWORD

Restart the app and You are ready!
Spring Boot can setup the database for you using Hibernate

Things to note:

Spring Boot chooses a default value for you based on whether it thinks your database is embedded (default create-drop) or not (default none).
spring.jpa.hibernate.ddl-auto is the setting to perform SchemaManagementTool actions automatically
none : No action will be performed.
create-only : Database creation will be generated.
drop : Database dropping will be generated.
create : Database dropping will be generated followed by database creation.
validate : Validate the database schema
update : Update the database schema
Reference : https://docs.jboss.org/hibernate/orm/5.2/userguide/html_single/Hibernate_User_Guide.html#configurations-hbmddl
application.properties

#none, validate, update, create, create-drop
spring.jpa.hibernate.ddl-auto=create
Installing and Setting Up MySQL
Install MySQL https://dev.mysql.com/doc/en/installing.html
More details - http://www.mysqltutorial.org/install-mysql/
Trouble Shooting - https://dev.mysql.com/doc/refman/en/problems.html
Startup the Server (as a service)
Go to command prompt (or terminal)
Execute following commands to create a database and a user

mysql --user=user_name --password db_name
create database person_example;
create user 'personuser'@'localhost' identified by 'YOUR_PASSWORD';
grant all on person_example.* to 'personuser'@'localhost';