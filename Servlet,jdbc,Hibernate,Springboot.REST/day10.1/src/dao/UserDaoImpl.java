package dao;

import pojos.Role;
import pojos.User;

import org.apache.commons.io.FileUtils;
import org.hibernate.*;
import static utils.HibernateUtils.getSf;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
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
			session.persist(user);// user ref is simply added under L1 : PERSISTENT
			// success
			tx.commit();// hibernate performs auto dirty chking @ commit : DML : insert query & L1 cache
						// is destroyed n db conn rets to the pool , closing the session
			// user : DEATCHED : from L1 cache
			mesg = "user reged successfully , ID =" + user.getUserId();
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
			// Session API : public <T> T get(Class<T> pojoCls,Serializable id) throws
			// HibernateException
			u = session.get(User.class, userId);// int ---> Integer --> Serializable
			u = session.get(User.class, userId);// int ---> Integer --> Serializable
			u = session.get(User.class, userId);// int ---> Integer --> Serializable // u : in case of valid id :
												// PERSISTENT
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
		String jpql = "select u from User u";// select * from users_tbl
		List<User> userList = null;
		// get session
		Session session = getSf().getCurrentSession();
		// begin tx
		Transaction tx = session.beginTransaction();
		try {
			userList = session.createQuery(jpql, User.class).getResultList();
			// execute query --RST --processing of RST : User's def ctor --setters -ref will
			// be added to
			// L1 cache --will also be added to list.
			// Method rets list of persistent pojos/enitites to the caller.
			// The results of getResultList are not cached auto.
			// You will have explicitly enable Query level cache, to experiecne it.
			tx.commit();
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback(); // L1 cache
			// is destroyed n db conn rets to the pool , closing the session
			throw e;
		}
		return userList;
	}

	@Override
	public List<User> fetchSelectedUserDetails(LocalDate start, LocalDate end1, Role userRole) {
		List<User> users = null;
		String jpql = "select u from User u where u.regDate between :strt and :end and u.userRole = :rl";
		// get session
		Session session = getSf().getCurrentSession();
		// begin tx
		Transaction tx = session.beginTransaction();
		try {
			users = session.createQuery(jpql, User.class).setParameter("strt", start).setParameter("end", end1)
					.setParameter("rl", userRole).getResultList();
			// users : list of persistent pojos
			tx.commit();
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback(); // L1 cache
			// is destroyed n db conn rets to the pool , closing the session
			throw e;
		}
		return users;// users : list of detached pojos
	}

	@Override
	public User authenticateUser(String email, String pwd) {
		String jpql = "select u from User u where u.email=:em and u.password=:pass";
		User u = null;
		// get session
		Session session = getSf().getCurrentSession();
		// begin tx
		Transaction tx = session.beginTransaction();
		try {
			u = session.createQuery(jpql, User.class).setParameter("em", email).setParameter("pass", pwd)
					.getSingleResult();
			tx.commit();
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback(); // L1 cache
			// is destroyed n db conn rets to the pool , closing the session
			throw e;
		}
		return u;// u : detached
	}

	@Override
	public List<String> fetchSelectedUserNames(LocalDate start, LocalDate end1, Role userRole) {
		List<String> names = null;
		String jpql = "select u.name from User u where u.regDate between :strt and :end and u.userRole = :rl";

		// get session
		Session session = getSf().getCurrentSession();
		// begin tx
		Transaction tx = session.beginTransaction();
		try {
			names = session.createQuery(jpql, String.class).setParameter("strt", start).setParameter("end", end1)
					.setParameter("rl", userRole).getResultList();
			tx.commit();
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback(); // L1 cache
			// is destroyed n db conn rets to the pool , closing the session
			throw e;
		}
		return names;
	}

	@Override
	public List<User> fetchSelectedUserDetailsConstrExpr(LocalDate start, LocalDate end1, Role userRole) {
		List<User> users = null;
		String jpql = "select new pojos.User(name,regAmount,regDate)  from User u where u.regDate between :strt and :end and u.userRole = :rl";
		// get session
		Session session = getSf().getCurrentSession();
		// begin tx
		Transaction tx = session.beginTransaction();
		try {
			users = session.createQuery(jpql, User.class).setParameter("strt", start).setParameter("end", end1)
					.setParameter("rl", userRole).getResultList();
			// users : list of persistent pojos
			tx.commit();
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback(); // L1 cache
			// is destroyed n db conn rets to the pool , closing the session
			throw e;
		}
		return users;// users : list of detached pojos

	}

	@Override
	public String changePassword(int userId, String newPwd) {
		String mesg = "Password updation failed!!!!!";
		// get session
		Session session = getSf().getCurrentSession();
		// begin tx
		Transaction tx = session.beginTransaction();
		User u = null;
		try {
			// get user details by id : Session's get API
			u = session.get(User.class, userId);
			if (u != null) {
				// valid id u : PERSISTENT (as it exists in L1 cache)
				u.setPassword(newPwd); // updating state of PERSISTENT POJO
				// evict :
				session.evict(u);// u : DETACHED
				mesg = "password updated....";
			}
			tx.commit();// hib auto performs auto dirty chking : update query, l1 cache is destroyed ,
						// db cn rets to the pool, session closed
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback(); // L1 cache
			// is destroyed n db conn rets to the pool , closing the session
			throw e;
		}
		if (u != null)
			u.setPassword("9999");// updating state of DETACHED pojo : no auto dirty chking
		return mesg;
	}

	@Override
	public String applyDiscount(double discount, LocalDate date) {
		String mesg = "Applying discount failed..";
		String jpql = "update User u set u.regAmount=u.regAmount-:amt where u.userRole=:role and u.regDate < :dt";
		Session session = getSf().getCurrentSession();
		Transaction tx = session.beginTransaction();
		try {
			int updateCount = session.createQuery(jpql).setParameter("amt", discount)
					.setParameter("role", Role.CUSTOMER).setParameter("dt", date).executeUpdate();
			tx.commit();
			mesg = "Updated reg amount for " + updateCount + " customers";
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}
		return mesg;
	}

	@Override
	public String deleteUserDetails(int userId) {
		String mesg = "user un subscription failed";
		Session session = getSf().getCurrentSession();
		Transaction tx = session.beginTransaction();
		try {
			// get user details from id
			User user = session.get(User.class, userId);
			if (user != null) {
				// user : persistent
				session.delete(user);// user : REMOVED (marked for removal)
				// session.evict(user);
				mesg = "user un subscription succeeded";
			}

			tx.commit(); // auto dirty chking : delete query fired , L1 cache is destroyed , db cn rets
							// to
			// the conn pool : session is closed
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}
		// user : transient
		return mesg;
	}// user obj is marked for GC

	@Override
	public String saveImage(String email, String imageFilePath) throws IOException {
		String mesg = "saving image failed , invalid email id";
		String jpql = "select u from User u where u.email=:em";
		Session session = getSf().getCurrentSession();
		Transaction tx = session.beginTransaction();
		try {
			// get user details from db by email
			User u = session.createQuery(jpql, User.class).setParameter("em", email).getSingleResult();
			// u => persistent
			// validate file
			// create file class instance
			File file = new File(imageFilePath);
			if (file.exists() && file.isFile() && file.canRead()) {
				// API of FileUtils class
				/*
				 * public static byte[] readFileToByteArray(File file) throws IOException
				 */
				u.setImage(FileUtils.readFileToByteArray(file));// updating the state of perssitent pojo
				mesg = "saving image succeeded!";
			} else
				mesg = "saving image failed  : invalid image path";
			tx.commit();// update query is fired.

		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}
		return mesg;
	}

	@Override
	public String restoreImage(int userId, String destImageFilePath) throws IOException {
		String mesg = "restoring image failed , invalid user id";
		Session session = getSf().getCurrentSession();
		Transaction tx = session.beginTransaction();
		try {
			// get user details from PK : get
			User u = session.get(User.class, userId);
			if (u != null) {
				File f1 = new File(destImageFilePath);
				System.out.println(f1);
				// FileUtils API
				/*
				 * public static void writeByteArrayToFile(File file, byte[] data) throws
				 * IOException
				 */
				byte[] image = u.getImage();
				if (image != null) {
					FileUtils.writeByteArrayToFile(f1, image);
					mesg = "Image file restored successfully...";
				}
			}
			tx.commit();

		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}
		return mesg;
	}

}
