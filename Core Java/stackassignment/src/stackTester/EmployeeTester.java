package stackTester;
import java.util.Scanner;
import stack.*;
public class EmployeeTester {

	public static void main(String[] args) throws InterruptedException {
		Scanner sc=new Scanner(System.in);
		Stack ref=null;
		int ch;
		int id;
		String processBar[] = {"*","*","***","L","*","O","*","A","*","D","*","*","I","*","N","*","G","*","*","***"};

        for (int i = 0;i < processBar.length;i++) {           
            Thread.sleep(100);   
            System.out.print(processBar[i]); 
        }
        System.out.println("\nWelcome To Employee Stack Application");
        boolean flag=true;
        while(flag) {
        	System.out.println("\n*****   MENU   *****\n1. Fixed Stack \n2. Growable Stack \n3. Push into Stack \n4. Pop from Stack \n5. Display all employees \n6.. Exit \n\n Enter Your Choice");
        	ch=sc.nextInt();
        	switch(ch) {
        	case 1:{
        		if(ref == null) {
					ref = new FixedStack();
				}
				else {
					System.out.println("You are already using Growable Stack");
				}
        		break;
        	}
        	case 2:{
        		if(ref == null) {
					ref = new GrawableStack();
				}
				else {
					System.out.println("You are already using Fixed Stack");
				}
				
				break;
        	}
        	case 3:{
        		if(ref == null) {
				System.out.println("Please First Create the Any stack Before insert The data");
        		}
        		else {
        			System.out.println("Enter Employee details \nEnter ID :");
        			id = sc.nextInt();
        			System.out.println("Enter Name : ");
        			sc.nextLine();
        			String name = sc.nextLine();
        			
        			System.out.println("Enter Salary :");
        			double salary = sc.nextDouble();
        			ref.push(new Employee(id, name, salary));
			}
				break;
			}
        	case 4:{
				try{if(ref == null) {
					System.out.println("Please First Create the Any stack Before insert The data");
				}
				else {
					
					System.out.println("Enter Employee ID to pop :");
					id = sc.nextInt();
					
					Employee emp = ref.pop();
					if(emp != null) {
						System.out.println("Deleted employee is : " + emp.toString());
					}
					else {
						System.out.println("nothing exist for delete!!");
					}
					
				}}
				catch(NullPointerException e) {
					//System.out.println(e.getStackTrace());
					e.printStackTrace();
				}
				
				break;
        	}
        	case 5:{
        		if(ref == null) {
					System.out.println("Please First Create the Any stack Before insert The data");
				}
				else {
					ref.display();
					ref.toString();
				}

				break;
        	}
        	case 6:{
        		System.out.println("Sucessfully Exit !!");
        		System.exit(0);
				break;
        	}
        	default :{
        		System.out.println("Invalid Option Entered");
        	}
        	}
        }
        sc.close();
	}
}
