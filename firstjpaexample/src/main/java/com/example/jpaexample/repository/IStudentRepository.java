package com.example.jpaexample.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.jpaexample.model.Student;

public interface IStudentRepository extends CrudRepository<Student, String> {

}
