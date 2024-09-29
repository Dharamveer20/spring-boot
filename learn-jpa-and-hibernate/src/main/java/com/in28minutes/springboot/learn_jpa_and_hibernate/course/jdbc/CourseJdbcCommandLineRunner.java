package com.in28minutes.springboot.learn_jpa_and_hibernate.course.jdbc;

import com.in28minutes.springboot.learn_jpa_and_hibernate.course.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.stereotype.Component;

@Component
public class CourseJdbcCommandLineRunner implements CommandLineRunner {
    @Autowired
    CourseJdbcRepository repository;
    @Override
    public void run(String... args) throws Exception {
        repository.insert(new Course(1, "Spring Boot", "Random kaka"));
        repository.insert(new Course(2, "Spring Shoes", "Random Watchman"));
        repository.insert(new Course(3, "Spring Chaiwaala", "Random BhangaaerWaala"));

        repository.update("Electrician", 2);
        repository.delete(1);

//        FOr select query make sure default constructor is present in COurse
        Course coursetById = repository.findById(3);
        System.out.println(coursetById);;

        for (Course course : repository.findAll()) {
            System.out.println(course);
        }
    }
}
