package app.pojos;

import java.sql.Date;

public class Buddy {

	private String emailId;
	private String name;
	private long phoneNumber;
	private  Date dob;
	private String city;
	
	public Buddy(){
		
	}
	public Buddy(String emailId, String name, long phoneNumber, Date dob, String city) {
		super();
		this.emailId = emailId;
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.dob = dob;
		this.city = city;
	}

	/*
	 * public Buddy(String checkEmail, String next, long nextLong, java.util.Date
	 * checkDateOfBirth, String next2) { // TODO Auto-generated constructor stub }
	 */
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	@Override
	public String toString() {
		return "Buddy [emailId=" + emailId + ", name=" + name + ", phoneNumber=" + phoneNumber + ", dob=" + dob
				+ ", city=" + city + "]";
	}
	
	
}
