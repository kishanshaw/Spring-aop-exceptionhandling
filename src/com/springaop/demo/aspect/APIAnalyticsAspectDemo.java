package com.springaop.demo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(2)
public class APIAnalyticsAspectDemo {
	/*
	@Before("com.springaop.demo.aspect.AopExpressions.forDAOPackageWithoutGetterSetter()")
	public void apiAnalytics(){
		System.out.println("Inside the apiAnalytics method of APIAnalyticsAspectDemo class");
	}
	*/

}
