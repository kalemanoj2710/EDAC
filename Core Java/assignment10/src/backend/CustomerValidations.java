package backend;

public class CustomerValidations {
public static final int EMAIL_MIN_LENGTH,EMAIL_MAX_LENGTH,PASSWORD_MIN_LENGTH,PASSWORD_MAX_LENGTH;
public static final String SYMBOL_ONE,SYMBOL_TWO;
static {
	EMAIL_MIN_LENGTH=9;
	EMAIL_MAX_LENGTH=15;
	PASSWORD_MIN_LENGTH=6;
	PASSWORD_MAX_LENGTH=20;
	SYMBOL_ONE="@";
	SYMBOL_TWO=".com";
}
public static void validateEmail(String email) throws CustomerHandlingException {
	if(!(email.length() > EMAIL_MIN_LENGTH && email.length() < EMAIL_MAX_LENGTH && email.contains(SYMBOL_ONE) && email.endsWith(SYMBOL_TWO))) {
		throw new CustomerHandlingException("Email Is Invalid");
	}
}
public static void validateDublicateEmail(String email,Customer[] cust) throws CustomerHandlingException {
	for (Customer c : cust) {
		if(c != null && email.equals(c.getEmail())) {
			throw new CustomerHandlingException("Email Already REgistred Try Anotheer Email");
		}
	}
}
	
public static void validateRegAmount(double amount) throws CustomerHandlingException {
	if(amount % 500 != 0) {
      throw new CustomerHandlingException("Please Check Registration Amount It Should Be in Multiple of 500");		
	}
}




}
