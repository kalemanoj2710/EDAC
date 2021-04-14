package nested_classes;

public class Tester {

	public static void main(String[] args) {
		//Invoke functionality(showInner)  of the inner class
		Outer.Inner ref=new Outer(1234).new Inner(4567);
		ref.showInner();
	}

}
