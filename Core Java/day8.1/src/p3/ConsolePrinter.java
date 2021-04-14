package p3;

public class ConsolePrinter implements Printable,Computable{

	@Override
	public void print(String message) {
		System.out.println("Printing message : "+message+" on the console");
		
	}

	@Override
	public double compute(double a, double b) {
		
		return a+b;
	}
	
	
	

}
