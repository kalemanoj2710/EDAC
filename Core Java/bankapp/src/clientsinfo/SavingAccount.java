package clientsinfo;

public class SavingAccount extends BankAccounts {
private double intrest;
private double principle;
private int time;

public SavingAccount(String name,double balance,double principle,double intrest,int time) {
	
	super(name,"Saving",balance);
	this.intrest=intrest;
	this.principle=principle;
	this.time=time;	
}

@Override
public String toString() {
	return "Account Details"+super.toString();
}
public double computeTax() {
	double simpleIntrest = ((this.principle*this.intrest*this.time)/100)*0.05;
	super.balance=super.balance+simpleIntrest;
	double tax = simpleIntrest * 0.10;
	return tax;
	
}
}
