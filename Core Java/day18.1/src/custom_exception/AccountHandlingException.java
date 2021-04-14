package custom_exception;

@SuppressWarnings("serial")
public class AccountHandlingException extends Exception {
	public AccountHandlingException(String mesg) {
		super(mesg);
	}

}
