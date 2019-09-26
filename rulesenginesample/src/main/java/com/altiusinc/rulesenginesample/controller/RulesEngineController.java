package com.altiusinc.rulesenginesample.controller;

import org.openl.rules.runtime.RulesEngineFactory;
import org.openl.runtime.EngineFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.altiusinc.rulesenginesample.model.Case;
import com.altiusinc.rulesenginesample.model.User;
import com.altiusinc.rulesenginesample.rule.IRule;
import com.altiusinc.rulesenginesample.rule.Response;

@RestController
public class RulesEngineController {
	@Autowired
	IRule instance;
	
	@Autowired
	User user;
	
	@Autowired
	Case aCase;

@GetMapping(path="/rules")
public String getGreetingRules(@RequestParam("name") String name,@RequestParam("time") int time) {
	  user.setName(name); 
	  aCase.setUser(user);
	  aCase.setHourOfDay(time);
	
	process(aCase);
	return "rule processed";
}

public void process(Case aCase) {
	
	  final EngineFactory<IRule> engineFactory = new
	  RulesEngineFactory<IRule>(getClass().getClassLoader()
	  .getResource("HelloUser.xls"), IRule.class);
	 
  instance = engineFactory.newEngineInstance();
  instance.sayHello(aCase, new Response());
}

}
