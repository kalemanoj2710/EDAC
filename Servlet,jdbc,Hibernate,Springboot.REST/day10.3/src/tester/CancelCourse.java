package tester;

import static utils.HibernateUtils.getSf;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import org.hibernate.*;

import dao.CourseDaoImpl;
import pojos.Course;

public class CancelCourse {

	public static void main(String[] args) {
		try (SessionFactory factory = getSf(); Scanner sc = new Scanner(System.in)) {
				// create dao instance
			CourseDaoImpl courseDao = new CourseDaoImpl();
			System.out.println(" Enter course id to cancel");
				System.out.println(courseDao.cancelCourse(sc.nextInt()));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
