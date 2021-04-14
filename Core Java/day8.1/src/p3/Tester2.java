package p3;

public class Tester2 {

	public static void main(String[] args) {
		//imple class instance
		ConsolePrinter consolePrinter = new ConsolePrinter();
		Computable ref = consolePrinter;//up casting
		System.out.println(ref.compute(10, 20));
		Printable ref2=consolePrinter;//up casting
		ref2.print("Some message!!!!");
		

	}

}
