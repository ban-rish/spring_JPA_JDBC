package com.spring.database.database_demo.jpa;


import com.spring.database.database_demo.entity.Passport;
import com.spring.database.database_demo.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class PassportJpaRepository {

    private static final Logger log = LoggerFactory.getLogger(PassportJpaRepository.class);

    @PersistenceContext
    private EntityManager em;

    public Passport findById(long id) {
        return em.find(Passport.class, id);
    }

    public void retrievePassportAndAssociatedStudent(){
        Passport passport = em.find(Passport.class, 20001);
        log.info("Passport found with ID : {}", passport.getId());
        log.info("Student found with ID : {}", passport.getStudent().getId());
    }

    public void addPassport() {
        Passport st0 = new Passport("PN-001");
        Passport st1 = new Passport("PN-002");
        Passport st2 = new Passport("PN-002");
//        em.persist(st0);
//        em.persist(st1);
//        em.persist(st2);
    }
}
