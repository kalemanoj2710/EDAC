package frontend;

import java.util.Scanner;
import backend.Customer;

public class CustomerRegistration {
	static void loder() throws InterruptedException {
		String processBar[] = { "*", "*", "***", "L", "*", "O", "*", "A", "*", "D", "*", "I", "*", "N", "*", "G", "*",
				"*", "***" };

		for (int i = 0; i < processBar.length; i++) {
			Thread.sleep(100);
			System.out.print(processBar[i]);
		}
	}

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
			CustomerRegistration.loder();
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
					boolean status = false;
					for (Customer i : cust) {
						if (null != i && i.email.equals(email)) {
							System.out.println(i.email + " this mail Id Already Used");
							break;
						} else {
							status = true;
						}
					}
					if (status) {

						cust[counter] = new Customer(email, password, name, registrationAmount, city);
						counter++;
						
					}
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
			e.fillInStackTrace();
		}

	}

}
