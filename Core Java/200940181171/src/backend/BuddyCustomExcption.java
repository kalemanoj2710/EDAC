package backend;

@SuppressWarnings("serial")
public class BuddyCustomExcption extends Exception {
	public BuddyCustomExcption(String errorMesg) {
		super(errorMesg);
	}
}
