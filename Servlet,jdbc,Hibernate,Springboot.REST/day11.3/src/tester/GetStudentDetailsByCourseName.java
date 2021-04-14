package tester;

import static utils.HibernateUtils.getSf;

import java.util.Scanner;

import org.hibernate.SessionFactory;

import dao.StudentDaoImpl;
import pojos.Course;
import pojos.Student;

public class GetStudentDetailsByCourseName {

	public static void main(String[] args) {
		try (SessionFactory factory = getSf(); Scanner sc = new Scanner(System.in)) {

			// create dao instance
			StudentDaoImpl studentDao = new StudentDaoImpl();
			System.out.println(" Enter course title");
			studentDao.getStudentDetailsByCourseName(sc.next()).forEach(s -> {
				System.out.println("Basic student details");
				System.out.println(s);
				System.out.println("Adhat card details");
				System.out.println(s.getCard());
			});
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
