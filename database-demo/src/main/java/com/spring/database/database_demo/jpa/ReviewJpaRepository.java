package com.spring.database.database_demo.jpa;


import com.spring.database.database_demo.entity.Course;
import com.spring.database.database_demo.entity.Review;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

@Repository
@Transactional
public class ReviewJpaRepository {

    private static final Logger log = LoggerFactory.getLogger(ReviewJpaRepository.class);

    @PersistenceContext
    private EntityManager em;

    public Review findById(long id) {
        return em.find(Review.class, id);
    }

    public void addReviews() {
        Review st0 = new Review("5","Great Course");
        Review st1 = new Review("3","Good Course");
        Review st2 = new Review("4","Helpful Course");
        em.persist(st0);
        em.persist(st1);
        em.persist(st2);
        Course course0 = new Course("AWS Course", LocalDateTime.now(),LocalDateTime.now());
        Course course1 = new Course("Spring Course", LocalDateTime.now(),LocalDateTime.now());
        Course course2 = new Course("SpringBoot Course", LocalDateTime.now(),LocalDateTime.now());
        em.persist(course0);
        em.persist(course1);
        em.persist(course2);
        st0.setCourse(course0);
        st1.setCourse(course0);
        st2.setCourse(course1);
//        st0.setCourse();
    }
}
