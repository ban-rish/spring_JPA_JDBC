package com.spring.database.database_demo;

import com.spring.database.database_demo.entity.Person;
import com.spring.database.database_demo.jdbc.PersonJdbcDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;

@SpringBootApplication
public class DatabaseDemoApplication implements CommandLineRunner {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	PersonJdbcDao personJdbcDao;

	public static void main(String[] args) {
		SpringApplication.run(DatabaseDemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		logger.info(personJdbcDao.findAll().toString());
		logger.info(personJdbcDao.findById(10001).toString());
		logger.info(personJdbcDao.findByName("Pieter").toString());
		logger.info(personJdbcDao.findByName("Sammy").toString());
		logger.info("ID to be deleted is {} Number of rows deleted {}", 10004, personJdbcDao.deleteById(10004));
		logger.info("Inserting 10004 again -> {}",personJdbcDao.insertPerson(new Person(10004, "Ankita", "Ghaziabad", new Date())));
		logger.info("Update 10003 again -> {}",personJdbcDao.updatePerson(new Person(10003, "Guru", "Gurgaon", new Date())));
	}
}
