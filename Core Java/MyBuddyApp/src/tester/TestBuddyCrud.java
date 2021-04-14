package tester;

import static app.utils.BuddyValidationUtils.checkDateOfBirth;
import static app.utils.BuddyValidationUtils.checkEmail;

import java.util.ArrayList;
import java.sql.Date;
import java.util.List;
import java.util.Scanner;

import app.dao.BuddyDaoImpl;
import app.pojos.Buddy;


public class TestBuddyCrud {

	public static void main(String[] args) {
		try(Scanner sc = new Scanner(System.in)){
		
			boolean exit=false;
			String email;
			Buddy b=new Buddy();
			BuddyDaoImpl buddyDao = new BuddyDaoImpl();
			List<Buddy> buddyList=new ArrayList<>();
			while(!exit) {
				System.out.println("Enter Your Choice: ");
				System.out.println("1) Add New Buddy");
				System.out.println("2) Search Buddy By Email Id");
				System.out.println("3) Delete Buddy By Email Id");
				System.out.println("4) Display All Buddies");
				System.out.println("5) Display All buddies By Date of Birth");
				System.out.println("6) Exit");
			
				try {
					switch(sc.nextInt()) {
					case 1:
						System.out.println("Enter Emailid,Name,PhoneNumber,date of birth(yyyy-mm-dd) & city of buddy respectively: ");
						b= new Buddy(checkEmail(sc.next()),sc.next(),sc.nextLong(),checkDateOfBirth(sc.next()),sc.next());
						String msg=buddyDao.addNewBuddy(b);
						System.out.println(msg);
						break;
					case 2:
						System.out.println("Enter Email id:");
						email=checkEmail(sc.next());
						b=buddyDao.searchBuddyByEmailId(email);
						System.out.println(b);
						break;
					case 3:
						System.out.println("Enter Email id:");
						email=checkEmail(sc.next());
						msg=buddyDao.deleteBuddyByEmailId(email);
						System.out.println(msg);
						break;
					case 4:
						buddyList=buddyDao.displayAllBuddies();
						if (buddyList.isEmpty())
							System.out.println("NO buddy found.....");
						else
							buddyList.forEach(e -> System.out.println(e));
						break;
					case 5:
						System.out.println("Enter Dob(yyyy-mm-dd) : ");
						Date d=checkDateOfBirth(sc.next());
						buddyList=buddyDao.displayBuddiesByDob(d);
						if (buddyList.isEmpty())
							System.out.println("NO buddy found.....");
						else
							buddyList.forEach(e -> System.out.println(e));
						break;
					case 6:
						exit=true;
					default:
						System.out.println("please enter valid choice.");
					}
				}catch (Exception e) {
					e.printStackTrace();
					System.out.println("Pls retry....");
				}
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}
