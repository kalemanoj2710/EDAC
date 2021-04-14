package dao;

import pojos.User;
import org.hibernate.*;
import static utils.HibernateUtils.getSf;

import java.util.List;

public class UserDaoImpl implements IUserDao {

	@Override
	public String registerUser(User user) {
		// user : exists only in heap , not in L1 cache , not in DB : TRANSIENT
		String mesg = "user registration failed...";
		// get session from SF
		Session session = getSf().openSession();
		Session session2 = getSf().openSession();
		System.out.println("sessions same " + (session == session2));// false
		// begin tx
		Transaction tx = session.beginTransaction(); // L1 cache is created : EMPTY
		System.out
				.println("is session open ?" + session.isOpen() + " is connected with db cn " + session.isConnected());// t
																														// t

		try {
			Integer id = (Integer) session.save(user);// user ref is simply added under L1 : PERSISTENT
			// success
			tx.commit();// hibernate performs auto dirty chking @ commit : DML : insert query
			mesg = "user reged successfully , ID =" + id;
			System.out.println(
					"is session open ?" + session.isOpen() + " is connected with db cn " + session.isConnected());// t t

		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		} finally {
			if (session != null)
				session.close();// L1 cache is destroyed n db conn rets to the pool , closing the session
		}
		System.out
				.println("is session open ?" + session.isOpen() + " is connected with db cn " + session.isConnected());// f
																														// f

		// user : DETACHED
		return mesg;
	}

	@Override
	public String registerUserWithGetCurntSession(User user) {
		String mesg = "user registration failed...";
		// get session from SF : getCurrentSession
		Session session = getSf().getCurrentSession();
		Session session2 = getSf().getCurrentSession();
		System.out.println(session == session2);// true
		// begin tx
		Transaction tx = session.beginTransaction();
		System.out
				.println("is session open ?" + session.isOpen() + " is connected with db cn " + session.isConnected());// t
																														// t
		try {
			Integer id = (Integer) session.save(user);// user ref is simply added under L1 : PERSISTENT
			// success
			tx.commit();// hibernate performs auto dirty chking @ commit : DML : insert query & L1 cache
						// is destroyed n db conn rets to the pool , closing the session
			mesg = "user reged successfully , ID =" + id;
			System.out.println(
					"is session open ?" + session.isOpen() + " is connected with db cn " + session.isConnected());// t t

		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback(); // L1 cache
			// is destroyed n db conn rets to the pool , closing the session
			System.out.println("rollback : is session open ?" + session.isOpen() + " is connected with db cn "
					+ session.isConnected());// t t

			throw e;
		}
		return mesg;
	}

	@Override
	public User getUserDetails(int userId) {
		User u = null;// u : NA 
		// get session
		Session session = getSf().getCurrentSession();
		// begin tx
		Transaction tx = session.beginTransaction();
		try {
			//Session API : public <T> T get(Class<T> pojoCls,Serializable id) throws HibernateException
			u=session.get(User.class,userId);//int ---> Integer --> Serializable
			u=session.get(User.class,userId);//int ---> Integer --> Serializable
			u=session.get(User.class,userId);//int ---> Integer --> Serializable // u : in case of valid id : PERSISTENT
			tx.commit();
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback(); // L1 cache
			// is destroyed n db conn rets to the pool , closing the session
			throw e;
		}
		return u;// u : DETACHED
	}

	@Override
	public List<User> fetchAllUserDetails() {
		String jpql="select u from User u";
		List<User> userList=null;
		// get session
				Session session = getSf().getCurrentSession();
				// begin tx
				Transaction tx = session.beginTransaction();
				try {
					userList=session.createQuery(jpql, User.class).getResultList();
					tx.commit();
				} catch (RuntimeException e) {
					if (tx != null)
						tx.rollback(); // L1 cache
					// is destroyed n db conn rets to the pool , closing the session
					throw e;
				}
		return userList;
	}

}
