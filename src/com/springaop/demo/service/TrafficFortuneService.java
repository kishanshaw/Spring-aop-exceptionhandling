package com.springaop.demo.service;

import java.util.concurrent.TimeUnit;

import org.springframework.stereotype.Component;

@Component
public class TrafficFortuneService {
	
	public String getFortune(){
		//simulate delay
		try {
			System.out.println("Simulating delay\n");
			TimeUnit.SECONDS.sleep(5);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "Expect heavy traffic!";
	}

	public String getFortune(boolean tripwire) {
		if(tripwire){
			throw new RuntimeException("Major accident! Highway is closed!");
		}
		return "Expect heavy traffic this morning"	;
				
	}

}
