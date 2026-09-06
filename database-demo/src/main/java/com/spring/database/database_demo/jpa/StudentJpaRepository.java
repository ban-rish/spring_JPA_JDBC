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
public class StudentJpaRepository {

    private static final Logger log = LoggerFactory.getLogger(StudentJpaRepository.class);

    @PersistenceContext
    private EntityManager em;

    public Student findById(long id) {
        return em.find(Student.class, id);
    }

    public void addStudents() {
        Passport ps0 = new Passport("PN-001");
        Passport ps1= new Passport("PN-002");
        Passport ps2 = new Passport("PN-002");
        em.persist(ps0);
        em.persist(ps1);
        em.persist(ps2);

        Student st0 = new Student("Rishabh");
        Student st1 = new Student("Saumya");
        Student st2 = new Student("Gaurang");

        st0.setPassport(ps0);
        st1.setPassport(ps1);
        st2.setPassport(ps2);

        em.persist(st0);
        em.persist(st1);
        em.persist(st2);
    }

    public void retrieveStudentAndPassportDetails(){
        Student student = em.find(Student.class, 1);
        log.info("Student found with ID : {}", student.getId());
        log.info("Passport found with ID : {}", student.getPassport().getId());
    }
}
