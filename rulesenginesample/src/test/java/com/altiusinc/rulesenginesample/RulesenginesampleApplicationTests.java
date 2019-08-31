package com.altiusinc.rulesenginesample;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.openl.rules.runtime.RulesEngineFactory;
import org.openl.runtime.EngineFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.altiusinc.rulesenginesample.model.Case;
import com.altiusinc.rulesenginesample.model.User;
import com.altiusinc.rulesenginesample.rule.IRule;
import com.altiusinc.rulesenginesample.rule.Response;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RulesenginesampleApplicationTests {
	
	@Autowired
	IRule instance;
	
	@Autowired
	User user;
	
	@Autowired
	Case aCase;

	@Test
	public void contextLoads() {
	}
    
	@Test
	public void ruleSetup() {
		user.setName("Mickey Stewart");
		aCase.setUser(user);
		aCase.setHourOfDay(22);
		process(aCase);
	}
	
	
	
	
	public void process(Case aCase) {
		
		  final EngineFactory<IRule> engineFactory = new
		  RulesEngineFactory<IRule>(getClass().getClassLoader()
		  .getResource("HelloUser.xls"), IRule.class);
		 
        instance = engineFactory.newEngineInstance();
        instance.sayHello(aCase, new Response());
    }
}
