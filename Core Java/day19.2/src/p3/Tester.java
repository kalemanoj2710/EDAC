package p3;

public class Tester {

	public static void main(String[] args) {
		Formula f1=new MyImpleClass();//up casting
		System.out.println(f1.calculate(10));
		System.out.println(f1.sqrt(120, 13));

	}

}
