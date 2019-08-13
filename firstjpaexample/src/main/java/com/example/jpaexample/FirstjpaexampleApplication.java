package com.example.jpaexample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.jpaexample.model.Student;
@Configuration
@SpringBootApplication

public class FirstjpaexampleApplication {
	@Autowired(required=true)
	Student student;

	public static void main(String[] args) {
		SpringApplication.run(FirstjpaexampleApplication.class, args);
	}
	
	@Bean
	public Student getStudent() {
		return new Student();
	}
	
	
	
	

}
