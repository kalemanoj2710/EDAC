package tester;

import static utils.HibernateUtils.getSf;

import java.util.Scanner;

import org.hibernate.SessionFactory;

import dao.StudentDaoImpl;
import pojos.Course;
import pojos.Student;

public class CancelStudentAdmission {

	public static void main(String[] args) {
		try (SessionFactory factory = getSf(); Scanner sc = new Scanner(System.in)) {
			
			// create dao instance
			StudentDaoImpl studentDao=new StudentDaoImpl();
			System.out.println(" Enter course name ,n student id");
			System.out.println(studentDao.cancelAdmission(sc.next(), sc.nextInt()));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
