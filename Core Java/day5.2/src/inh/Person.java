package inh;

//Person -- firstName,lastName
public class Person // extends Object : implicitly added by javac
{
	private String firstName, lastName;

	public Person(String firstName, String lastName) {
		// super();
		System.out.println("in person's constr");
		this.firstName = firstName;
		this.lastName = lastName;
	}
//	public Person() {
//		// TODO Auto-generated constructor stub
//	}
	// method overriding : run time form of the polymorphism
	// rules : same method name, method args : same, ret type :same , access spec :
	// can't be restricted

	public String toString() {
		return firstName + " " + lastName;
	}

}
