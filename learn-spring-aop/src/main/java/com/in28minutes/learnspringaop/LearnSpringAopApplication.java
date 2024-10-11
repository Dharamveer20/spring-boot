package com.in28minutes.learnspringaop;

import com.in28minutes.learnspringaop.aopexample.business.BusinessService1;
import com.in28minutes.learnspringaop.aopexample.data.DataService1;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LearnSpringAopApplication implements CommandLineRunner {

	Logger logger = LoggerFactory.getLogger(getClass());
	BusinessService1 businessService1;
	@Autowired
	DataService1 dataService1;

	public LearnSpringAopApplication(BusinessService1 businessService1 ){
		this.businessService1 = businessService1;
	}
	public static void main(String[] args) {
		SpringApplication.run(LearnSpringAopApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
//		logger.info("HIii");
        logger.info("Maximum value is: {}", businessService1.calculateMax());
//		logger.info("HIii 2");
		logger.info("Min value is: {}", businessService1.calculateMin());
//		logger.info("HIii 3");

	}
}
