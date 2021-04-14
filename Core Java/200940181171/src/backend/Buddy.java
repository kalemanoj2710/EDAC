package backend;

import java.io.Serializable;
import java.time.LocalDate;


public class Buddy  {
private String email;
private String name;
private String phoneNo;
private LocalDate dob;
private String city;
public Buddy(String email, String name, String phoneNo, LocalDate dob, String city) {
	super();
	this.email = email;
	this.name = name;
	this.phoneNo = phoneNo;
	this.dob = dob;
	this.city = city;
}


public String getEmail() {
	return email;
}


public void setEmail(String email) {
	this.email = email;
}


public String getName() {
	return name;
}


public void setName(String name) {
	this.name = name;
}


public String getPhoneNo() {
	return phoneNo;
}


public void setPhoneNo(String phoneNo) {
	this.phoneNo = phoneNo;
}


public LocalDate getDob() {
	return dob;
}


public void setDob(LocalDate dob) {
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
	return "Buddy Details \n Email=" + email + "\n Name=" + name + "\n phoneNo=" + phoneNo + "\n dob=" + dob + "\n city=" + city;
}

@Override
public boolean equals(Object obj) {
	if (obj instanceof Buddy) {
		Buddy b = (Buddy) obj;
		return this.email.equals(b.email);
	}
	return false;
}


}
