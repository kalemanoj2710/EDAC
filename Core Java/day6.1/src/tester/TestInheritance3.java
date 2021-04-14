package tester;

import inh.Faculty;
import inh.Person;
import inh.Student;

public class TestInheritance3 {

	public static void main(String[] args) {
		Person ref=new Student("Rama", "Seth", 2019, "eDac", 123456, 80);
		System.out.println(ref);
		((Student)ref).study();//down casting

	}

}
