package com.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.IVendorDao;
import com.app.pojos.Vendor;

@Service//to tell SC class is a spring bean containing B.L 
@Transactional //to tell SC , to automate tx management 
//(by spring supplied hib tx mgr bean : o.s.orm.hibernate5.HibernateTransactionManager
public class VendorServiceImpl implements IVendorService {
	//dependency : DAO layer i/f
	@Autowired
	private IVendorDao vendorDao;

	@Override
	public Vendor authenticateUser(String email, String pwd) {
		// TODO Auto-generated method stub
		return vendorDao.authenticateUser(email, pwd);
	}

}
