package tester;

import java.util.Map;
import java.util.Scanner;

import com.app.core.Product;

import static utils.IOUtils.restoreProduct;

public class RestorePrductDetails2 {

	public static void main(String[] args) {
		try(Scanner sc=new Scanner(System.in))
		{
			System.out.println("Enter file name , to restore product details");
		    //objective : display only name n price of all products : on separate lines.
			Map<Integer, Product> map = restoreProduct(sc.next());
			map.forEach((k,v) -> System.out.println(v));
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		

	}

}
