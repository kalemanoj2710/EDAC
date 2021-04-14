package tester;

import java.util.Scanner;
import static utils.IOUtils.restoreProduct;

public class RestorePrductDetails {

	public static void main(String[] args) {
		try(Scanner sc=new Scanner(System.in))
		{
			System.out.println("Enter file name , to restore product details");
			System.out.println(restoreProduct(sc.next()));
			System.out.println("restored data....");
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		

	}

}
