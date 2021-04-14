package p3;

public interface Formula2 {
	double calculate(double a);// public n abstract
	
	// public
	default double sqrt(double a, double b) {
		System.out.println("in formula 2 i/f default method");
		return Math.sqrt(a - b);
	}
}