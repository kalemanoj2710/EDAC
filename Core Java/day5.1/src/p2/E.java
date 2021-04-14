package p2;
import p1.A;

//non subclass in a different package
public class E {
	E() {
		//create obj of A
		A ref=new A();
		System.out.println("A's state "+ref.i+" "+ref.j+" "+ref.k+" "+ref.l);
	}
}
