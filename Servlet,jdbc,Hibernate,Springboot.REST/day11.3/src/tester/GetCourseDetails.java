package tester;

import static utils.HibernateUtils.getSf;

import java.util.Scanner;

import org.hibernate.SessionFactory;

import dao.CourseDaoImpl;
import dao.StudentDaoImpl;
import pojos.Course;
import pojos.Student;

public class GetCourseDetails {

	public static void main(String[] args) {
		try (SessionFactory factory = getSf(); Scanner sc = new Scanner(System.in)) {
			
			// create dao instance
			CourseDaoImpl courseDao=new CourseDaoImpl();
			System.out.println(" Enter course title");
			System.out.println("Course Details");
			Course c=courseDao.getCourseDetails(sc.next());
			System.out.println(c);
			System.out.println("Student details associated with the course ");
			c.getStudents().forEach(System.out::println);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
