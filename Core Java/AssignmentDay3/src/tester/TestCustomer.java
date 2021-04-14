package tester;

import java.util.Scanner;
import com.app.core.*;

public class TestCustomer {

	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);

		
		System.out.println("please enter name");
		String name=sc.next();
		
		System.out.println("please enter email");
		String email=sc.next();
		
		System.out.println("please enter age");
		int age=sc.nextInt();
		
		System.out.println("please enter credit limit");
		double creditLimit=sc.nextDouble();
		
		Customer c1=new Customer(name,email,age,creditLimit);
		
		System.out.println(c1.getDetails());
		Customer c2=new Customer();
		System.out.println(c2.getDetails());
		Customer c3=new Customer(name,email,age);
		System.out.println(c3.getDetails());
		
		System.out.println("do you want change your credit Limit then please enter Y");
		
		char per=sc.next().charAt(0);
		
		if(per=='Y')
		{
			System.out.println("please enter your credit limit");
			double lim=sc.nextDouble();
			c3.setCreditLimit(lim);
		}
		
		System.out.println(c3.getDetails());
		
		
	}
	

}
