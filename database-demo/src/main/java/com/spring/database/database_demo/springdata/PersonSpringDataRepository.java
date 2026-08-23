package com.spring.database.database_demo.springdata;

import com.spring.database.database_demo.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonSpringDataRepository extends JpaRepository<Person,Integer> {
}
