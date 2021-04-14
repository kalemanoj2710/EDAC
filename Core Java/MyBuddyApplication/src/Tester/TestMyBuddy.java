package Tester;

import static Utils.BuddyCollectionUtil.populateData;
import static Utils.BuddyCollectionUtil.populateMapData;
import static Utils.BuddyValidations.checkDob;
import static Utils.BuddyValidations.checkDups;
import static Utils.BuddyValidations.checkPhoneNo;
import static java.time.LocalDate.parse;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Scanner;

import com.app.core.MyBuddy;

public class TestMyBuddy {
	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			System.out.println("********Welcome to My Buddies*****");
			HashMap<String, MyBuddy> data = new HashMap<>();
			data = populateMapData(populateData());

			boolean exit = true;
			while (exit) {
				System.out.println("Enter Your Choice: ");
				System.out.println("1) Add New Buddy");
				System.out.println("2) Search Buddy By Email Id");
				System.out.println("3) Delete Buddy By Email Id");
				System.out.println("4) Display All My Buddies");
				System.out.println("5) Sort All buddies By Date of Birth");
				System.out.println("6) Exit");
				try {
					switch (sc.nextInt()) {
					case 1:
						System.out.println("Enter Email, Name, PhoneNumber  " + "Date of Birth City");
						String emailId = (sc.next());
						checkDups(data, emailId);
						String Name = sc.next();
						long phone = sc.nextLong();
						checkPhoneNo(data, phone);
						LocalDate date = parse(sc.next());
						checkDob(date);
						String City = sc.next();
						MyBuddy b5 = new MyBuddy(emailId, Name, phone, date, City);
						data.put(emailId, b5);
						System.out.println("Buddy Added SuccesFully");
						break;
					case 2:
						System.out.println("Enter Email of Buddy to search");
						String email1 = sc.next();
						System.out.println(data.get(email1));

						break;
					case 3:
						System.out.println("Enter Email of Buddy to Delete");
						String email2 = sc.next();
						data.remove(email2);
						break;
					case 4:
						System.out.println("Details of all buddies ");
						for (MyBuddy b : data.values())
							System.out.println(b);
						break;
					case 5:
						System.out.println("Sort All buddies By Date of Birth");
						
						for (MyBuddy b : data.values()) {
							
								System.out.println(b);

						}

						break;
					case 6:
						exit = false;
						break;
					default:
						System.out.println("please enter valid choice.");

					}
				}

				catch (Exception e) {
					e.printStackTrace();
				}
				sc.nextLine();
			}
		}
	}
}
