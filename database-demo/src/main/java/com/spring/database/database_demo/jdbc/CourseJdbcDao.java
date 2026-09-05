package com.spring.database.database_demo.jdbc;

import com.spring.database.database_demo.entity.Course;
import com.spring.database.database_demo.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class CourseJdbcDao {

    @Autowired
    JdbcTemplate jdbcTemplate;

    class CourseRowMapper implements RowMapper<Course> {

        @Override
        public Course mapRow(ResultSet rs, int rowNum) throws SQLException {
            Course course = new Course();
            course.setId(rs.getInt("id"));
            course.setName(rs.getString("name"));
            return course;
        }
    }
}
