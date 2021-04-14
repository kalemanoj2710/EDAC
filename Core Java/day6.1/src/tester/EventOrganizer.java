package tester;

import java.util.Scanner;

import inh.Faculty;
import inh.Person;
import inh.Student;

public class EventOrganizer {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter max no of paticipants");
		Person[] participants = new Person[sc.nextInt()];// array obj created to hold person type of refenrence
		boolean exit = false;
		int counter = 0;
		while (!exit) {
			System.out.println("Menu : 1. Register Student 2. Register Faculty 3. Display 10.Exit");
			System.out.println("Choose Option");
			switch (sc.nextInt()) {
			case 1: // Register Student
				if (counter < participants.length) {
					System.out.println("Enter Student Details : fn,  ln, gradYear,  courseName,  fees, marks");
					participants[counter++] = new Student(sc.next(), sc.next(), sc.nextInt(), sc.next(),
							sc.nextDouble(), sc.nextInt());// student ---> person upcasting
				} else
					System.out.println("Event Full!!!!");

				break;
			case 2: // Register Faculty
				if (counter < participants.length) {
					System.out.println("Enter Faculty Details : fn,  ln, exp yrs sme");
					participants[counter++] = new Faculty(sc.next(), sc.next(), sc.nextInt(), sc.next());// faculty--->perso
				} else
					System.out.println("Event Full!!!!");

				break;
			case 3:
				System.out.println("Participant Details");
				for (Person p : participants)
					if (p != null)
						System.out.println(p);// JVM : chks which instance's toString : type of the instance : run time
												// poly.

				break;
			case 10:
				exit = true;
				break;

			}
		}

		sc.close();

	}

}
