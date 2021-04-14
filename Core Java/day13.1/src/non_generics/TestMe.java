package non_generics;

public class TestMe {

	public static void main(String[] args) {
		// Create a holder class instance to hold an integer
		Holder h1 = new Holder(1234);// int --->Integer --> Object
		int value = (Integer) h1.getRef();// P : down casting , javac : auto un boxing
		// Create a holder class instance to hold a string
		Holder h2 = new Holder("12345");// up casting
		String s = (String) h2.getRef();// down casting : Prog
		h1 = h2;
		value = (Integer) h1.getRef();// no javac err : run time err : ClassCastExc
		System.out.println(value);

	}

}
