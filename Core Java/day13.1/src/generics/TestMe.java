package generics;

public class TestMe {

	public static void main(String[] args) {
		// Create a holder class instance to hold an integer
		Holder<Integer> h1=new Holder<>(1234);// int --->Integer(auto boxing)
		int data=h1.getRef();//Integer ---> int auto un boxing		
		// Create a holder class instance to hold a string
		Holder<String> h2=new Holder<>("12345");//NO IMPLICIT CONVERSION
		String s=h2.getRef();
		h1=h2;//jaavc err : since h1 : Holder<Integer> , h2 : Holder<String>
		

	}

}
