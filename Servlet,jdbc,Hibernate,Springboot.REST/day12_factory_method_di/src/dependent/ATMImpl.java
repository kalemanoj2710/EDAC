package dependent;

import dependency.Transport;

public class ATMImpl implements ATM {
	private Transport myTransport;
	private double cash;

	private ATMImpl(double cash123,Transport t) {
		cash = cash123;
		myTransport=t;
		System.out.println("in cnstr of " + getClass().getName() + " " + myTransport + " " + cash);
	}

	@Override
	public void deposit(double amt) {
		System.out.println("depositing " + amt);
		byte[] data = ("depositing " + amt).getBytes();
		myTransport.informBank(data);

	}

	@Override
	public void withdraw(double amt) {
		System.out.println("withdrawing " + amt);
		byte[] data = ("withdrawing " + amt).getBytes();
		myTransport.informBank(data);
	}

	// init style method
	public void myInit() {
		System.out.println("in init " + myTransport + " " + cash);
	}

	// destroy style method
	public void myDestroy() {
		System.out.println("in destroy " + myTransport + " " + cash);
	}
	//factory method based D.I
	public static ATMImpl myFactory(double cash123 , Transport t)
	{
		System.out.println("in factory method");
		return new ATMImpl(cash123, t);
		
	}

}
