package com.springaop.demo;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.springaop.demo.dao.AccountDAO;
import com.springaop.demo.dao.MembershipDAO;

public class AfterReturningDemoApp {

	public static void main(String[] args) {
		//read the spring config class
		AnnotationConfigApplicationContext context  = new AnnotationConfigApplicationContext(DemoConfig.class);
		
		//get the bean(s) from spring container
		AccountDAO accountDAO = context.getBean("accountDAO", AccountDAO.class);
		
		
		System.out.println("Calling findAccounts----");
		List<Account> accounts = accountDAO.findAccounts(false);
		System.out.println("Accounts list in the main app: \n\n");
		System.out.println(accounts);
		
		//close the context
		context.close();

	}

}
