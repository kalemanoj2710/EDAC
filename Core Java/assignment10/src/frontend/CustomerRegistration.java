package frontend;

import java.util.Scanner;
import backend.Customer;
import backend.CustomerValidations;

public class CustomerRegistration {

	static void menu() {
		System.out.print(
				"\n\n*******   MENU   ******* \n 1: Register New Customer \n 2: Display Customer Details\n 3: Exit\n Enter Your Choice");
	}

	public static void main(String[] args) {

		final int STACK_LIMIT = 10;
		Customer[] cust = new Customer[STACK_LIMIT];
		boolean flag = true;
		int ch;
		String email;
		String password;
		String name;
		double registrationAmount;
		String city;
		int counter = 0;
		
		try (Scanner sc = new Scanner(System.in)) {
			
			while (flag) {
				CustomerRegistration.menu();
				ch = sc.nextInt();
				switch (ch) {
				case 1: {
					System.out.println("Enter Customer Details");
					System.out.print("\nName : ");
					name = sc.next();
					System.out.print("\nEmail : ");
					email = sc.next();
					System.out.print("\nRegistration Amount : ");
					registrationAmount = sc.nextDouble();
					System.out.print("\nCity : ");
					city = sc.next();
					System.out.print("\nPassword : ");
					password = sc.next();
					
					
					CustomerValidations.validateEmail(email);
					CustomerValidations.validateRegAmount(registrationAmount);
					CustomerValidations.validateDublicateEmail(email, cust);
						cust[counter] = new Customer(email, password, name, registrationAmount, city);
						counter++;
					break;
				}
				case 2:{
					System.out.println("Enter the City");
					String cityFind = sc.next();

					for (Customer i : cust) {
						if (i != null) {
							if (i.getCity().equals(cityFind))
								System.out.println(i);
						}
					}					
					break;
					}
				case 3: {
					flag = false;
					System.exit(0);

				}
				default: {
					System.out.println("Invalid Option Entered");
					break;
				}
				}

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
