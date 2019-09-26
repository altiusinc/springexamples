package com.altiusinc.kotlinbootsample.controller

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;
import com.altiusinc.kotlinbootsample.model.Greeting;
@RestController
public class GreetingController {
	
	@GetMapping("/kotlingreeting")
   public fun greet(@RequestParam(value="name") name: String )=
		Greeting(name)
	
}