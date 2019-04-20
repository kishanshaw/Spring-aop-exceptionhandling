package com.springaop.demo;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.springaop.demo.dao.AccountDAO;
import com.springaop.demo.dao.MembershipDAO;

public class AfterThrowingDemoApp {

	public static void main(String[] args) {
		//read the spring config class
		AnnotationConfigApplicationContext context  = new AnnotationConfigApplicationContext(DemoConfig.class);
		
		//get the bean(s) from spring container
		AccountDAO accountDAO = context.getBean("accountDAO", AccountDAO.class);
		
		
		System.out.println("Calling findAccounts----");
		try{
			boolean flag=true;
			List<Account> accounts = accountDAO.findAccounts(flag);
		}
		catch (Exception e) {
			System.out.println("Main App exception:"+e);
		}
		
		//close the context
		context.close();

	}

}
