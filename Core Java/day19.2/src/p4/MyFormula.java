package p4;

public class MyFormula implements Formula {

	@Override
	public double calculate(double a) {
		System.out.println("imple abstract method");
		return a*a;
	}

	@Override
	public double sqrt(double a, double b) {
		// TODO Auto-generated method stub
		return Math.sqrt(a*b);
	}
//	@Override
	static void show()
	{
		System.out.println("in class  static method : show");
		//can imple class invoke i/f static method : YES : How ? i/f Name.methodname
		Formula.show();
	}
	

}
