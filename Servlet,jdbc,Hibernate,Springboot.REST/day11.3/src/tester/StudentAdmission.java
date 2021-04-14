package tester;

import static utils.HibernateUtils.getSf;

import java.util.Scanner;

import org.hibernate.SessionFactory;

import dao.StudentDaoImpl;
import pojos.Course;
import pojos.Student;

public class StudentAdmission {

	public static void main(String[] args) {
		try (SessionFactory factory = getSf(); Scanner sc = new Scanner(System.in)) {
			
			// create dao instance
			StudentDaoImpl studentDao=new StudentDaoImpl();
			System.out.println(" Enter student name , email n course title");
			System.out.println(studentDao.admitStudent(new Student(sc.next(), sc.next()), sc.next()));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
