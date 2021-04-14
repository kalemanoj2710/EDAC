package inh;

//Faculty -- firstName,lastName,yrs of experience , sme
public class Faculty extends Person {
	private int expInYears;
	private String sme;
	public Faculty(String fName,String lName,int yrs,String sme) {
		super(fName,lName);
		System.out.println("in faculty constr");
		expInYears=yrs;
		this.sme=sme;
	}
	//override toString inherited from Person class : to ret COMPLETE details of the Faculty
	@Override
	public String toString()
	{
		return "Faculty "+super.toString()+" exp in yrs "+expInYears+" expert in "+sme;
	}
	//adding sub class specific functionalty
	public void evaluate()
	{
		//last name evaluating students..
		System.out.println(getLastName()+" evaluating students....");
	}
}
