package test;
import java.util.Scanner;

import queue.*;
public class Tester {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		QueueSinglyImpl n1=new QueueSinglyImpl();
		System.out.println("Enter Size of Queue");
		//System.out.println(n1.isFull());
		n1.setSize(sc.nextInt());
		System.out.println(" Size of Queue :"+n1.getSize());
		boolean flag=true;
		while(flag) {
			System.out.println("\n Enter 1 to Add Element"
					+ "\n Enter 2 to delete Element"
					+ "\n Enter 3 to peek Front Element of queue"
					+ "\n Enter 4 to peek Last Element of queue"
					+ "\n Enter 5 to Exit");
			
			switch (sc.nextInt()) {
			case 1:
				System.out.println("Enter a String Input ");
				n1.addElement(sc.next());
				break;
            case 2:
            	System.out.println("You can use your own Inputs \nsuggetions :");
				n1.printQueue();
				System.out.println("Enter a String input");
				n1.deleteElement(sc.next());
				
				break;
            case 3:
            	System.out.println("FirstElement -> "+n1.firstElement());
            	break;
            case 4:
            	System.out.println("LastElement -> "+n1.lastElement());
            	break;
            case 5:
            	flag=false;
            	break;

			default:
				break;
			}
		}
		//for lazy guys uncomment this and comment above
//		n1.addElement("Human");
//		n1.addElement("are");
//		n1.addElement("Bad");
//		n1.addElement("Species");
//		n1.addElement("We");
//		n1.addElement("WillEaradicateHumans");
//		n1.printQueue();
//        System.out.println("FirstElement-> "+n1.firstElement());
//		System.out.println("LastElement-> "+n1.lastElement());
//		n1.deleteElement("Species");
//		n1.deleteElement("We");
//		n1.deleteElement("WillEaradicateHumans");
//		n1.deleteElement("Human");
//		n1.deleteElement("are");
//		n1.deleteElement("Bad");
//		//n1.deleteElement("Bad");
//		n1.printQueue();
//		System.out.println("FirstElement-> "+n1.firstElement());
//		System.out.println("Rear"+n1.isEmpty());
//		System.out.println("LastElement-> "+n1.lastElement());
//		//sc.nextLine();
//		System.out.println(n1.isFull());
        
	}

}
