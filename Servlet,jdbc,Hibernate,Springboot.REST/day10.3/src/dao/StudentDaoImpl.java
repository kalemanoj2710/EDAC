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
			//This approach will work BUT along with cascading
			 //will add it later
			//Can this work w/o cascading ? YES
			//for bi-dir : asso --
		//	c.getStudents().add(student);
			//use case : uni dir association many-to-one : efficient
			//establish the link from student --> course
			//establish the link from course -->student
	//		c.getStudents().add(student);
	//		student.setSelectedCourse(c);//for establishing rev asso from child -->parent
	//		System.out.println(student.getSelectedCourse());//not null
	//		session.persist(student);
			c.addStudent(student);
			tx.commit();
			mesg = "student admission done";
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}
		return mesg;
	}

	@Override
	public String cancelAdmission(String courseName, int studentId) {
		String jpql="select c from Course c where c.title=:title";
		String mesg = "cancelling  admission failed...";
		Session session=getSf().getCurrentSession();
		Transaction tx=session.beginTransaction();
		try {
			//get course details from course name
			Course c=session.createQuery(jpql, Course.class).setParameter("title", courseName).getSingleResult();
			//get student details from student id
			Student s=session.get(Student.class, studentId);
			if(s != null) {
				c.removeStudent(s);
				mesg="cancelled admission for student "+s.getName();
			}
			tx.commit();
			
		} catch (RuntimeException e) {
			if(tx != null)
				tx.rollback();
			throw e;
		}
		return mesg;
	}
	

}
