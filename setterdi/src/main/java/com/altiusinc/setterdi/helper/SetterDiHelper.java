package com.altiusinc.setterdi.helper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.altiusinc.setterdi.business.Person;

@Component
public class SetterDiHelper {
	
	Person person;
	
	@Autowired
	public void setPerson(Person person) {
		this.person=person;
		
	}
	
	public Person getPerson()
	{
		return person;
	}

}
