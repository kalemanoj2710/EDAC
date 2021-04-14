package dependent;

import dependency.CustomerNotificationService;
import dependency.Transport;

public class ATMImpl implements ATM {
	private Transport myTransport;
	private CustomerNotificationService[] notification;

	public ATMImpl(Transport t, CustomerNotificationService[] notifications) {
		this.myTransport = t;
		this.notification = notifications;
		System.out.println("in cnstr of " + getClass().getName() + " " + myTransport + " " + notification);
	}

	@Override
	public void deposit(double amt) {
		System.out.println("depositing " + amt);
		byte[] data = ("depositing " + amt).getBytes();
		myTransport.informBank(data);
		// inform customer using multiple services
		for (CustomerNotificationService cns : notification)
			cns.informCustomer("You have deposited " + amt + " in your a/c");

	}

	@Override
	public void withdraw(double amt) {
		System.out.println("withdrawing " + amt);
		byte[] data = ("withdrawing " + amt).getBytes();
		myTransport.informBank(data);
		// inform customer using multiple services
		for (CustomerNotificationService cns : notification)
			cns.informCustomer("You have deposited " + amt + " in your a/c");

	}

	// init style method
	public void myInit() {
		System.out.println("in init " + myTransport + " " + notification);
	}

	// destroy style method
	public void myDestroy() {
		System.out.println("in destroy " + myTransport + " " + notification);
	}

}
