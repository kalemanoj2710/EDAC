package p2;

public class MyFormula implements Formula {

	@Override
	public double calculate(double a) {
		System.out.println("imple abstract method");
		return a*a;
	}
	//can imple class override inherited def func ? : YES

	@Override
	public double sqrt(double a, double b) {
		System.out.println("overriding def method");
		return Math.sqrt(a*b);
	}
	

}
