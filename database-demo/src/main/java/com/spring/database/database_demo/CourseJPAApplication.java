package com.spring.database.database_demo;

import com.spring.database.database_demo.jpa.CourseJpaRepository;
import com.spring.database.database_demo.jpa.PassportJpaRepository;
import com.spring.database.database_demo.jpa.ReviewJpaRepository;
import com.spring.database.database_demo.jpa.StudentJpaRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CourseJPAApplication implements CommandLineRunner {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	StudentJpaRepository stu_repo;

	@Autowired
	CourseJpaRepository course_repo;

	@Autowired
	PassportJpaRepository pass_repo;

	@Autowired
	ReviewJpaRepository review_repo;

	public static void main(String[] args) {
		SpringApplication.run(CourseJPAApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		course_repo.addCourses();
		stu_repo.addStudents();
		stu_repo.retrieveStudentAndPassportDetails();
		pass_repo.retrievePassportAndAssociatedStudent();
//		pass_repo.addPassport();
		review_repo.addReviews();
	}
}
