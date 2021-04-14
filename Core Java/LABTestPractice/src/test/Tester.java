package test;

import static collection.CollectionBuddy.populateData;
import static collection.CollectionBuddy.populateMapData;

import java.time.LocalDate;
import static java.time.LocalDate.*;
import java.util.HashMap;
import java.util.Scanner;
import static utils.UtilityMethods.*;
import com.app.core.Buddy;

public class Tester {

	public static void main(String[] args) {
		try(Scanner sc =new Scanner(System.in)){
		System.out.println("********Welcome to My Buddies*****");
		HashMap<String,Buddy> bmap=new HashMap<>();
		bmap=populateMapData(populateData());
		
		boolean exit=true;
		while(exit) {
			System.out.println("Enter :1 to add a Buddy "
					+ "Enter :2 to search Buddy By Email Id \n"
					+ "Enter :3 to Delete Buddy By Email Id "
					+ "Enter :4 to Display all Buddies \n"
					+ "Enter :5 to Display Buddies of Given DOB"
					+ "Enter :6 to Exit");
			try{
			switch (sc.nextInt()) {
			case 1:
				System.out.println("Enter Email Name PhoneNo  "
						+ "Date of Birth City");
                 String emailId=(sc.next());
                 checkDups(bmap,emailId);
                 String Name=sc.next();
                 int phone=sc.nextInt();
                 checkPhoneNo(bmap,phone);
                 LocalDate date=parse(sc.next());
                 checkDob(date);
                 String City=sc.next();
                 Buddy b5=new Buddy(emailId,Name,phone,date,City);
                 bmap.put(emailId, b5);
                 System.out.println("Buddy Added SuccesFully");
				break;
			case 2:
        System.out.println("Enter Email of Buddy to search");
        String email1=sc.next();
        System.out.println(bmap.get(email1));

				break;
			case 3:
				 System.out.println("Enter Email of Buddy to Delete");
			        String email2=sc.next();
			        bmap.remove(email2);
				break;
			case 4:
              System.out.println("Details of all buddies ");
              for(Buddy b : bmap.values())
            	  System.out.println(b);
				break;
			case 5:
				 System.out.println("Enter Date of Birth of Buddy to Display same");
			        LocalDate date1=parse(sc.next());
			        for(Buddy b :bmap.values())
			        {
			        	if((b.getDob()).compareTo(date1)==0)
			        		System.out.println(b);
			        		
			        }

				break;
			case 6:
               exit=false;
				break;

			}//switch
		}//try
	
		catch(Exception e) {
			e.printStackTrace();
		}
		sc.nextLine();
	}//while
		}
	}

}
