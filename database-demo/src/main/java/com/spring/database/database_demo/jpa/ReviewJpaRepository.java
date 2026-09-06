package com.spring.database.database_demo.jpa;


import com.spring.database.database_demo.entity.Review;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

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
    }
}
