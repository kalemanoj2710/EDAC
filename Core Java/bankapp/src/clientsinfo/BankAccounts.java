package clientsinfo;

public abstract class BankAccounts {
public int acctNo;
public static int accountNoGenerator;
private String name;
private String type;
public double balance;
static {
	accountNoGenerator =1000;
}

public BankAccounts(String name,String type,double balance) {
	this.acctNo=accountNoGenerator++;
	this.name=name;
	this.type=type;
	this.balance=balance;
}
@Override
public String toString() {
	return "\nName Of Account Holder :"+name+"\n Account No : "+acctNo+" \n Type of Account :"+type+" \n Account Balance:  "+balance;
	
}

public  abstract double computeTax();

public double withdraw(double amount) {

	return this.balance-=amount;
}
public double deposit(double amount) {
	return this.balance+=amount;
}


}
