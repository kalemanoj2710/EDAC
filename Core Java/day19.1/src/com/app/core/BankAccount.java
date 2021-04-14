package com.app.core;

import java.time.LocalDate;

import custom_exception.AccountHandlingException;

import static utils.BankValidationRules.*;

public class BankAccount {
	private int acctNo;
	private String customerName;
	private AcType acctType;
	private double balance;
	private LocalDate createdOn;
	public BankAccount(int acctNo, String customerName, AcType acctType, double balance, LocalDate createdOn) {
		super();
		this.acctNo = acctNo;
		this.customerName = customerName;
		this.acctType = acctType;
		this.balance = balance;
		this.createdOn = createdOn;
	}
	@Override
	public String toString() {
		return "BankAccount [acctNo=" + acctNo + ", customerName=" + customerName + ", acctType=" + acctType
				+ ", balance=" + balance + ", createdOn=" + createdOn + "]";
	}
	//B.L methods
	public void deposit(double amount)
	{
		balance += amount;
	}
	public void withdraw(double amount) throws AccountHandlingException
	{
		validateBalance(balance-amount);
		balance -= amount;
	}
	public void transferFunds(BankAccount dest,double amt)  throws AccountHandlingException
	{
		this.withdraw(amt);
		dest.deposit(amt);
	}
	//apply interest
	public void applyInterest(double rate)
	{
		//period = 1yr
		double simpleInt=(balance*rate)/100;
		deposit(simpleInt);
	}
	//getters
	public int getAcctNo() {
		return acctNo;
	}
	public String getCustomerName() {
		return customerName;
	}
	public AcType getAcctType() {
		return acctType;
	}
	public double getBalance() {
		return balance;
	}
	public LocalDate getCreatedOn() {
		return createdOn;
	}
	
	
	

}
