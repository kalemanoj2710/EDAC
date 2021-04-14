package tester;

import dependency.HttpTransport;
import dependent.ATMImpl;

public class TestATM {

	public static void main(String[] args) {
		ATMImpl ref=new ATMImpl();
		ref.setMyTransport(new HttpTransport());
		
		ref.deposit(1000);

	}

}
