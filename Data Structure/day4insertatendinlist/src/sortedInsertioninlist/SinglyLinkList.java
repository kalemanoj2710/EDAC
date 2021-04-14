package sortedInsertioninlist;

import java.util.Scanner;

public class SinglyLinkList {
 public static void main(String[] args) {
	 
	 SinglyList list=new SinglyList();
	 try(Scanner sc=new Scanner(System.in)){
		 boolean exit=false;
		 while(!exit) {
			 try {
				 System.out.println("\nChoose Option ");
				 System.out.println(" 1. Insert Element");
				 System.out.println(" 2. Display Elements");
				 System.out.println(" 3. Exit");
				 System.out.print("Enter your Choice : ");
				 switch(sc.nextInt()) {
				 case 1:
					 System.out.print("Enter A Element : ");
					 list.insert(sc.nextInt());
					 break;
				 case 2:
					 list.display();
					 break;
				 case 3:
					 exit =true;
					 System.exit(0);
					 break;
				 }
				 
			 }catch (Exception e) {
				e.printStackTrace();
			}
		 }
	 }
 }
}
