package com.springaop.demo;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.springaop.demo.dao.AccountDAO;
import com.springaop.demo.dao.MembershipDAO;
import com.springaop.demo.service.TrafficFortuneService;

public class AroundDemoApp {

	public static void main(String[] args) {
		//read the spring config class
		AnnotationConfigApplicationContext context  = new AnnotationConfigApplicationContext(DemoConfig.class);
		
		//get the bean(s) from spring container
		TrafficFortuneService trafficFortuneService = context.getBean("trafficFortuneService", TrafficFortuneService.class);
		
		System.out.println("Inside the main app:\n");
		System.out.println("Calling the getFortune method:\n");
		String data = trafficFortuneService.getFortune();
		System.out.println(data);
		System.out.println("Finished");
		
		//close the context
		context.close();

	}

}
