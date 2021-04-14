package tester;

import static utils.CollectionUtils.*;

import java.util.Collections;
import java.util.List;

import com.app.core.Product;

public class Test1 {

	public static void main(String[] args) {
		// get populated list of products.
		List<Product> list = populateData();
		// display the orig list :
		System.out.println("Original list ");
		list.forEach(p -> System.out.println(p));
		// remove all products , whose price < 400 n display list again
		list.removeIf(p -> p.getPrice() < 400);
		System.out.println("List after removal");
		list.forEach(p -> System.out.println(p));// removed product list

		// sort the products as per manufacture date n display the same.
		Collections.sort(list, (p1, p2) -> p1.getManufactureDate().compareTo(p2.getManufactureDate()));

		System.out.println("Sorted list");
		list.forEach(p -> System.out.println(p));// sorted product list
	}

}
