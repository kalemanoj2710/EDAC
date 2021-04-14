package tester;

import java.util.Scanner;
import static utils.IOUtils.*;
import static utils.CollectionUtils.*;

public class SaveProductInfo {

	public static void main(String[] args) {
		// Store map of products in a binary file , using serialization
		try (Scanner sc = new Scanner(System.in)) {
			System.out.println("Enter file name to save product details");
			saveProducts(populateMap(populateData()),sc.next());
			System.out.println("saved product details....");

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
