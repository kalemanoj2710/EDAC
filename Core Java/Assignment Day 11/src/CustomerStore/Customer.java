package CustomerStore;

import java.util.Date;
import static Tester.CustomerRegistration.sdf;

public class Customer {

	private String Email;
	private String Password;
	private String Name;
	private String city;
	private double Reg_Amt;
	private Date bday;
	private String PhoneNo;

	// Enum
	private CustomerType Customer_Type;
	// one to one association between Emp n AdharCard : composition
	private CustomerAddress SaveAddress;

	public Customer(String email, Date bday, String password, String name, double reg_Amt, CustomerType Customer_Type) {
		super();
		Email = email;
		Password = password;
		Name = name;
		Reg_Amt = reg_Amt;
		this.bday = bday;
		this.Customer_Type = Customer_Type;

	}

	/*
	 * @Override public boolean equals(Object o) { if (o instanceof Customer) return
	 * Email == ((Customer) o).Email; return false; }
	 */

	public String getEmail() {
		return Email;
	}

	public String getCity() {
		return city;
	}

	public Date getDate() {
		return bday;

	}

	public String getPassword() {
		return Password;
	}

	public String getPhone() {
		return PhoneNo;
	}

	public void setPhone(String PhoneNo) {
		SaveAddress.PhoneNo = PhoneNo;
	}

	@Override
	public String toString() {
		return "Customer Details \n************************\n Email=" + Email + "\nPassword=" + Password + "\nName="
				+ Name + "\nReg_Amt=" + Reg_Amt + "\nBirthday : " + sdf.format(bday) + "\nCustomer Type : "
				+ Customer_Type + "\n************************\nCustomer Address : " + SaveAddress;
	}

	public void Address(String city1, String state1, String country1, String phoneNo1) {
		SaveAddress = new CustomerAddress(city1, state1, country1, phoneNo1);
	}

	private class CustomerAddress {

		private String city;
		private String State;
		private String Country;
		private String PhoneNo;

		public CustomerAddress(String city, String state, String country, String phoneNo) {
			super();
			this.city = city;
			State = state;
			Country = country;
			PhoneNo = phoneNo;
			Customer.this.city = city;
			Customer.this.PhoneNo = phoneNo;
		}

		@Override
		public String toString() {
			return "\nCity => " + city + "\nState => " + State + "\nCountry => " + Country + "\nPhoneNo => " + PhoneNo;
		}
	}
}
