package backend;

public class Customer {
public String email;
private String password;
private String name;
private double registrationAmount;
public String city;
public Customer(String email,String password,String name,double registrationAmount,String city) {
	this.email=email;
	this.password=password;
	this.name=name;
	this.registrationAmount=registrationAmount;
	this.city=city;
}

public String getCity() {
	return city;
}

public void setCity(String city) {
	this.city = city;
}

public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}

@Override
public String toString() {
	return "Customer Details : \n Name: "+name+"\n Email: "+email+"\n Password: "+password+"\n Registration Amount: "+registrationAmount+"\n City: "+city;
}
}
