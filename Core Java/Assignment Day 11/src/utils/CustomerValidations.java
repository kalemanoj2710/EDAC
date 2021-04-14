package utils;

import java.util.Date;

import CustomerStore.Customer;
import custom_exceptions.CustomerHandlingException;
import static Tester.CustomerRegistration.sdf;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class CustomerValidations {

	public static final int EMAIL_MIN_LENGTH, EMAIL_MAX_LENGTH;
	public static final int PASS_MIN_LENGTH, PASS_MAX_LENGTH;
	static {
		EMAIL_MIN_LENGTH = 8;
		EMAIL_MAX_LENGTH = 15;

		PASS_MIN_LENGTH = 6;
		PASS_MAX_LENGTH = 20;
	}

	public static void ValidateEmail(String mailid) throws CustomerHandlingException {
		if (mailid.length() < EMAIL_MIN_LENGTH || mailid.length() > EMAIL_MAX_LENGTH)
			throw new CustomerHandlingException("Invalid Email! (Length)");
		else if (!mailid.contains("@")) // String => contains();
			throw new CustomerHandlingException("Must be Contains ' @ '");
		else if (!mailid.endsWith(".com")) // String => endsWith();
			throw new CustomerHandlingException("Must be Ends with ' .com '");
	}

	public static void CheckForDups(Customer[] cst, String mailid, Date d) throws CustomerHandlingException {

		for (Customer cp : cst) {
			if (cp != null) {
				if (mailid.equals(cp.getEmail()) && d.equals(cp.getDate())) {
					throw new CustomerHandlingException("Duplicate Entry!");
				}
			}
		}

	}

	@SuppressWarnings("deprecation")
	public static void ValidateBirthday(Date bday) throws CustomerHandlingException {

		String sDate1 = "2000-01-01";

		Date checkDate = null;

		sdf.setLenient(false);

		try {

			checkDate = sdf.parse(sDate1); // String to Date Format

		} catch (ParseException e) {

			e.printStackTrace();
		}

		if (!bday.before(checkDate)) {
			throw new CustomerHandlingException("Date Must Be Before 1 Jan 2000..");
		}

	}

	public static void ValidatePassword(String password) throws CustomerHandlingException {
		if (password.length() < PASS_MIN_LENGTH || password.length() > PASS_MAX_LENGTH)
			throw new CustomerHandlingException("Invalid Password Length!");
		else if (!password.matches("((?=.*\\d)(?=.*[a-z])(?=.*[#@$*]).{6,20})"))
			throw new CustomerHandlingException("Invalid Password");
	}

	public static void ValidateAmount(double d) throws CustomerHandlingException {
		if (!(d % 500 == 0))
			throw new CustomerHandlingException("Amount Should Be Multiple Of 500!");
	}

	public static void ValidateCountry(String country) throws CustomerHandlingException {
		if (!country.equalsIgnoreCase("India")) {
			throw new CustomerHandlingException("Country Should Be India!");
		}
	}

	public static void CheckValidInfo(Customer[] cst, String mail, String pass, Date dob, String new_phone)
			throws CustomerHandlingException {
		for (Customer c1 : cst) {
			if (c1 != null)

				if (c1.getEmail().equals(mail) && c1.getPassword().equals(pass) && c1.getDate().equals(dob)) {
					c1.setPhone(new_phone);
					System.out.println("Successfully Change Phone Number!");
				} else {
					throw new CustomerHandlingException("Can't Change Phone Number, Invalid Info!");
				}
		}
	}

}
