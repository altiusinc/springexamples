package com.altiusinc.constructordi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.altiusinc.constructordi.business.Person;

@RestController
public class ConstructorDiController {
	@Autowired
	Person person;
	
	@GetMapping(path="/construdi",produces="application/json")
	public Person getDetails() {
		return person;
	}
	
	

}
