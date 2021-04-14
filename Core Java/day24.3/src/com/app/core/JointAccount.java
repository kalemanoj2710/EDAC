package com.app.core;

import static java.lang.Thread.*;

public class JointAccount {
	private double balance;

	public JointAccount(double balance) {
		super();
		this.balance = balance;
	}

	@Override
	public String toString() {
		return "BankAccount [balance=" + balance + "]";
	}

	// update balance : 5000 amt=500
	public  synchronized void updateBalance(double amt) throws Exception {
		System.out.println("Updating bal : " + currentThread().getName());
		balance = balance + amt;//5500
		System.out.println("Cancelling updates, after a dly");
		Thread.sleep(20);
		balance = balance - amt;
		System.out.println("Updations over by " + currentThread().getName());
	}// bal : 5000

	// chk balance
	public synchronized double checkBalance() throws Exception {
		System.out.println("Checking balance : by "+ currentThread().getName());
		Thread.sleep(37);
		return balance;

	}

}