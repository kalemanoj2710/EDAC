package tester;

import java.util.List;
import java.util.Scanner;

import com.app.core.Category;
import com.app.core.Product;

import static utils.CollectionUtils.populateData;

/*
 * 4. Display all product names of a particular category , exceeding specific price.
I/P category name & price.
(stream,filter,forEach)
eg : productList : List<Product>
 */
public class Test7 {

	public static void main(String[] args) {
		try(Scanner sc=new Scanner(System.in))
		{
			//get populated list of products
			List<Product> list = populateData();
			System.out.println("Available products");
			list.forEach(p->System.out.println(p));
			System.out.println("Enter category");
			Category c=Category.valueOf(sc.next().toUpperCase());
			double sumPrice=list.stream()//strm of all products
			.filter(p -> p.getProductCatgeory().equals(c)) //filtered by catgeory
			.mapToDouble(p->p.getPrice())//stream of double (product price) : DoubleStream
			.sum();
			
			System.out.println("Sum of products of category "+c+" = "+sumPrice);
			
		}catch (Exception e) {
			e.printStackTrace();
		}

	}

}
