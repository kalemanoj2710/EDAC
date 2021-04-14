package dependency;

public class EmailNotification implements CustomerNotificationService {
	public EmailNotification() {
		System.out.println("in ctor of "+getClass().getName());
	}

	@Override
	public void informCustomer(String notificationMesg) {
		System.out.println("notfying the customer with mesg : "+notificationMesg+" using "+getClass().getName());

	}

}
