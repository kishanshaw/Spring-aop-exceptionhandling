package com.springaop.demo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(3)
public class LoggingToCloudAspectDemo {
	
	/*
	@Before("com.springaop.demo.aspect.AopExpressions.forDAOPackageWithoutGetterSetter()")
	public void logToCloud(){
		System.out.println("Inside the logToCloud of LoggingToCloudAspectDemo class");
	}
	*/
}
