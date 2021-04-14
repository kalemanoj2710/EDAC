package com.app.core;

import java.time.LocalDate;

public class MyBuddy {
	private String email;
	private String name;
	private long phoneNumber;
	private LocalDate dob;
	private String city;

	public MyBuddy(String email, String name, long phone, LocalDate dob, String city) {
		this.email = email;
		this.name = name;
		this.phoneNumber = phone;
		this.dob = dob;
		this.city = city;
	}

	public String getEmail() {
		return this.email;
	}

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	public long getPhoneNumber() {
		return this.phoneNumber;
	}

	@Override
	public String toString() {
		return "Name=" + name + " ,email=" + email + ", phone=" + phoneNumber + ", dob=" + dob + ", city=" + city;
	}
}
