package p1;

public class Tester2 {

	public static void main(String[] args) {
		Computable ref;//interface type of a reference., method local var : stack ,as per JVM : un inited
	//	System.out.println(ref);
		ref=new Adder();//indirect ref. : up casting : done auto by javac
		//I/f ref can DIRECTLY(w/o type casting) refer to ANY implementation class instance
		System.out.println(ref.compute(10, 20));//javac :  type of ref : Computable : compute : YES,        JVM : compute : Adder
		//run time polymorphism

	}

}
