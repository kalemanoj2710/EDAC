package com.app.dao;

import com.app.pojos.Vendor;

public interface IVendorDao {
	Vendor authenticateUser(String email, String pwd);
}
