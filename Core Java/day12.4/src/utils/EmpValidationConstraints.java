package utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.app.core.Department;
import com.app.core.Emp;

import custom_exceptions.EmpHandlingException;

public class EmpValidationConstraints {
	public static SimpleDateFormat sdf;
	public static Date validJoinDate;
	static {
		sdf = new SimpleDateFormat("dd-MM-yyyy");
		try {
			validJoinDate = sdf.parse("31-12-2020");
		} catch (ParseException e) {
			System.out.println("err in static init block " + e);
		}
	}

	public static Emp validateEmpDetails(Emp[] emps, int id, String name, double salary, String joinDate, String dept)
			throws EmpHandlingException,ParseException {
		validateName(name);
		Date date = parseNValidateDate(joinDate);
		checkForDup(id, name, emps);
		Department department = validateDepartment(dept);
		return new Emp(id, name, salary, date, department);
	}

	public static String validateName(String name) throws EmpHandlingException {
		if (name.length() < 3)
			throw new EmpHandlingException("Name invalid !!!!!!!!!!");
		return name;
	}

	public static Date parseNValidateDate(String joinDate) throws ParseException, EmpHandlingException {
		Date d1=parseDate(joinDate);
		// validation rule : join date must be in this year
		if (d1.after(validJoinDate))
			throw new EmpHandlingException("Invalid join date.....");
		return d1;
	}

	// sample validation constraint on AdharCard : location must contain state code
	// as MH
	public static String validateAdharCardLocation(String location) throws EmpHandlingException {
		if (!location.contains("MH"))
			throw new EmpHandlingException("Invalid Adhar Card Location!!!!!");
		return location;
	}

	// check for duplicates
	public static void checkForDup(int id, String name, Emp[] emps) throws EmpHandlingException {
		Emp newEmp = new Emp(id, name);
		for (Emp e : emps)
			if (newEmp.equals(e))
				throw new EmpHandlingException("Dup Emp details detected!!!!!");
	}

	public static Department validateDepartment(String dept) {
		return Department.valueOf(dept.toUpperCase());
	}
	public static Date parseDate(String date) throws ParseException, EmpHandlingException {
		
		return sdf.parse(date);
	}
	
}
