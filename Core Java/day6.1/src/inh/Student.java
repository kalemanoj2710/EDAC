package inh;

//Student --firstName,lastName,grad year,course,fees,marks
public class Student extends Person {
	private int gradYear;
	private String courseName;
	private double fees;
	private int marks;

	public Student(String fn, String ln, int gradYear, String courseName, double fees, int marks) {

		super(fn, ln);// To invoke immediate super cls's MATCHING constr : for initing super cls
						// members
		System.out.println("in student's constr");
		this.gradYear = gradYear;
		this.courseName = courseName;
		this.fees = fees;
		this.marks = marks;
	}

	// override toString method , inherited from Person : in order to ret complete
	// details
	@Override
	public String toString() {
		return "Student " + super.toString() + " passed in " + gradYear + " course " + courseName + " " + fees
				+ " marks " + marks;
	}
	//can student class add more functionality ?
	public void study()
	{
		//o/p firstName studyin in coursename
		System.out.println(getFirstName()+" studying in course "+courseName);
	}

}
