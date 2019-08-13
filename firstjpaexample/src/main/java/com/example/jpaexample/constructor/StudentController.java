package com.example.jpaexample.constructor;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.jpaexample.model.Student;
import com.example.jpaexample.repository.IStudentRepository;


@Controller
@RequestMapping("/student")
public class StudentController {
	@Autowired
	Student student;
	@Autowired
	IStudentRepository stuRepo;
	@Transactional
	@PostMapping(path="/", consumes= "application/json")
	@ResponseBody
	public Student createStudent(@RequestBody Student student)
	{
		return stuRepo.save(student);
	}
	
	@GetMapping(path="/studentlist",produces="application/json")
	@ResponseBody
	public List<Student>getStudentList(){
		return (List<Student>) stuRepo.findAll();
	}
	@GetMapping(path="/getStudent",produces="application/json")
	@ResponseBody
	public Student getStudent(@RequestParam String id) {
		
		  Student resVal = stuRepo.findById(id).get();
		  
		return resVal;
	}
    @Transactional
	@PutMapping(path="/{id}",consumes="application/json")
	@ResponseBody
	public Student updateStudent(@PathVariable(value="id") String id, @Valid @RequestBody Student student) {
		Student recToModify = stuRepo.findById(id).get();
		recToModify.setFirstName(student.getFirstName());
		recToModify.setLastName(student.getLastName());
		recToModify.setCourse(student.getCourse());
		return stuRepo.save(recToModify);
	}
	@Transactional
	@DeleteMapping(path="/{id}")
	@ResponseBody()
	public String deleteStudent(@PathVariable(value="id") String id) {
		stuRepo.deleteById(id);
		return "1 row deleted";
	}
}

