package com.example.jdbcexample.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.jdbcexample.model.Student;
import com.example.jdbcexample.repository.IStudentRepository;

@Controller
@RequestMapping("/student")
public class StudentController {
	@Autowired
	Student student;
	@Autowired
	IStudentRepository stuRepo;
	
	@PostMapping(path="/", consumes= "application/json")
	
	public void createStudent(@RequestBody Student student)
	{
		stuRepo.createStudent(student);
	}
	
	@GetMapping(path="/studentlist",produces="application/json")
	@ResponseBody
	public List<Student>getStudentList(){
		return stuRepo.getStudentList();
	}
	@GetMapping(path="/getStudent",produces="application/json")
	@ResponseBody
	public Student getStudent(@RequestParam String id) {
		return stuRepo.getStudentById(id);
	}

	@PutMapping(path="/{id}",consumes="application/json")
	public void updateStudent(@PathVariable(value="id") String id, @Valid @RequestBody Student student) {
		stuRepo.updateStudent(student);
	}
	
	@DeleteMapping(path="/{id}")
	public String deleteStudent(@PathVariable(value="id") String id) {
		stuRepo.deleteStudent(id);
		return "1 row deleted";
	}
}

