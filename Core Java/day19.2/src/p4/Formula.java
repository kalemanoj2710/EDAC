package p4;

public interface Formula {
	double calculate(double a);// public n abstract
	
	// public
	default double sqrt(double a, double b) {
		System.out.println("in i/f default method");
		return Math.sqrt(a + b);
	}
	//static methods can be added in i/f
	//which is/are javac added keyword/s : public 
	static void show()
	{
		System.out.println("in i/f static method : show");
	}
}