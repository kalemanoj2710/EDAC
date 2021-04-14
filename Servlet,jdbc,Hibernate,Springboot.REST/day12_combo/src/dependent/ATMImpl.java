package dependent;

import dependency.Transport;

public class ATMImpl implements ATM {
	private Transport myTransport;
	private double cash;
	//constr based D.I
	public ATMImpl(double cash123) {
		cash=cash123;
		System.out.println("in cnstr of " + getClass().getName() + " " +myTransport+" "+cash);
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
		System.out.println("in init " + myTransport+" "+cash);
	}

	// destroy style method
	public void myDestroy() {
		System.out.println("in destroy " + myTransport+" "+cash);
	}
	//setter based D.I 

	public void setMyTransport(Transport myTransport) {
		System.out.println("in set transport");
		this.myTransport = myTransport;
	}
	

}
