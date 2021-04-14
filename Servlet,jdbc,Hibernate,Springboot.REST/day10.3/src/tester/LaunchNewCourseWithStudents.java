package tester;

import static utils.HibernateUtils.getSf;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import org.hibernate.*;

import dao.CourseDaoImpl;
import pojos.Course;
import pojos.Student;

public class LaunchNewCourseWithStudents {

	public static void main(String[] args) {
		try (SessionFactory factory = getSf(); Scanner sc = new Scanner(System.in)) {
			// for conversion from string --> java.util.Date
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			// create dao instance
			CourseDaoImpl courseDao = new CourseDaoImpl();
			System.out.println(" Enter course details title,  startDate,  endDate,  fees,  capacity");
			Course c = new Course(sc.next(), sdf.parse(sc.next()), 
					sdf.parse(sc.next()), sc.nextDouble(), sc.nextInt());
			//accept student details
			while(true)
			{
				System.out.println("Enter student details or enter quit to exit");
				String name=sc.next();
				if(name.equalsIgnoreCase("quit"))
					break;
				c.addStudent(new Student(name, sc.next()));
			}
	
			System.out.println(courseDao.launchNewCourse(c));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
