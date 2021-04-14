package dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import static utils.HibernateUtils.getSf;

import pojos.Course;
import pojos.Student;

public class StudentDaoImpl implements IStudentDao {

	@Override
	public String admitStudent(Student student, String courseTitle) {
		String mesg = "student admission failed...";
		String jpql = "select c from Course c where c.title = :title";
		Session session = getSf().getCurrentSession();
		Transaction tx = session.beginTransaction();
		try {
			// get course details by course title
			Course c = session.createQuery(jpql, Course.class).
					setParameter("title", courseTitle).getSingleResult();
			//c : PERSISTENT
			//If you update the state of the persistent entity : hibernate auto propagates changes to DB
			//add student ref to Course
			c.getStudents().add(student);
			tx.commit();
			mesg = "student admission done";
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}
		return mesg;
	}

}
