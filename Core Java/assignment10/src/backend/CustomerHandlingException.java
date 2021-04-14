package backend;

@SuppressWarnings("serial")
public class CustomerHandlingException extends Exception{
public CustomerHandlingException(String errorMesg) {
	super(errorMesg);
}
}
