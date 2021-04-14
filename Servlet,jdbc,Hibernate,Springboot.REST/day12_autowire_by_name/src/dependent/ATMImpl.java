package dependent;

import dependency.Transport;

public class ATMImpl implements ATM {
	private Transport myTransport;

	public ATMImpl() {
		System.out.println("in cnstr of " + getClass().getName() + " " + myTransport);
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

	// setter Based Dependency Injection
	public void setMyTransport(Transport myTransport) {
		System.out.println("in set transport ");
		this.myTransport = myTransport;
	}

	// init style method
	public void myInit() {
		System.out.println("in init " + myTransport);
	}

	// destroy style method
	public void myDestroy() {
		System.out.println("in destroy " + myTransport);
	}

}
