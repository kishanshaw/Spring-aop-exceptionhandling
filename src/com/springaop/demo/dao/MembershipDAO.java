package com.springaop.demo.dao;

import org.springframework.stereotype.Component;

@Component
public class MembershipDAO {
	
	public boolean addAccount(int temp){
		System.out.println("Inside the addAccount method of MembershipDAO class");
		return true;
	}

}
