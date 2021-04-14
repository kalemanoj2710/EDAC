package test;

import java.util.Scanner;

import implementation.MyQueue;

public class Tester {
public static void main(String[] args) {
	
	boolean exit = false;
	int deQueuedElement = 0;
	int topElement = 0;
	Scanner sc=new Scanner(System.in);
	System.out.println("Enter the size of Queue...");
	int size = sc.nextInt();
	MyQueue q=new MyQueue(size);
	
	while (!exit) {
		System.out.println("Choose the option to perform the opertaion:--");
		System.out.println("1.EnQueue Operation     2.DeQueue Operation     3.Get Top Element    4.Display Queue       5.EXIT");
		switch (sc.nextInt()) {
		case 1:
			System.out.println("Enter the Element On Which You Want To Perform EnQueue Operation:- ");
			q.push(sc.nextInt());
			break;
		case 2:
			if(q.pop() == -1)
				System.out.println("Stack is Empty..!!");
			else
				System.out.println("Popped Element is:-- "+ q.pop());
			break;
		case 3:
			topElement = q.top();
			System.out.println("Element which is on TOP is :-- " + topElement);
			break;
		case 4:
			q.displayQueue();
			break;
		case 5:
			exit = true;
			break;
		}// end of switch cases
	} // end of while
}
}

