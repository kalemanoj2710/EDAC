package tester;

public class TestUncheckedException {

	public static void main(String[] args) {
		String s="abc123";
		//javac DOES NOT force handling of the un checked excs
		System.out.println("int value : "+Integer.parseInt(s));
		System.out.println("cntd....");

	}

}
