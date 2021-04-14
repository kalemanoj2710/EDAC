package p1;
import static p1.Computable.PI;

public class Tester {

	public static void main(String[] args) {
		Adder adder=new Adder();
		System.out.println(adder.compute(10,20));
		//can non imple class(eg : Tester ) access i/f constants  ? YES
	//	System.out.println("I/f constant "+Computable.PI);
		System.out.println(PI);

	}

}
