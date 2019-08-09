package com.example.jdbcexample.repository;

import java.util.List;

import com.example.jdbcexample.model.Student;

public interface IStudentRepository {
	
	public void createStudent(Student student);
	public void updateStudent(Student student);
	public Student getStudentById(String id);
	public List<Student> getStudentList();
	public void deleteStudent(String id);

}
