package tester;

import java.util.Scanner;

import com.app.core.SListImplQ1;

public class Q1_SListTester {

	public static void main(String[] args) {
		boolean exit = false;
		try(Scanner sc = new Scanner(System.in)){
			SListImplQ1 sl = new SListImplQ1();
			System.out.println("**** Welcome to Linked List ****");
			while(!exit) {
				System.out.print(" 1. Insert element at the end of the Linked List"
						+ "\n 2. To get the element in front of the list"
						+ "\n 3. To remove the element from the front of the list"
						+ "\n 4. To check if the list is EMPTY or NOT"
						+ "\n 5. Print the list"
						+ "\n 6. EXIT"
						+ "\n Enter your choice: ");
				switch (sc.nextInt()) {
				case 1:
					System.out.print("Enter the element to be added: ");
					sl.addAtEnd(sc.nextInt());
					System.out.println("\n");
					break;
				case 2:
					if(sl.getFront() == 0) {
						System.out.println("List is empty!!");
						System.out.println("\n");
					}
					else {
						System.out.println("First Element in the list : " + sl.getFront());
						System.out.println("\n");	
					}
					
					break;
				case 3:
					sl.removeFront();
					System.out.println("\n");
					break;
				case 4:
					if(sl.isEmpty())
						System.out.println(sl.isEmpty() + "  List is Empty!");
					else
						System.out.println(sl.isEmpty() + "  List is not Empty!");
					break;
				case 5:
					sl.printList();
					break;
				case 6:
					exit = true;
					break;
				default:
					System.out.println("Please Enter correct choice!!!!");
					break;
				}
			}
		}
	}

}
