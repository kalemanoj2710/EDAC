package clientsinfo;

public class LoanAccount extends BankAccounts{
	private int noOffInstallment;
	private double emi;
    public LoanAccount(String name, double balance,int noOffInstallment,double emi) {
		super(name, "Loan", balance);
		this.noOffInstallment=noOffInstallment;
		this.emi=emi;	
	}
    @Override
    public String toString() {
    	return "Account Details : "+super.toString()+"\n No of Instalment :"+this.noOffInstallment+"\n EMI : "+this.emi;
    }
    public double computeTax() {
    	double tax=(super.balance*0.05)-(this.emi*0.01);
  		return tax;
  	}


}
