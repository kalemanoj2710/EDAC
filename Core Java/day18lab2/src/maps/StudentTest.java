package maps;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Scanner;

import com.app.core.Course;
import com.app.core.Student;

import custom_exception.AccountHandlingException;

public class StudentTest {
	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {

			HashMap<String, Student> data = new HashMap<>();
			boolean exit = false;

			while (!exit) {
				System.out.println(
						"options : 1. Student Addmission 2. Fetch Student Data 3. Display All Student Details 4. Update Marks 5. Cancel Addmission 6. Display Student By Their Course");
				try {
					switch (sc.nextInt()) {
					case 1:
						System.out.println("Enter Student Details: Student_id, Course, Name, Marks, Birthdate");
                        String student_id=sc.next();
                        if(data.containsKey(student_id))
                        	throw new AccountHandlingException("Dup Student id..");
                         System.out.println(data.put(student_id, new Student(student_id, valueOf(sc.next().toUpperCase()), sc.next(), sc.nextInt(), parse(sc.next()))));
						System.out.println("Addmission successful1");
                         break;
					case 2:

						break;
					case 3:

						break;

					}

				} catch (Exception e) {
					e.printStackTrace();
				}
			}

		}
	}

	private static LocalDate parse(String next) {
		// TODO Auto-generated method stub
		return null;
	}

	private static Course valueOf(String upperCase) {
		// TODO Auto-generated method stub
		return null;
	}
}
