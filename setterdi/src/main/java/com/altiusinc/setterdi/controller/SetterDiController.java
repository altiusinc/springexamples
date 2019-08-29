package com.altiusinc.setterdi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.altiusinc.setterdi.business.Person;
import com.altiusinc.setterdi.helper.SetterDiHelper;

@RestController
public class SetterDiController {
	
	@Autowired
	SetterDiHelper helper;
	
	@GetMapping(path="/setterdi",produces="application/text")
	public String getPersonDetails(@RequestBody Person person) {
		String personName;
		helper.setPerson(person);
		personName=helper.getPerson().getName();
		return personName;
	}

}
