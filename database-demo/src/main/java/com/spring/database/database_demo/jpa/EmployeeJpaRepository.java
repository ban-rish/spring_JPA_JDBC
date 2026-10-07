package com.spring.database.database_demo.jpa;


import com.spring.database.database_demo.entity.Course;
import com.spring.database.database_demo.entity.Employee;
import com.spring.database.database_demo.entity.Review;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
@Transactional
public class EmployeeJpaRepository {

    private static final Logger log = LoggerFactory.getLogger(EmployeeJpaRepository.class);

    @PersistenceContext
    private EntityManager em;

    //insert an employee
    public void insert(Employee employee)
    {
        em.persist(employee);
    }

    public List<Employee> retrieveAllEmployee() {
        return em.createQuery("select e from Employee e", Employee.class).getResultList();
    }
}
