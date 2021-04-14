package p2;

public interface Formula {
	double calculate(double a);// public n abstract
	
	// public
	default double sqrt(double a, double b) {
		System.out.println("in i/f default method");
		return Math.sqrt(a + b);
	}
}