package com.example.jdbcexample.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

import com.example.jdbcexample.model.Student;

public class StudentRepository implements IStudentRepository {
	
	@Autowired
	NamedParameterJdbcTemplate jdbcTemplate;
	@Autowired
	Student student;

	
	  @Override public void createStudent(Student student) { // TODO Auto-generated
	   jdbcTemplate.update("insert into student(id,first_name,last_name,course)"+
	  "values(:id,:firstName,:lastName,:course)", 
	  new MapSqlParameterSource("id",student.getId()).addValue("firstName",student.getFirstName()).addValue("lastName", student.getLastName()).addValue("course", student.getCourse()));
	   
	  
	  
	  
	  }
	 

	@Override
	public void updateStudent(Student student) {
		jdbcTemplate.update("update student set id=:id,first_name=:firstName,last_name=:lastName,course=:course)"+
				  "where id=:id)", 
				  new MapSqlParameterSource("id",student.getId()).addValue("firstName",student.getFirstName()).addValue("lastName", student.getLastName()).addValue("course", student.getCourse()));
	}

	@Override
	public Student getStudentById(String id) {
		SqlParameterSource sqlParamSource = new MapSqlParameterSource("id",id);
		return jdbcTemplate.queryForObject("select id, first_name,last_name,course from student where id=:id", sqlParamSource,
			new RowMapper<Student>() {	
		     public Student mapRow(ResultSet rs, int rowNum)throws SQLException {
		    	 student.setId(rs.getString("id"));
		    	 student.setFirstName(rs.getString("first_name"));
		    	 student.setLastName(rs.getString("last_name"));
		    	 student.setCourse(rs.getString("last_name"));
				return student;
		     }
		     });

	}

	


	@Override
	public List<Student> getStudentList() {
		
			List<Student> studentList = this.jdbcTemplate.query("select id,first_name,last_name,course from student", 
					new RowMapper<Student>() {
				Student s;
				     public Student mapRow(ResultSet rs, int rowNum)throws SQLException {
				    	 s = new Student();
				    	 System.out.println("Row number "+rowNum);
				    	 System.out.println("Student id"+rs.getString("id"));
				    	 s.setId(rs.getString("id"));
				    	 System.out.println("student.getId "+student.getId());
				    	 s.setFirstName(rs.getString("first_name"));
				    	 s.setLastName(rs.getString("last_name"));
				    	 s.setCourse(rs.getString("last_name"));
						return s;
				     }
			});
		return studentList;
	}

	@Override
	public void deleteStudent(String id) {
		// TODO Auto-generated method stub

	}
	
	

}
