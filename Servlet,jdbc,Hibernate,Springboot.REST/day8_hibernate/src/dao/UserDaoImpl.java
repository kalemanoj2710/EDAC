package dao;

import pojos.User;
import static utils.HibernateUtils.getSf;
import org.hibernate.*;

public class UserDaoImpl implements IUserDao {

	@Override
	public String registerUser(User user) {
		String  mesg="user reg failed...";
		// get session from session factory
		Session session = getSf().openSession();//L1 cache is opened: empty 
		// begin transaction
		Transaction tx = session.beginTransaction();//Db connection is pooled out n attached to hibernate session
		System.out.println("is open"+session.isOpen()+"is connected"+session.isConnected());// true true
		try {
            //user registration
			Integer id=(Integer)session.save(user);
			
			tx.commit();
			mesg="user reg successfully with ID"+id;
		} catch (RuntimeException e) {
			// roll back tx re-throw the exc to caller
			if (tx != null)
				tx.rollback();
			throw e;
		} finally {
			// close the session
			if (session != null)
				session.close();
		}
		System.out.println("is open"+session.isOpen()+"is connected"+session.isConnected());// f f

		return mesg;
		
	}

}
