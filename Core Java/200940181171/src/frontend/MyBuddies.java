package frontend;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

import backend.Buddy;
import backend.BuddyValidation;

public class MyBuddies {
	public static LocalDate localddate;
	static {
		localddate = LocalDate.now();
	}

	public static void menu() {
		System.out.println("Enter Your Choice: ");
		System.out.println("1) Add New Buddy");
		System.out.println("2) Search Buddy By Email Id");
		System.out.println("3) Delete Buddy By Email Id");
		System.out.println("4) Display All My Buddies");
		System.out.println("5) Sort All buddies By Date of Birth");
		System.out.println("6) Exit");
	}

	public static void main(String[] args) throws ClassNotFoundException, IOException {

		ArrayList<Buddy> buddyList = new ArrayList<>();
		
		Buddy buddy;
		try (Scanner sc = new Scanner(System.in)) {
			boolean exit = false;
			String name, email, phoneNo, city;
			LocalDate dob;
			int index;
			while (!exit) {
				try {
					MyBuddies.menu();
					System.out.print("Enter your choice : ");
					switch (sc.nextInt()) {
					case 1:
						System.out.print("Enter Name : ");
						name = sc.next();
						System.out.print("Enter Email : ");
						email = sc.next();
						if (BuddyValidation.validateEmail(email)) {
							if (BuddyValidation.validateDublicateEmail(email, buddyList)) {
								System.out.print("Enter Mobile No : ");
								phoneNo = sc.next();
								if (BuddyValidation.validateMobileNo(phoneNo)) {
									System.out.print("Enter Date of Birth(yyyy-dd-mm)");
									dob = LocalDate.parse(sc.next());
									System.out.print("Enter City : ");
									city = sc.next();
									buddy = new Buddy(email, name, phoneNo, dob, city);
									buddyList.add(buddy);
									System.out.println("New Buddy Added Successfully");
									

								}
							}
						}

						break;
					case 2:
						System.out.print("Enter Email : ");
						email = sc.next();
						index = BuddyValidation.fetchBuddy(email, buddyList);
						System.out.println(buddyList.get(index));
						break;
					case 3:
						System.out.print("Enter Email : ");
						email = sc.next();
						index = BuddyValidation.fetchBuddy(email, buddyList);
						buddyList.remove(index);
						System.out.println("Successfully Deleted ");
						break;
					case 4:
					
						for (Buddy b : buddyList)
							System.out.println(b);
						break;
					case 5:
						Collections.sort(buddyList, new Comparator<Buddy>() {

							@Override
							public int compare(Buddy b1,Buddy b2) {
								int res = b2.getDob().compareTo(b1.getDob());
								return res;
							}
						});
						System.out.println("Sorted Buddies By Date of Birth ");
						for (Buddy b : buddyList)
							System.out.println(b);
						break;
					case 6:
						exit = true;
						System.exit(0);
						break;
					default:
						System.out.println("Invalid Choice !!");
						break;
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

		}
	}
}
