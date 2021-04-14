package tester;

import java.util.List;
import java.util.Scanner;

import com.app.core.Category;
import com.app.core.Product;

import static utils.CollectionUtils.populateData;

//display avg price of products from a chosen category
public class Test8 {

	public static void main(String[] args) {
		try(Scanner sc=new Scanner(System.in))
		{
			//get populated list of products
			List<Product> list = populateData();
			System.out.println("Available products");
			list.forEach(p->System.out.println(p));
			System.out.println("Enter category");
			Category c=Category.valueOf(sc.next().toUpperCase());
			double avg=list.stream()//strm of all products
			.filter(p -> p.getProductCatgeory().equals(c)) //filtered by catgeory
			.mapToDouble(p->p.getPrice())//stream of double (product price) : DoubleStream
			.average().orElse(-99999);
			
			System.out.println("avg of products of category "+c+" = "+avg);
			
		}catch (Exception e) {
			e.printStackTrace();
		}

	}

}
