package tester;

import inh.Faculty;
import inh.Person;
import inh.Student;

public class TestInheritance3 {

	public static void main(String[] args) {
		Person ref = new Student("Rama", "Seth", 2019, "eDac", 123456, 80);// up casting
		System.out.println(ref);// JVM : toString : Student
		((Student) ref).study();// javac : chks for study() in Person class , any time while accessign , sub
								// class specifi func
		// via super cls ref : explicit type casting (down casting) is mandatory
		ref = new Faculty("Chetan", "Shah", 15, "java");// up casting
		System.out.println(ref);// run time poly
		((Faculty) ref).evaluate();
		// To avoid illgeal casting , which raises ClassCastExc : ALWAYS use instanceof (RTTI)
		//Run time type info
		// checking
		// before performing downcast
		if (ref instanceof Student)//rets true : iff ref is actually referring to Student or any of its sub type 
			((Student) ref).study();// ref ---> Faculty : JVM : run time err : ClassCastExc : Faculty can't be cast
									// to a Student
		else
			System.out.println("Invalid type!!!!!!!!!!!!");

	}

}
