package dao;

import org.hibernate.*;
import static utils.HibernateUtils.getSf;

import pojos.Location;
import pojos.Vendor;

public class VendorDaoImpl implements IVendorDao {

	@Override
	public String registerVendor(Vendor v) {
		String mesg = "Vendor reg failed";
		// get session
		Session session = getSf().getCurrentSession();
		// begin tx
		Transaction tx = session.beginTransaction();
		try {
			session.persist(v);
			tx.commit();
			mesg = "vendor reg succeeded...";
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}
		return mesg;
	}

	@Override
	public Vendor fetchVendorDetails(String email) {
		Vendor v=null;
		String jpql="select v from Vendor v where v.email=:email";
		Session session = getSf().getCurrentSession();
		Transaction tx = session.beginTransaction();
		try {
			v=session.createQuery(jpql,Vendor.class).setParameter("email", email).getSingleResult();
			tx.commit();
			
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}
		return v;
	}

	@Override
	public Vendor fetchCompleteVendorDetails(String email) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String unsubscribeVendor(String email) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String assignVendorLocation(int vendorId, Location location) {
		String mesg="location assignement failed";
		Session session = getSf().getCurrentSession();
		Transaction tx = session.beginTransaction();
		try {
			//get vendor details from vid
			Vendor v=session.get(Vendor.class, vendorId);
			if(v != null)
			{
				//=> valid vendor id
				location.setCurrentVendor(v);//setting uni dir asso between Location ----> Vendor
				//save location details
				session.persist(location);
				mesg="Vendor "+v.getName()+" assigned the location...";
			}
			tx.commit();
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}
		return mesg;
	}

	@Override
	public String registerVendorWithLocation(Location location) {
		String mesg = "Vendor reg failed";
		// get session
		Session session = getSf().getCurrentSession();
		// begin tx
		Transaction tx = session.beginTransaction();
		try {
			session.persist(location.getCurrentVendor());
			session.persist(location);
			tx.commit();
			mesg = "vendor reg succeeded...";
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}
		return mesg;
	}



}
