package com.example.jpaexample;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.jpaexample.constructor.StudentController;
import com.example.jpaexample.model.Student;

@RunWith(SpringRunner.class)
@SpringBootTest
@EnableAutoConfiguration
public class FirstjpaexampleApplicationTests {
	@Autowired
	Student student;
	@Autowired
	StudentController stuController;

	@Test
	public void contextLoads() {
	}

}
