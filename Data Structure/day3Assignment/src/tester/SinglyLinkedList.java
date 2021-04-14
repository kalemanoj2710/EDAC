package tester;

import java.util.Scanner;

import singlylist.SinglyList;

public class SinglyLinkedList {

	public static void main(String[] args) {
		try (Scanner sc=new Scanner(System.in)){
			boolean flag=false;
			SinglyList slist=new SinglyList();
			while(!flag) {
			System.out.println("Choose Option From Below");
			System.out.println(" 1. Insert Element In List");
			System.out.println(" 2. Display All Element From The List");
			System.out.println(" 3. Count No Of Nodes In List");
			System.out.println(" 4. Count Frequency Of Element In List ");
			System.out.println(" 5. Find For List Element");
			System.out.println(" 6. Exit");
			System.out.print(" Enter Your Choice : ");
				switch(sc.nextInt()) {
				case 1:
					System.out.print("Enter A Element : ");
					slist.addAtFront(sc.nextInt());
					break;
				case 2:
					slist.printList();
					break;
				case 3:
					System.out.println("Total  "+slist.count()+"  Element/Nodes Available in List");
					break;
				case 4:
					System.out.print("Enter A Element : ");
					int no=sc.nextInt();
					System.out.println("Entered No "+no+" is "+slist.countFrequency(no)+" Times Available In List");
					break;
				case 5:
					System.out.print("Enter A Element : ");
					if(slist.find(sc.nextInt())) 
						System.out.println("Available");
					else
						System.out.println("Not Available");
					break;
				case 6:
					flag=true;
					System.exit(0);
					break;
				default :
					System.out.println("Invalid Option");
					break;
				}
			}
		}catch (Exception e) {
			e.printStackTrace();
		}

	}

}
