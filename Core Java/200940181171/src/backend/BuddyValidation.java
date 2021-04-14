package backend;

import java.util.ArrayList;

public class BuddyValidation {
	public static final int EMAIL_MIN_LENGTH, EMAIL_MAX_LENGTH, MOBILE_LENGTH;
	public static final String SYMBOL_ONE, SYMBOL_TWO;
	public static String loginType;
	static {
		EMAIL_MIN_LENGTH = 9;
		EMAIL_MAX_LENGTH = 25;
		MOBILE_LENGTH = 10;
		SYMBOL_ONE = "@";
		SYMBOL_TWO = ".com";
	}

	public static boolean validateEmail(String email) throws BuddyCustomExcption {
		if (!(email.length() > EMAIL_MIN_LENGTH && email.length() < EMAIL_MAX_LENGTH && email.contains(SYMBOL_ONE)
				&& email.endsWith(SYMBOL_TWO))) {
			System.out.println("Email Is Invalid");
			return false;
		}
		return true;
	}
	

	public static boolean validateDublicateEmail(String email, ArrayList<Buddy> newBuddy)
			throws BuddyCustomExcption {
		for (Buddy c : newBuddy)
			if (c != null && email.equals(c.getEmail())) {
				System.out.println("Email Already REgistred Try Anotheer Email");
				return false;
			}
		return true;
	}
	
	public static boolean validateMobileNo(String mobile) {
		if (!(mobile.length() < MOBILE_LENGTH && mobile.length() > MOBILE_LENGTH)) {
			String regex = "(0/6/7/8/9)?[7-9][0-9]{9}";
			if (!mobile.matches(regex)) {
				System.out.println("Invalid Mobile No");
				return false;
			}
		}
		return true;
	}

	public static int fetchBuddy(String email,ArrayList<Buddy> buddyList){
		
		for(Buddy u:buddyList) {
			if(email.equals(u.getEmail()))	
			return buddyList.indexOf(u);
		}
		return -1;
	}
	
	
	
}
