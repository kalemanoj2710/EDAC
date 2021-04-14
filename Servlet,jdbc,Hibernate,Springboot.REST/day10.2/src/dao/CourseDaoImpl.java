package dao;

import pojos.Course;
import static utils.HibernateUtils.getSf;
import org.hibernate.*;

public class CourseDaoImpl implements ICourseDao {

	@Override
	public String launchNewCourse(Course c) {
		String mesg="launching new course failed...";
		Session session=getSf().getCurrentSession();
		Transaction tx=session.beginTransaction();
		try {
			session.persist(c);
			tx.commit();
			mesg="launched new course with course id "+c.getId();
		} catch (RuntimeException e) {
			if(tx != null)
				tx.rollback();
			throw e;
		}
		return mesg;
	}

}
