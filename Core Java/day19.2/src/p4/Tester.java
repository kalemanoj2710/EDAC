package p4;

public class Tester {

	public static void main(String[] args) {
		Formula f1=new MyFormula();//up casting
		System.out.println(f1.calculate(10));
		System.out.println(f1.sqrt(12, 13));
		//invoke static method of the i/f 
		Formula.show();
		//invoke static method of a class
		MyFormula.show();

	}

}
