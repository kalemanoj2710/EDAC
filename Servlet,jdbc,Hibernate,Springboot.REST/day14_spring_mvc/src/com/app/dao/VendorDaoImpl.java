package com.app.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.app.pojos.Vendor;

@Repository // to tell SC about DAO layer bean + enables exc translation mechanism(catches
			// DB related
//excs n re throws them as spring related exceptions (un checked)
public class VendorDaoImpl implements IVendorDao {
	// dependency : SF
	@Autowired // byType
	private SessionFactory sf;

	@Override
	public Vendor authenticateUser(String email, String pwd) {
		String jpql = "select v from Vendor v where v.email=:em and v.password=:pass";
		return sf.getCurrentSession().createQuery(jpql, Vendor.class).setParameter("em", email)
				.setParameter("pass", pwd).getSingleResult();
	}

}
