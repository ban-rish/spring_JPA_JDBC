package com.spring.database.database_demo;

import com.spring.database.database_demo.entity.Person;
import com.spring.database.database_demo.jpa.PersonJpaRepository;
import com.spring.database.database_demo.springdata.PersonSpringDataRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;

@SpringBootApplication
public class SpringDataDemoApplication implements CommandLineRunner {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	PersonSpringDataRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(SpringDataDemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		logger.info(repository.findById(10001).toString());
		logger.info("Inserting 10004 again -> {}",repository.save(new Person("Ankita", "Ghaziabad", new Date())));
		logger.info("Update 10003 again -> {}",repository.save(new Person(10003, "Guru", "Gurgaon", new Date())));
		repository.deleteById(10004);
		logger.info(repository.findAll().toString());
		/*logger.info(personJdbcDao.findAll().toString());
		logger.info(personJdbcDao.findByName("Pieter").toString());
		logger.info(personJdbcDao.findByName("Sammy").toString());
		logger.info("ID to be deleted is {} Number of rows deleted {}", 10004, personJdbcDao.deleteById(10004));
		*/
	}
}
