package com.app.dao;

import java.util.List;

import com.app.pojos.Vendor;

public interface IVendorDao {
	//Add a method for user authentication
	Vendor authenticateUser(String email, String pwd);
	//Add a method for listing all vendors
	List<Vendor> getAllVendors();
	
}
