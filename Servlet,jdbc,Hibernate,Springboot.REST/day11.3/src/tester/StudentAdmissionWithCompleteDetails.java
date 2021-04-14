package tester;

import static utils.HibernateUtils.getSf;
import static pojos.EduType.*;

import java.util.Scanner;

import org.hibernate.SessionFactory;

import dao.StudentDaoImpl;
import pojos.AdharCard;
import pojos.Course;
import pojos.EducationalQualifications;
import pojos.Student;
import static java.time.LocalDate.parse;

public class StudentAdmissionWithCompleteDetails {

	public static void main(String[] args) {
		try (SessionFactory factory = getSf(); Scanner sc = new Scanner(System.in)) {

			// create dao instance
			StudentDaoImpl studentDao = new StudentDaoImpl();
			System.out.println(" Enter student name , email");
			Student s = new Student(sc.next(), sc.next());
			System.out.println("Enter adhar card details : card no n date(yr-mon-day)");
			s.setCard(new AdharCard(sc.next(), parse(sc.next())));
			System.out.println("Enter qualification details : type yr marks");
			s.getQualifications()
					.add(new EducationalQualifications(valueOf(sc.next().toUpperCase()), sc.nextInt(), sc.nextInt()));
			System.out.println("Enter qualification details : type yr marks");
			s.getQualifications()
					.add(new EducationalQualifications(valueOf(sc.next().toUpperCase()), sc.nextInt(), sc.nextInt()));
			System.out.println("Enter course id");
			System.out.println(studentDao.admitStudentWithCompleteDetails(s, sc.nextInt()));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
