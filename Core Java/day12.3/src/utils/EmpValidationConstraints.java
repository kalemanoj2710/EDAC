package utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

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

	public static String validateName(String name) throws EmpHandlingException {
		if (name.length() < 3)
			throw new EmpHandlingException("Name invalid !!!!!!!!!!");
		return name;
	}

	public static Date parseNValidateDate(String joinDate) throws ParseException,EmpHandlingException
	{
		Date d1=sdf.parse(joinDate);
		//validation rule : join date must be in this year
		if(d1.after(validJoinDate))
			throw new EmpHandlingException("Invalid join date.....");
		return d1;
	}
}
