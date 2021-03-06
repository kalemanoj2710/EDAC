package com.app.service;

import java.util.List;

import com.app.pojos.Vendor;

public interface IVendorService {
	Vendor authenticateUser(String email, String pwd);

	// Add a method for listing all vendors
	List<Vendor> getAllVendors();
}
