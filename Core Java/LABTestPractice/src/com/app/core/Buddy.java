package com.app.core;

import java.time.LocalDate;

public class Buddy {
	private String email;
	private String name;
	private int phone;
	private LocalDate dob;
	private String city;

	public Buddy(String email, String name, int phone, LocalDate dob, String city) {
		this.email = email;
		this.name = name;
		this.phone = phone;
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

	public int getPhone() {
		return this.phone;
	}

	@Override
	public String toString() {
		return "Name=" + name + " ,email=" + email + ", phone=" + phone + ", dob=" + dob + ", city=" + city;
	}
}
