package com.app.pojos;

import java.time.LocalDate;

public class Product {
	private int pid;
	private String name;
	private double price;
	private LocalDate expDate;

	public Product() {
		// TODO Auto-generated constructor stub
	}

	public Product(int pid, String name, double price, LocalDate expDate) {
		super();
		this.pid = pid;
		this.name = name;
		this.price = price;
		this.expDate = expDate;
	}

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public LocalDate getExpDate() {
		return expDate;
	}

	public void setExpDate(LocalDate expDate) {
		this.expDate = expDate;
	}

	@Override
	public String toString() {
		return "Product [pid=" + pid + ", name=" + name + ", price=" + price + ", expDate=" + expDate + "]";
	}

}
