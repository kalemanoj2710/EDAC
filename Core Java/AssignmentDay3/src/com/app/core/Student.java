package com.app.core;

public class Student {
	
	private int id,age;
	private String name,email;
	double gpa;
	
	public static int idGen;

	public Student(int age, String name, String email) {
		
		this.age = age;
		this.name = name;
		this.email = email;

		this.id=++idGen;
	}
	
	
	public String fetchDetails()
	{
		
		
		return "Name "+this.name+" Age "+this.age+" email"+this.email+"  id "+this.id+" gpa "+this.gpa;
	}
	
	
	public double computeGPA(double q,double test,double assign)
	{
		
		double a=(q/20)*100;
		
		double b=(test/50)*100;
		
		double c=(assign/30)*100;
		
		double result=a+b+c;
		
		double result1=result/100;
		
		
		
		this.gpa=result1;
		
		
		return result1;
		
	}


	public double getGpa() {
		return gpa;
	}


		
	
	
	
	
	
	

}
