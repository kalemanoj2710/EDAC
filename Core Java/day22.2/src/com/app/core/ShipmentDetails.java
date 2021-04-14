package com.app.core;
//ShipmentDetails : city,zipCode,phoneNo, shipmentDate 

import java.io.Serializable;
import java.time.LocalDate;

public class ShipmentDetails implements Serializable{
	private String city,zipCode,phoneNo;
	private LocalDate shipmentDate;
	public ShipmentDetails(String city, String zipCode, String phoneNo, LocalDate shipmentDate) {
		super();
		this.city = city;
		this.zipCode = zipCode;
		this.phoneNo = phoneNo;
		this.shipmentDate = shipmentDate;
	}
	@Override
	public String toString() {
		return " city=" + city + ", zipCode=" + zipCode + ", phoneNo=" + phoneNo + ", shipmentDate="
				+ shipmentDate ;
	}
	

}
