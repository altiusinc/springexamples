package com.example.jdbcexample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.jdbcexample.controller.StudentController;
import com.example.jdbcexample.model.Student;
import com.example.jdbcexample.repository.IStudentRepository;
import com.example.jdbcexample.repository.StudentRepository;

@Configuration
public class FirstJdbcexampleConfig {
@Autowired(required=true)	
IStudentRepository repo;
@Bean
 public Student getStudent() {
	return new Student();
}

@Bean
public IStudentRepository getRepo() {
	return new StudentRepository();
}
	
}
