package Utils;

import java.time.LocalDate;
import java.util.HashMap;

import com.app.core.MyBuddy;

import CustomException.ExceptionHandling;

public class BuddyValidations {
	public static void checkDups(HashMap<String, MyBuddy> data, String email) throws ExceptionHandling {
		if (data.containsKey(email))

			throw new ExceptionHandling("The same email already exists ");
		if (!(email.contains("@") && email.endsWith(".com")))
			throw new ExceptionHandling("Invalid email... should contain @ and end with .com");
	}

	public static void checkDob(LocalDate date) throws ExceptionHandling {

		if (date.isAfter(LocalDate.now()))
			throw new ExceptionHandling("Invalid Date of Birth");
	}

	public static void checkPhoneNo(HashMap<String, MyBuddy> data, long no) throws ExceptionHandling {
		for (MyBuddy b : data.values()) {
			if (b.getPhoneNumber() == no)
				throw new ExceptionHandling("Phone number already Exists");
		}
	}
}
