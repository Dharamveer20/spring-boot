package com.in28minutes.springboot.learn_jpa_and_hibernate.course.jdbc;

import com.in28minutes.springboot.learn_jpa_and_hibernate.course.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CourseJdbcRepository {
    @Autowired
    JdbcTemplate jdbcTemplate;

    String INSERT_COURSE = "insert into course values(?,?,?)";
    String UPDATE_COURSE = "update course set author = ? where id = ?";
    String DELTETE_COURSE = "delete from course where id = ?";
    String SELECT_COURSE = "select * from course where id = ?";
    String SELECT_ALL_COURSES = "select * from course";
    public void insert(Course course) {
        jdbcTemplate.update(INSERT_COURSE, course.getId(),course.getName(),course.getAuthor());
    }
    public void update(String author, int id){
        jdbcTemplate.update(UPDATE_COURSE,author,id);
    }

    public void delete(int id) {
        jdbcTemplate.update(DELTETE_COURSE,id);
    }
    public Course findById(int id) {
        return jdbcTemplate.queryForObject(SELECT_COURSE, new BeanPropertyRowMapper<>(Course.class),id);
    }
    public List<Course> findAll() {
        return jdbcTemplate.query(SELECT_ALL_COURSES, new BeanPropertyRowMapper<>(Course.class));
    }
}
