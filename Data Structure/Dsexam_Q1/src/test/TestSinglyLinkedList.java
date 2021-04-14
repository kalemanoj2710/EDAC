package test;

import java.util.Scanner;

import singlyLinkedList.SList;

public class TestSinglyLinkedList {

	public static void main(String[] args) {
		boolean exit = false;
		try (Scanner sc = new Scanner(System.in)) {
			SList sl = new SList();
			System.out.println("**** Welcome to Linked List ****");
			while (!exit) {
				System.out.print(" 1. Insert Element At The  End of Linked List"
						+ "\n 2. To Get The Element In Front of The List"
						+ "\n 3. To Remove The Element From The Front of The List"
						+ "\n 4. To check If the List is EMPTY or NOT"
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
					if (sl.getFront() == 0) {
						System.out.println("List is empty!!");
						System.out.println("\n");
					} else {
						System.out.println("First Element in the list : " + sl.getFront());
						System.out.println("\n");
					}

					break;
				case 3:
					sl.removeFront();
					System.out.println("Element removed");
					System.out.println("\n");
					break;
				case 4:
					if (sl.isEmpty())
						System.out.println("List is Empty!");
					else
						System.out.println("List is not Empty!");
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
