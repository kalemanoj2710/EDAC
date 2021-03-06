package com.app.core;

import java.io.Serializable;
import java.time.LocalDate;

public class Product implements Serializable{
	private int id;
	private String name;
	private Category productCatgeory;
	private LocalDate manufactureDate;
	private double price;
	//HAS-A relationship
	private ShipmentDetails details;

	

	public Product(int id, String name, Category productCatgeory, LocalDate manufactureDate, double price) {
		super();
		this.id = id;
		this.name = name;
		this.productCatgeory = productCatgeory;
		this.manufactureDate = manufactureDate;
		this.price = price;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", productCatgeory=" + productCatgeory + ", manufactureDate="
				+ manufactureDate + ", price=" + price + "\n Shipping details"+details;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public Category getProductCatgeory() {
		return productCatgeory;
	}

	public LocalDate getManufactureDate() {
		return manufactureDate;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	//add a method to link shipment details to a product
	public void linkShipmentDetails(ShipmentDetails details)
	{
		this.details=details;//one to -one link is established.
	}
	
	

}
