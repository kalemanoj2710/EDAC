package dependency;

public class SmSNotification implements CustomerNotificationService {
	
	public SmSNotification() {
		System.out.println("in ctor of "+getClass().getName());
	}

	@Override
	public void informCustomer(String notificationMesg) {
		System.out.println("notfying the customer with mesg : "+notificationMesg+" using "+getClass().getName());

	}

}
