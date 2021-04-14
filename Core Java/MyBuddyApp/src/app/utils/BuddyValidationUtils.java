package app.utils;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import app.Custom_Exceptions.BuddyExceptionHandling;

public class BuddyValidationUtils {

	public static SimpleDateFormat sdf;
	
	public static String checkEmail(String email1) throws BuddyExceptionHandling {
		if(!(email1.contains("@") && email1.endsWith(".com")))
			throw  new BuddyExceptionHandling("Invalid email... should contain @ and end with .com");
		return email1;
	}
	
	public static Date checkDateOfBirth(String dateOfBirth1) throws BuddyExceptionHandling, ParseException {
		sdf=new SimpleDateFormat("yyyy-MM-dd");
		//Date date=sdf.parse(dateOfBirth1);
		Date d=parse(dateOfBirth1);
		return d;
	}

	private static Date parse(String dateOfBirth1) {
		// TODO Auto-generated method stub
		return null;
	}
}
