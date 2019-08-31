package com.altiusinc.rulesenginesample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan("com.altiusinc.rulesenginesample")
public class RulesenginesampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(RulesenginesampleApplication.class, args);
	}

}
