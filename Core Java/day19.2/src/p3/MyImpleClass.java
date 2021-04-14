package p3;

public class MyImpleClass implements Formula,Formula2 {

	@Override
	public double calculate(double a) {
		System.out.println("imple abstract method");
		return a*a;
	}
	@Override
	public double sqrt(double a, double b)
	{
		//How to refer to inherited def method ? : i/fName.super.method
		System.out.println(Formula.super.sqrt(a, b));
		System.out.println(Formula2.super.sqrt(a, b));
		return Math.sqrt(a*b);
	}

}
