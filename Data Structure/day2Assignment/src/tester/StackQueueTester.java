package tester;

import java.util.Scanner;

import stackqueueclass.MyCircularQueue;
import stackqueueclass.MyQueue;
import stackqueueclass.MyStack;

public class StackQueueTester {

	public static void main(String[] args) {
		
		try(Scanner sc=new Scanner(System.in)){
			boolean flag=false;
			while(!flag) {
				System.out.println("Create Following Data Structure");
				System.out.println(" 1. Stack");
				System.out.println(" 2. Queue");
				System.out.println(" 3. Circular Queue");
				System.out.println(" 4. Exit");
				System.out.print("Enter Your Choice : ");
				switch(sc.nextInt()) {
				case 1:
					 System.out.print("Enter Size of The Stack : ");
					 int size=sc.nextInt();
					 MyStack stack=new MyStack(size);
					 boolean stackflag=false;
					 while(!stackflag) {
						 System.out.println("\nWelcome to Stack");
						 System.out.println(" 1. Add Element in Stack ");
						 System.out.println(" 2. Remove Element From Stack ");
						 System.out.println(" 3. Display The Stack Element");
						 System.out.println(" 4. Display The Stack In Reverse order");
						 System.out.println(" 5. Exit");
						 System.out.print("Enter Your Choice : ");
						 switch(sc.nextInt()) {
						 case 1:
							 System.out.print("Enter Element To Add in Stack : ");
							 stack.push(sc.nextInt());
							 break;
						 case 2:
							 stack.pop();
							 break;
						 case 3:
							 stack.display();
							 break;
						 case 4:
							 stack.displayInReverse();
							 break;
						 case 5:
							 stackflag=true;
							 break;
						default:
							System.out.println("invalid Option");
						 }
					 }
					break;
				case 2:
					 System.out.print("Enter Size of The Queue : ");
					 size=sc.nextInt();
					 MyQueue queue=new MyQueue(size);
					 boolean queueflag=false;
					 while(!queueflag) {
						 System.out.println("\nWelcome to Queue");
						 System.out.println(" 1. Add Element in Queue ");
						 System.out.println(" 2. Remove Element From Queue ");
						 System.out.println(" 3. Display The Queue Element");
						 System.out.println(" 4. Exit");
						 System.out.print("Enter Your Choice : ");
						 switch(sc.nextInt()) {
						 case 1:
							 System.out.print("Enter Element To Add in Queue : ");
							 queue.add(sc.nextInt());
							 break;
						 case 2:
							 queue.delete();
							 break;
						 case 3:
							 queue.display();
							 break;
						 case 4:
							 queueflag=true;
							 break;
						default:
							System.out.println("invalid Option");
						 }
					 }
					break;
				case 3:
					System.out.print("Enter Size of The Circular Queue : ");
					 size=sc.nextInt();
					 MyCircularQueue circularQueue=new MyCircularQueue(size);
					 boolean circularQueueflag=false;
					 while(!circularQueueflag) {
						 System.out.println("\nWelcome to Circular Queue");
						 System.out.println(" 1. Add Element in Circular Queue ");
						 System.out.println(" 2. Remove Element From Circular Queue ");
						 System.out.println(" 3. Display The Circular Queue Element");
						 System.out.println(" 4. Exit");
						 System.out.print("Enter Your Choice : ");
						 switch(sc.nextInt()) {
						 case 1:
							 System.out.print("Enter Element To Add in Circular Queue : ");
							 circularQueue.add(sc.nextInt());
							 break;
						 case 2:
							 circularQueue.delete();
							 break;
						 case 3:
							 circularQueue.display();
							 break;
						 case 4:
							 circularQueueflag=true;
							 break;
						default:
							System.out.println("invalid Option");
						 }
					 }
					
					break;
				case 4:
					flag=true;
					break;
				default:
					System.out.println("Invalid Option");
				}
			}	
		}
	}
}
