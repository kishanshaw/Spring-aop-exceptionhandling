package com.springaop.demo.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.springaop.demo.Account;

@Component
public class AccountDAO {
	
	private int id;
	private String name;
	
	//add a new method returning a list of Account
	
	public List<Account> findAccounts(boolean flag){
		if(flag){
			throw new RuntimeException("Testing the exception");
		}
		List<Account> accounts = new ArrayList<>();
		
		Account account1 = new Account(1,"Mary");
		Account account2 = new Account(2,"John");
		accounts.add(account1);
		accounts.add(account2);
		System.out.println("Exiting findAccounts method of AccountDAO class");
		return accounts;
		
	}
	
	
	public int getId() {
		System.out.println("Inside the getter method of id in AccountDAO class");
		return id;
	}


	public void setId(int id) {
		System.out.println("Inside the setter method of id in AccountDAO class");
		this.id = id;
	}


	public String getName() {
		System.out.println("Inside the getter method of name in AccountDAO class");
		return name;
	}


	public void setName(String name) {
		System.out.println("Inside the setter method of name in AccountDAO class");
		this.name = name;
	}

	
	public void addAccount(Account account){
		System.out.println("Inside the addAccount method of AccountDAO class");
	}

}
