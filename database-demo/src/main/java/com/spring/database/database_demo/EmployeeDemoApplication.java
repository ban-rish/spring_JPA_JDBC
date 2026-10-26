package com.spring.database.database_demo;

import com.spring.database.database_demo.entity.FullTimeEmployee;
import com.spring.database.database_demo.entity.PartTimeEmployee;
import com.spring.database.database_demo.jpa.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.math.BigDecimal;

//@SpringBootApplication
public class EmployeeDemoApplication implements CommandLineRunner {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	EmployeeJpaRepository emp_repo;

	public static void main(String[] args) {
		SpringApplication.run(EmployeeDemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		emp_repo.insert(new PartTimeEmployee("Jill", new BigDecimal("50")));
		emp_repo.insert(new FullTimeEmployee("Jack", new BigDecimal("10000")));

		logger.info("All Employees are {}", emp_repo.retrieveAllEmployee());
	}
}
