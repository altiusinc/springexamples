package com.altiusinc.rulesenginesample;

import org.openl.rules.runtime.RulesEngineFactory;
import org.openl.runtime.EngineFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.altiusinc.rulesenginesample.model.Case;
import com.altiusinc.rulesenginesample.model.User;
import com.altiusinc.rulesenginesample.rule.IRule;
import com.altiusinc.rulesenginesample.rule.Response;

@Configuration
public class RulesenginesampleConfig {
	/*
	 * @Autowired IRule instance;
	 */
	  @Autowired(required=true)
	  User user;
	  @Autowired(required=true)
	  Case aCase;
	  
	  @Bean
	  public User getUser() {
		  return new User();
	  }
	  
	  @Bean
	  public Case getCase() {
		  return new Case();
	  }
	  
	
	@Bean
	public IRule getIRule() {
		IRule instance;
		final EngineFactory<IRule> engineFactory = new RulesEngineFactory<IRule>(
				getClass().getClassLoader().getResource("HelloUser.xls"), IRule.class);
		instance = engineFactory.newEngineInstance();
		if (instance == null) {
			System.out.println("Instance is Null");
			return null;
		}
		return instance;
	}
	 

}
