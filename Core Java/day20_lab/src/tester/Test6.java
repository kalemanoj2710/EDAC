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
public class Test6 {

	public static void main(String[] args) {
		try(Scanner sc=new Scanner(System.in))
		{
			//get populated list of products
			List<Product> list = populateData();
			System.out.println("Available products");
			list.forEach(p->System.out.println(p));
			System.out.println("Enter category n price");
			Category c=Category.valueOf(sc.next().toUpperCase());
			double price=sc.nextDouble();
			System.out.println("Product names of category "+c+" price > "+price);
			list.stream()//stream of all products
			.filter(p -> p.getProductCatgeory().equals(c)) //stream of products : by the category
			.filter(p->p.getPrice()> price)//stream of products : by the category > price
			.forEach(p->System.out.println(p.getName()));
			
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}

	}

}
