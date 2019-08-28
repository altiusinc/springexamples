package com.altiusinc.disample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.altiusinc.disample.service.EnglishGreeting;
import com.altiusinc.disample.service.IGreeting;
import com.altiusinc.disample.service.JapaneseGreeting;

@SpringBootApplication
@Configuration
public class DisampleApplication {
	/**
	 * Constructor Injection
	 * @param args
	 */

	public static void main(String[] args) {
		SpringApplication.run(DisampleApplication.class, args);
	}
	
	@Bean
	@ConditionalOnProperty(name="language.name",havingValue="English",matchIfMissing=true)
	public IGreeting englishGreeting(){
		return new EnglishGreeting();
	}
    
	@Bean
	@ConditionalOnProperty(name="language.name",havingValue="Japanese")
	public IGreeting japaneseGreeting(){
		return new JapaneseGreeting();
	}
}
