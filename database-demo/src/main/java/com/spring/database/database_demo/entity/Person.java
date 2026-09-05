package com.spring.database.database_demo.entity;

import java.util.Date;

import jakarta.persistence.*;

@Entity
@Table(name = "person")
@NamedQuery(name="find_all_persons",query="select p from Person p")
public class Person {

    @Id
    @GeneratedValue
    private int id;
    @Column(name = "name", nullable = false )
    private String name;
    @Column(name = "location")
    private String location;
    @Column(name = "birth_date")
    private Date birth_date;

    public Person() {
    }

    public Person(int id, String name, String location, Date birth_date) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.birth_date = birth_date;
    }

    public Person(String name, String location, Date birth_date) {
        this.name = name;
        this.location = location;
        this.birth_date = birth_date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Date getBirth_date() {
        return birth_date;
    }

    public void setBirth_date(Date birth_date) {
        this.birth_date = birth_date;
    }

    @Override
    public String toString() {
        return "\nPerson{"
                + "id=" + id
                + ", name='" + name + '\''
                + ", location='" + location + '\''
                + ", birth_date=" + birth_date
                + '}';
    }
}
