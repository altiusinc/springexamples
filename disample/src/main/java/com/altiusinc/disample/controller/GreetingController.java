package com.altiusinc.disample.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.altiusinc.disample.service.IGreeting;

@RestController
public class GreetingController {
	@Autowired
	IGreeting greetingService;
	
	
	@GetMapping(path="/",produces="application/txt")
	public String home() {
		return greetingService.greet();
	}

}
