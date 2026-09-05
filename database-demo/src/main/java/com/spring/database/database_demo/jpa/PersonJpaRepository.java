package com.spring.database.database_demo.jpa;

import com.spring.database.database_demo.entity.Person;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
@Transactional
public class PersonJpaRepository {

    private static final Logger log = LoggerFactory.getLogger(PersonJpaRepository.class);
    @PersistenceContext
    EntityManager entityManager;

    public List<Person> findAll() {
        TypedQuery<Person> query = entityManager.createNamedQuery("find_all_persons", Person.class);
        return query.getResultList();
    }

    public void findByJPQL(){
        List selectPFromPersonP = entityManager.createQuery("select p from Person p").getResultList();
        log.info("select p from Person p -> {}",selectPFromPersonP.toString());
        jpql_typed();
    }

    public void jpql_typed(){
        TypedQuery<Person> query = entityManager.createQuery("select p from Person p", Person.class);
        List<Person> results = query.getResultList();
        log.info("select p from Person p with typed query -> {}",results.toString());
        jpql_where();
    }

    public void jpql_where(){
        TypedQuery<Person> query = entityManager.createQuery("select p from Person p where name like '%abh%' ", Person.class);
        List<Person> results = query.getResultList();
        log.info("select p from Person p with where clause -> {}",results.toString());
    }

    public Person findById(long id) {
        return entityManager.find(Person.class, id);
    }

    public Person update(Person person) {
        return entityManager.merge(person);
    }

    public Person insert(Person person) {
        return entityManager.merge(person);
    }

    public void deleteById(int id) {
        Person person = findById(id);
        entityManager.remove(person);
    }

    public void playWithEntityManager() {
        Person person1= new Person("Rishabh", "Mathura", new Date());
        entityManager.persist(person1);
        Person person2= new Person("Rish", "Mathura", new Date());
        entityManager.persist(person2);
        Person person3= new Person("Sam", "Kanpur", new Date());
        entityManager.persist(person3);
        entityManager.flush();

        entityManager.detach(person1);
        person1.setName("Rishabh Bansal");
        person2.setName("Rishabh Bansal");
        person3.setName("Sammy");

        entityManager.refresh(person3);

        entityManager.clear();
        person1.setName("Rish Ban");
        person2.setName("Rish Ban");
    }

}