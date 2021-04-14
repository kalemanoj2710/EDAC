package p3;

public interface Formula {
	double calculate(double a);// public n abstract
	
	// public
	default double sqrt(double a, double b) {
		System.out.println("in formula  i/f default method");
		return Math.sqrt(a + b);
	}
}