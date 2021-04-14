package dao;

import pojos.Course;
import static utils.HibernateUtils.getSf;

import java.util.List;

import org.hibernate.*;

public class CourseDaoImpl implements ICourseDao {

	@Override
	public String launchNewCourse(Course c) {
		String mesg = "launching new course failed...";
		Session session = getSf().getCurrentSession();
		Transaction tx = session.beginTransaction();
		try {
			session.persist(c);
			tx.commit();
			mesg = "launched new course with course id " + c.getId();
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}
		return mesg;
	}

	@Override
	public String cancelCourse(int courseId) {
		String mesg = "cancelling course failed...";
		Session session = getSf().getCurrentSession();
		Transaction tx = session.beginTransaction();
		try {
			// get course details from id
			Course c = session.get(Course.class, courseId);
			if (c != null)
				session.delete(c);// c : marked for removal
			tx.commit();// auto dirty chking : deletes all asso child recs n then parent rec
			mesg = "cancelled course : " + c.getTitle();

		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}
		return mesg;
	}

	@Override
	public Course getCourseDetails(String courseName) {
		Course c = null;
		String jpql = "select c from Course c join fetch  c.students where c.title=:title";
		Session session = getSf().getCurrentSession();
		Transaction tx = session.beginTransaction();
		try {
			c = session.createQuery(jpql, Course.class).setParameter("title", courseName).getSingleResult();
			// till now details fetched are : only course details
			//c : persistent
			//access the size of the collection
		//	c.getStudents().size();//select : students
			tx.commit();

		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}
		return c;//c :  DETACHED
	}

	@Override
	public List<String> fetchAllCourseNames() {
		List<String> courseNames=null;
		String jpql="select c.title from Course c";
		Session session = getSf().getCurrentSession();
		// begin tx
		Transaction tx = session.beginTransaction();
		try {
			courseNames=session.createQuery(jpql, String.class).getResultList();
			tx.commit();
			
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}
	
		return courseNames;
	}

}
