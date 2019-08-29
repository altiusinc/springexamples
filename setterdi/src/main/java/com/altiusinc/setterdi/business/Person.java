package com.altiusinc.setterdi.business;

import org.springframework.stereotype.Component;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
@Component
public class Person {
	
	int age=42;
	String name="Sankar";
    public Person getPerson() {
    	this.setAge(age);
    	this.setName(name);
    	return this;
    }
}
