package com.altiusinc.disample.controller;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.altiusinc.disample.service.IGreeting;

@RestController
public class GreetingController {
	@Autowired
	IGreeting greetingService;
	
	@Autowired
	ApplicationContext appContext;
	
	
	@GetMapping(path="/",produces="application/txt")
	public String home() {
		return greetingService.greet();
	}
	
	@GetMapping(path="/beans")
    public Map<String, String[]> beans(@RequestParam(required = false) String beanQueue) {
        Map<String, String[]> beanMap = new HashMap<>();
 
        String[] beanArray = Arrays.stream(appContext.getBeanDefinitionNames())
            .filter(beanName ->
                (beanQueue == null || beanQueue.length() == 0) ||
                beanName.toLowerCase().contains(beanQueue.trim().toLowerCase())
            )
            .toArray(String[]::new);
 
        beanMap.put("beans", beanArray);
        return beanMap;
    }

}
