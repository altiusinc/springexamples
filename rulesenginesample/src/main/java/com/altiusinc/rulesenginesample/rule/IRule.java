package com.altiusinc.rulesenginesample.rule;



import com.altiusinc.rulesenginesample.model.Case;

public interface IRule {
   public void sayHello(final Case myCase, final Response response);
}
