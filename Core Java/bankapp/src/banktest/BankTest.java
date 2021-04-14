package banktest;

import java.util.Scanner;

import clientsinfo.BankAccounts;
import clientsinfo.CurrentAccount;
import clientsinfo.LoanAccount;
import clientsinfo.SavingAccount;

public class BankTest {
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		System.out.println("How many Custoomers you want to create");
		BankAccounts[] bankAcccounts=new BankAccounts[sc.nextInt()];
		
		boolean flag= true;
		int ch;
		String name;
		double balance;
		String Type;
		double principle;
		double intrest;
		int numberOfInstallment;
		double emiAmount;
		int time;
		int accNo;
		int counter=0;
		double amount;
		
		while(flag) {
			System.out.println(" *********  MENU  *********\n 1. Open Saving A/C \n 2. Open Current A/C \n 3. Open Loan A/C \n 4. Withdraw Money \n 5. Deposit Money \n 6. Get A/C Details \n 7. exit \n Enter your Choice");
			ch=sc.nextInt();
			switch(ch) {
			case 1:{
				System.out.println("Saving Account Opening Portal Please ans the following Questions");
				System.out.println("Enter The Account Holder Name");
				sc.nextLine();
				name=sc.nextLine();
				System.out.println("Enter The Initial Balance");
				balance=sc.nextDouble();
				System.out.println("Enter The principle amount");
				principle=sc.nextDouble();
				System.out.println("Enter The intrst ");
				intrest=sc.nextDouble();
				System.out.println("Enter The time to calculate simple intrest up to");
				time=sc.nextInt();
				bankAcccounts[counter] =new SavingAccount(name, balance, principle, intrest, time);
				System.out.println("Saving Account Opened Succefully \n"+bankAcccounts[counter].toString());
				counter++;
				break;
				
			}
			case 2:{
				System.out.println("Current Account Opening Portal Please ans the following Questions");
				System.out.println("Enter The Account Holder Name");
				sc.nextLine();
				name=sc.nextLine();
				System.out.println("Enter The Initial Balance");
				balance=sc.nextDouble();
				bankAcccounts[counter] =new CurrentAccount(name, balance);
				System.out.println("Current Account Opened Succefully");
				counter++;
				break;
				
			}
			case 3:{
				System.out.println("Current Account Opening Portal Please ans the following Questions");
				System.out.println("Enter The Account Holder Name");
				sc.nextLine();
				name=sc.nextLine();
				System.out.println("Enter The Initial Balance");
				balance=sc.nextDouble();
				System.out.println("Enter How many installment going to pay loan");
				numberOfInstallment=sc.nextInt();
				System.out.println("Enter Emi Going to pay");
				emiAmount =sc.nextDouble();
				bankAcccounts[counter] =new LoanAccount(name, balance,numberOfInstallment,emiAmount);
				System.out.println("Loan Account Opened Succefully");
				counter++;
				break;
			}
			case 4:{
				System.out.println("Enter The Account Number");
				accNo=sc.nextInt();
				for(int i=0;i<bankAcccounts.length;i++) {
					try {
						if(null!=bankAcccounts[i] && bankAcccounts[i].acctNo==accNo) {
						System.out.println("Enter A amount");
						amount=sc.nextDouble();
						
							bankAcccounts[i].withdraw(amount);
							System.out.println("Thanks for Transaction your available balancce is :"+bankAcccounts[i].balance);
						
						
						break;
					}
						
				}
					 catch(NullPointerException e) 
                    { 
                        System.out.print("NullPointerException Caught"); 
                    } 	
					
			} 
				 break;
				}
			case 5:{	
				System.out.println("Enter The Account Number");
				accNo=sc.nextInt();
				for(int i=0;i<bankAcccounts.length;i++) {
					try {
						if(null!=bankAcccounts[i] && bankAcccounts[i].acctNo==accNo) {
					
						System.out.println("Enter A amount");
						amount=sc.nextDouble();
						
							bankAcccounts[i].deposit(amount);
							System.out.println("Thanks for Transaction your available balancce is :"+bankAcccounts[i].balance);
							break;
						
					}
						}
				    catch(NullPointerException e) 
                      { 
				    		System.out.print("NullPointerException Caught"); 
                      } 
				}
			//send to bank account and take balance 
				 break;	
				}
			case 6:{
				System.out.println("Enter the Aaccount No:");
                accNo=sc.nextInt();
                for(int i=0;i<bankAcccounts.length;i++) {
                	try{
                	
                		if(null != bankAcccounts[i] && bankAcccounts[i].acctNo==accNo) {
                		 System.out.println(bankAcccounts[i].toString());
	                	}

                	}
                	 catch(NullPointerException e) 
                    { 
                        System.out.print("NullPointerException Caught"); 
                    } 
                }
                break;
				
			}
			case 7:{ System.out.println("Logout !!");
						flag=false;
						System.exit(0);
					}
			
			}
		}
	}

}
