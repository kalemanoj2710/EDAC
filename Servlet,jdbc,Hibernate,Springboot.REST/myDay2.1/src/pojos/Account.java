package pojos;

public class Account {
	private int accNo;
	private String customerName, acType;
	private double balance;

	public Account() {

	}

	public Account(int accNo, String customerName, String acType, double balance) {
		super();
		this.accNo = accNo;
		this.customerName = customerName;
		this.acType = acType;
		this.balance = balance;
	}

	public int getAccNo() {
		return accNo;
	}

	public void setAccNo(int accNo) {
		this.accNo = accNo;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getAcType() {
		return acType;
	}

	public void setAcType(String acType) {
		this.acType = acType;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	@Override
	public String toString() {
		return "Account [accNo=" + accNo + ", customerName=" + customerName + ", acType=" + acType + ", balance="
				+ balance + "]";
	}

}
