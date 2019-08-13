package com.example.jpaexample.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Data
@Setter
@Getter
@Entity

@Table(name="student")
public class Student {
	@Id 
	private  String id;
	private  String firstName;
	private  String lastName;
	private  String course;

}
