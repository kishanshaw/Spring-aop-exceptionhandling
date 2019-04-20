package com.springaop.demo.aspect;

import java.util.List;
import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.springaop.demo.Account;

@Aspect
@Component
@Order(1)
public class LoggingAspectDemo {
	
	//Add all the advices related to logging
	
	//a new advice @Around on the findAccounts method
	private static Logger myLogger = Logger.getLogger(LoggingAspectDemo.class.getName());
	
	@Around("execution(* com.springaop.demo.service.*.getFortune(..))")
	public Object aroundGetFortune(
			ProceedingJoinPoint proceedingJoinPoint) throws Throwable{
		myLogger.info("Inside the method of aroundGetFortune method");
		String methodname = proceedingJoinPoint.getSignature().toShortString();
		myLogger.info("Inside the method: "+methodname);
		
		long begin = System.currentTimeMillis();
		Object result= null;
		try {
			result = proceedingJoinPoint.proceed();
		} catch (Exception e) {
			//log the exception
			myLogger.warning(e.getMessage());
			result= "Dont't worry, we are here to help you!";
		}
		long end = System.currentTimeMillis();
		myLogger.info("Duration:"+(end-begin));
		
		return result;
		
	}
	
	//a new advice @AfterFinally on the findAccounts method
	@After("execution(* com.springaop.demo.dao.AccountDAO.findAccounts(..))")
	public void afterFinallyAddAccount(JoinPoint joinPoint){
		myLogger.info("Inside the method of afterFinallyAddAccount");
		String methodname = joinPoint.getSignature().toShortString();
		myLogger.info("Inside the method: "+methodname);
		
	}
	
	//a new advice @AfterThrowing on the findAccounts method
	@AfterThrowing(
			pointcut = "execution(* com.springaop.demo.dao.AccountDAO.findAccounts(..))" , 
			throwing = "exception"
			)
	public void afterThrowingAddAccount(JoinPoint joinPoint, Throwable exception){
		myLogger.info("Inside the method of afterThrowingAddAccount");
		String methodname = joinPoint.getSignature().toLongString();
		myLogger.info(exception.toString());
		
	}
	
	//a new advice @AfterReturning on the findAccounts method
	@AfterReturning(
			pointcut = "execution(* com.springaop.demo.dao.AccountDAO.findAccounts(..))",
			returning = "result"
			)
	public void afterReturningAddAccount(JoinPoint joinPoint, List<Account> result){
		myLogger.info("Inside the method afterReturningAddAccount");
		String methodname= joinPoint.getSignature().toShortString();
		myLogger.info("Inside the method: "+ methodname);
		myLogger.info("Accounts list: "+result);
		convertAccountNamesToUppercase(result);
		
	}

	private void convertAccountNamesToUppercase(List<Account> result) {
		for(Account account: result){
			String name = account.getName().toUpperCase();
			myLogger.info(name);
		}
		
	}
	
	//@Before advice
	/*
	@Before("com.springaop.demo.aspect.AopExpressions.forDAOPackageWithoutGetterSetter()")  //expression inside parenthesis is Pointcut expression
	public void beforeaddAccount(JoinPoint joinPoint){
		myLogger.info("Inside beforeaddAccount method of LoggingAspectDemo class ");
		
		//display method signature
		MethodSignature methodSignature = (MethodSignature)joinPoint.getSignature();
		myLogger.info("Method Signature: "+methodSignature);
		
		//display method arguments
		Object[] args = joinPoint.getArgs();
		for(Object temparg: args ){
			myLogger.info(temparg);
		}
		
	}
	*/
}
