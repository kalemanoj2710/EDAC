package com.app.core;

public class Customer {
	
	private String name,email;
	int age;
	double creditLimit;
	public Customer(String name, String email, int age, double creditLimit) {
		
		this.name = name;
		this.email = email;
		this.age = age;
		this.creditLimit = creditLimit;
	}
	
	public Customer() {
		
		this("Riya","riya@gmail.com",25,10000);
	}

	public Customer(String name, String email, int age) {
		
		
		this(name,email,age,1000);
	}
	
	public String getDetails()
	{
		return "Hello "+this.name+" creditLimit "+this.creditLimit;
	}

	public double getCreditLimit() {
		return creditLimit;
	}

	public void setCreditLimit(double creditLimit) {
		this.creditLimit = creditLimit;
	}
	
	
	
	

}
