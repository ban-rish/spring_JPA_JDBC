package com.spring.database.database_demo.jpa;


import com.spring.database.database_demo.entity.Course;
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
public class CourseJpaRepository {

    private static final Logger log = LoggerFactory.getLogger(CourseJpaRepository.class);

    @PersistenceContext
    private EntityManager em;

    public Course findById(long id) {
        return em.find(Course.class, id);
    }

    public Course updateCourseName(int id, String name) {
        Course course = em.find(Course.class, id);
        course.setName(name);
        return em.merge(course);
    }

    public void playWithEntityManager() {
        Course course0 = new Course("AWS", LocalDateTime.now(),LocalDateTime.now());
        Course course1 = new Course("Spring", LocalDateTime.now(),LocalDateTime.now());
        em.persist(course0);
        em.persist(course1);

        course1.setName("Spring");
        course1.setName("Spring Boot");
        em.persist(course1);

    }

    public void nativeQueryBasic(){
        Query query = em.createNativeQuery("select * from Course c", Course.class);
        List resultList = query.getResultList();
        log.info("select * from Course c -> {}", resultList.toString());
        nativeQueryWithParameter();
    }

    public void nativeQueryWithParameter(){
        Query query = em.createNativeQuery("select * from Course c where id = ?", Course.class);
        query.setParameter(1, 1);
        List resultList = query.getResultList();
        log.info("select * from Course c where id = ? -> {}", resultList);
        native_Query_With_Named_Parameter();
    }

    public void native_Query_With_Named_Parameter(){
        Query query = em.createNativeQuery("select * from Course c where id = :id", Course.class);
        query.setParameter("id", 1);
        List resultList = query.getResultList();
        log.info("select * from Course c where id = ? using Named parameter-> {}", resultList);
        update_lastUpdatedDate();
    }

    public void update_lastUpdatedDate(){
        Query query = em.createNativeQuery("update Course set last_updated_date = CURRENT_TIMESTAMP()");
        int noOfUpdatedRows = query.executeUpdate();
        log.info("Updated rows = {}", noOfUpdatedRows);
    }

    public void addCourses() {
        Course course0 = new Course("AWS Course", LocalDateTime.now(),LocalDateTime.now());
        Course course1 = new Course("Spring Course", LocalDateTime.now(),LocalDateTime.now());
        Course course2 = new Course("SpringBoot Course", LocalDateTime.now(),LocalDateTime.now());
        em.persist(course0);
        em.persist(course1);
        em.persist(course2);
    }
}
