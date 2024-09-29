package com.in28minutes.springboot.learn_jpa_and_hibernate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class LearnJpaAndHibernateApplication {

	public static void main(String[] args) {
		try{
		System.out.println("1. Hiiiiiiiiiiiiiiii");
		SpringApplication.run(LearnJpaAndHibernateApplication.class, args);
		System.out.println("2. Hjjjjjjjjjjjj");
	} catch (Exception e) {
			System.out.println(e);
		}
	}
}
