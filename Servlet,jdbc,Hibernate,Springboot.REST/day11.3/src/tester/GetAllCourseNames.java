package tester;

import static utils.HibernateUtils.getSf;

import java.util.Scanner;

import org.hibernate.SessionFactory;

import dao.CourseDaoImpl;
import dao.StudentDaoImpl;
import pojos.Course;
import pojos.Student;

public class GetAllCourseNames {

	public static void main(String[] args) {
		try (SessionFactory factory = getSf(); ) {
			
			// create dao instance
			CourseDaoImpl courseDao=new CourseDaoImpl();
			System.out.println("Available courses ");
			courseDao.fetchAllCourseNames().forEach(System.out::println);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
