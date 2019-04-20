package com.springaop.demo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.springaop.demo.dao.AccountDAO;
import com.springaop.demo.dao.MembershipDAO;

public class AOPDemoApp {

	public static void main(String[] args) {
		//read the spring config class
		AnnotationConfigApplicationContext context  = new AnnotationConfigApplicationContext(DemoConfig.class);
		
		//get the bean(s) from spring container
		AccountDAO accountDAO = context.getBean("accountDAO", AccountDAO.class);
		//MembershipDAO membershipDAO = context.getBean("membershipDAO", MembershipDAO.class);
		accountDAO.setId(1);
		int a = accountDAO.getId();
		System.out.println("Id:"+a+"\n\n");
		
		accountDAO.setName("Loan");
		String b = accountDAO.getName();
		System.out.println("Id:"+b+"\n\n");
		
		//Business logic
		accountDAO.addAccount(new Account());
		
		//close the context
		context.close();

	}

}
