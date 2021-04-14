package p4;

public class C implements A, B {

	@Override
	public void show() {
		System.out.println("in show method imple "+A.data+" "+B.data);

	}

}
