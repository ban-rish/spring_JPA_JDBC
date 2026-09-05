package com.spring.database.database_demo.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "course")
@NamedQueries(value = {
        @NamedQuery(name="qurey_get_all_courses",query = "Select c from Course c"),
        @NamedQuery(name="query_get_id",query="Select c.id from Course c where c.name like '%AWS%'")
})
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name", nullable = false)
    private String name;

    @UpdateTimestamp
    private LocalDateTime lastUpdatedDate;

    @CreationTimestamp
    private LocalDateTime createdDate;

    public Course() {}

    public Course(String name) {
        this.name = name;
    }

    public Course( String name, LocalDateTime lastUpdatedDate, LocalDateTime createdDate) {
        this.name = name;
        this.lastUpdatedDate = lastUpdatedDate;
        this.createdDate = createdDate;
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

    @Override
    public String toString() {
        return "Course{" +
                "createdDate=" + createdDate +
                ", id=" + id +
                ", name='" + name + '\'' +
                ", lastUpdatedDate=" + lastUpdatedDate +
                '}';
    }
}
