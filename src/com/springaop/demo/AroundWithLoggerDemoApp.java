package com.springaop.demo;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.springaop.demo.dao.AccountDAO;
import com.springaop.demo.dao.MembershipDAO;
import com.springaop.demo.service.TrafficFortuneService;

public class AroundWithLoggerDemoApp {

	private static Logger myLogger = Logger.getLogger(AroundWithLoggerDemoApp.class.getName());
	public static void main(String[] args) {
		
		
		//read the spring config class
		AnnotationConfigApplicationContext context  = new AnnotationConfigApplicationContext(DemoConfig.class);
		
		//get the bean(s) from spring container
		TrafficFortuneService trafficFortuneService = context.getBean("trafficFortuneService", TrafficFortuneService.class);
		
		myLogger.info("Inside the main app:\n");
		myLogger.info("Calling the getFortune method:\n");
		String data = trafficFortuneService.getFortune();
		myLogger.info(data);
		myLogger.info("Finished");
		
		//close the context
		context.close();

	}

}
