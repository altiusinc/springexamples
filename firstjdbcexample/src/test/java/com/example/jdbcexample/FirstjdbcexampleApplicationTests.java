package com.example.jdbcexample;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.jdbcexample.controller.StudentController;
import com.example.jdbcexample.model.Student;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FirstjdbcexampleApplicationTests {
   @Autowired
   StudentController stuController;
   @Autowired
   Student student;
	@Test
	public void contextLoads() {
	}
	
	@Test
	public void createTest() {
		student.setId("S003");
		student.setFirstName("Sankarggg");
		student.setLastName("Vedagiriggg");
		student.setCourse("MCA");
		//stuController.createStudent(student);
	}

}
