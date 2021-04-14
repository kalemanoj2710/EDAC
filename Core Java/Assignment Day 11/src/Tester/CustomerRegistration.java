package Tester;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import com.sun.xml.internal.ws.server.sei.ValueGetter;
import CustomerStore.Customer;
import CustomerStore.CustomerType;

import static utils.CustomerValidations.*;
import static CustomerStore.CustomerType.valueOf;

public class CustomerRegistration {

	private static final String String = null;
	public static SimpleDateFormat sdf;

	static {
		sdf = new SimpleDateFormat("yyyy-MM-dd");
		// Format
		// Parse
	}

	public static void main(String[] args) {

		System.out.println("Enter Number Of Customers : ");

		int counter = 0;
		boolean exit = false;
		try (Scanner sc = new Scanner(System.in)) {

			Customer[] c = new Customer[sc.nextInt()];

			while (!exit) {
				try {
					System.out.println("1. Register new customer\n" + "2. Display all customers , from a specified city"
							+ "\n3.Change Phone No.\n4.Display All Customer Details." + "\n5.Exit");

					switch (sc.nextInt()) {
					case 1:

						if (counter < c.length) {

							System.out.println(
									"Enter Email, Birthday (Year,Month,Day), Password, Name, Registration Amount, Customer Type :");

							// Emails
							String emails = sc.next();
							ValidateEmail(emails); // Method Call

							String birthday = sc.next();
							ValidateBirthday(sdf.parse(birthday)); // Date format //yyyy-MM-dd
							// Check For Email & Birthday Duplication
							CheckForDups(c, emails, sdf.parse(birthday)); // Method Call // Composite Key

							// Password
							String password = sc.next();
							ValidatePassword(password); // Method Call

							// Name
							String name = sc.next();

							// Registration Amount
							double reg_amt = sc.nextDouble();
							ValidateAmount(reg_amt); // Method Call

							// Customer Type
							String customer_type = sc.next();

							Customer cs = new Customer(emails, sdf.parse(birthday), password, name, reg_amt,
									valueOf(customer_type.toUpperCase()));

							System.out.println("Customer Save Successfully!");

							System.out.println("Enter Address Details City, State, Country, PhoneNo :");

							String City = sc.next();
							String State = sc.next();
							String Country = sc.next();
							ValidateCountry(Country);

							cs.Address(City, State, Country, sc.next());

							c[counter] = cs;
							counter++;

						}

						break;
					case 2:
						System.out.println("Enter City : ");
						String str = sc.next();
						for (Customer c1 : c) {
							if (c1 != null)
								if (c1.getCity().equals(str))
									System.out.println(c1);
						}

						break;
					case 3:
						System.out.println("Enter Email, Birthday, Password, New Phone No :");

						String e = sc.next();

						String birthday = sc.next();

						String pass = sc.next();

						Date dob = sdf.parse(birthday);

						String new_phone = sc.next();

						CheckValidInfo(c, e, pass, dob, new_phone);

						break;
					case 4:
						for (Customer c1 : c) {
							if (c1 != null)
								System.out.println(c1);
						}

						break;
					case 5:
						System.out.println("Exit Successfully!");
						exit = true;
						break;
					default:
						break;
					}
				} catch (ParseException e) {
					System.out.println("Invalid Date Format");
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
			} // End of While
		} // End of Try
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
