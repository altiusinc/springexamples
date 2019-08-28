package com.altiusinc.disample;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.altiusinc.disample.service.IGreeting;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DisampleApplicationTests {
	
	@Autowired
	IGreeting greeting;

	@Test
	public void contextLoads() {
	}
    
	@Test
	public void greeting() {
		System.out.println(greeting.greet());
	}
}
