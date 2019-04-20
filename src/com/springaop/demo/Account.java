package com.springaop.demo;

import org.springframework.stereotype.Component;

@Component
public class Account {
	private int id;
	private String name;
	
	public Account() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	public Account(int id, String name) {
		this.id = id;
		this.name = name;
	}



	public int getId() {
		System.out.println("Inside the getter method of id in Account class");
		return id;
	}


	public void setId(int id) {
		System.out.println("Inside the setter method of id in Account class");
		this.id = id;
	}


	public String getName() {
		System.out.println("Inside the getter method of name in Account class");
		return name;
	}


	public void setName(String name) {
		System.out.println("Inside the setter method of name in Account class");
		this.name = name;
	}


	public void addAccount(){
		System.out.println("Inside the addAccount method of Account class");
		
	}



	@Override
	public String toString() {
		return "Account [id=" + id + ", name=" + name + "]";
	}
	

}
