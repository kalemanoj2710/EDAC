package tester;

import inh.Faculty;
import inh.Student;

public class TestInheritance1 {

	public static void main(String[] args) {
		// create student object
		Student student1=new Student("Rama", "Seth", 2019, "eDac", 123456, 80);
		System.out.println(student1.toString());//complete details
		
		//create faculty object
		Faculty faculty1=new Faculty("Chetan", "Shah", 15, "java");
		System.out.println(faculty1.toString());//complete details

	}

}
