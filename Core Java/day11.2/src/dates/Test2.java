package dates;

import java.text.SimpleDateFormat;
import java.util.Scanner;

import com.app.core.Emp;

import custom_exceptions.EmpHandlingException;

public class Test2 {
	public static SimpleDateFormat sdf;
	static {
		sdf = new SimpleDateFormat("yyyy-MM-dd");
	}

	public static void main(String[] args) {

		// Accept emp details n create emp instance
		try (Scanner sc = new Scanner(System.in)) {
			System.out.println("Enter 1st emp details : id nm sal join date(yr-mon-day) ");
			Emp e1 = new Emp(sc.nextInt(), sc.next(), sc.nextDouble(), sdf.parse(sc.next()));
			// accept another emp details n chk for dup (id & name)
			System.out.println("Enter 2nd emp details : id nm sal join date(yr-mon-day) ");
			Emp e2 = new Emp(sc.nextInt(), sc.next(), sc.nextDouble(), sdf.parse(sc.next()));
			System.out.println(e1.equals(e2));
			// create a string n chk equals
			String s = "hello";
			System.out.println(e1.equals(s));// false
			// supply null n chk equals
			Emp e = null;
			System.out.println(e1.equals(e));// false
			// create Emp[] to hold emp details
			Emp[] emps = { e1, e2 };// 1 new array object is getting created.
			// Accept new emp details from user
			// add a static method in the same class : to chk for dup
			// in case of a dup : throw exc , o.w continue n create 3rd emp object
			System.out.println("Enter 3rd emp details");
			int empId = sc.nextInt();
			String eName = sc.next();
			checkForDups(emps, empId, eName);
			System.out.println("No dups found!!!!!");
			Emp e3 = new Emp(empId, eName, sc.nextDouble(), sdf.parse(sc.next()));
			System.out.println(e3);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	private static void checkForDups(Emp[] empData, int id, String name) throws EmpHandlingException {
		Emp e1 = new Emp(id, name);
		for (Emp e : empData)
			if (e.equals(e1))
				throw new EmpHandlingException("Dup Emp details found!!!!!!!!");
	}

}
