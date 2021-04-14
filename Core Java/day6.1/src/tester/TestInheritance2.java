package tester;

import inh.Faculty;
import inh.Person;
import inh.Student;

public class TestInheritance2 {

	public static void main(String[] args) {
		// super class ref, super class object , sub class ref ,sub class object
		//type of the ref n type of the object is same : direct referencing
		Student student1=new Student("Rama", "Seth", 2019, "eDac", 123456, 80);
		System.out.println(student1);//println method auto invokes : student1.toString : complete details
		Person ref;//super cls ref
		ref=student1;//javac auto does casting : up casting : auto done by javac
		System.out.println(ref.toString());//javac : resolves it by type of the ref, JVM resolves it : type 
		//of the instance it's referring to .
		
		
//		//create faculty object
		ref=new Faculty("Chetan", "Shah", 15, "java");//up casting
		System.out.println(ref);//ref.toString dyn : JVM : Faculty's toString

	}

}
