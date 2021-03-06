package tester;

import java.util.Scanner;

import com.app.core.SListImplQ2;

public class Q3_SListTesterQ2 {

	public static void main(String[] args) {
		boolean exit = false;
		try(Scanner sc = new Scanner(System.in)){
			SListImplQ2 sl = new SListImplQ2();
			System.out.println("**** Welcome to Stack using Linked List ****");
			while(!exit) {
				System.out.print(" 1. Insert element in Stack"
						+ "\n 2. To get the element on top of Stack"
						+ "\n 3. To remove the element from top of Stack"
						+ "\n 4. To check if the Stack is EMPTY or NOT"
						+ "\n 5. To check if the Stack is FULL or NOT"
						+ "\n 6. Print the Stack"
						+ "\n 7. EXIT"
						+ "\n Enter your choice: ");
				switch (sc.nextInt()) {
				case 1:
					System.out.print("Enter the element to be added: ");
					sl.push(sc.nextInt());
					System.out.println("\n");
					break;
				case 2:
					if(sl.top() == 0) {
						System.out.println("Stack is empty!!");
						System.out.println("\n");
					}
					else {
						System.out.println("Element on top of Stack : " + sl.top());
						System.out.println("\n");	
					}
					
					break;
				case 3:
					int element = sl.pop();
					if (element != -1) {
						System.out.println("Element removed : " + element);
						System.out.println("\n");
					}
					else {
						System.out.println("Stack is EMPTY!!");
						System.out.println("\n");
					}
					break;
				case 4:
					if(sl.isEmpty())
						System.out.println(sl.isEmpty() + "  Stack is Empty!");
					else
						System.out.println(sl.isEmpty() + "  Stack is not Empty!");
					break;
				case 5:
					if(sl.isFull()) {
						System.out.println(sl.isEmpty() + "  Stack is Empty!");
					}
					else {
						System.out.println("Fun Fact: This Stack is Never Full");
					}
				case 6:
					sl.printStack();
					break;
				case 7:
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
