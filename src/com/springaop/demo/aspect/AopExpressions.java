package com.springaop.demo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class AopExpressions {
	
	//Pointcut declaration
			@Pointcut("execution(* com.springaop.demo.dao.*.*(..))")
			public void forDAOPackage(){}
			
			@Pointcut("execution(* com.springaop.demo.dao.*.set*(..))")
			public void setter(){}
			
			@Pointcut("execution(* com.springaop.demo.dao.*.get*(..))")
			public void getter(){}
			
			@Pointcut("forDAOPackage() && !(setter() || getter())")
			public void forDAOPackageWithoutGetterSetter(){}

}
