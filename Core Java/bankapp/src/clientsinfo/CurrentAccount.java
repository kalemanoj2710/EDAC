package clientsinfo;

public class CurrentAccount extends BankAccounts{
	public CurrentAccount(String name,double balance) {
		super(name,"Current",balance);
	}
  @Override
 public double computeTax() {
		
		double tax=super.balance*0.01;
		return tax;
	}
  public String tostring() {
	  
	  return "Account Details : "+super.toString();
  }
}
