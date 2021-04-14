package tester;


import com.app.core.*;
public class TestStudent {

	public static void main(String[] args) {
		

			Student s1=new Student(21,"Sam","sam@gmail");
			
			Student s2=new Student(21,"tony","tony@gmail");
			
			
			System.out.println(s1.fetchDetails());
			System.out.println(s2.fetchDetails());
			
			double d=s1.computeGPA(100, 100, 100);
			
			double d1=s2.computeGPA(60, 80, 90);
			
			System.out.println(s1.fetchDetails());
			System.out.println(s2.fetchDetails());
			
			if(d>d1)
			{
				System.out.println(s1.fetchDetails() +" is topper");
				
			}
			else
			{
				if(d1>d)
				{
					System.out.println(s1.fetchDetails() +" is topper");
				}
			}
			
			
	}

}
