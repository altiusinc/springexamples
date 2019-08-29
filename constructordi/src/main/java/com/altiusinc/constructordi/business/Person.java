package com.altiusinc.constructordi.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
@Component
public class Person {
	
	 final int age;
	 final String name;
	 @Autowired
	 public Person(
			 @Value("#{environment['age']?:0}") int age,
			 @Value("#{environment['name']?:'Dummy'}")String name) {
		     this.age=age;
		     this.name=name;

}
}
