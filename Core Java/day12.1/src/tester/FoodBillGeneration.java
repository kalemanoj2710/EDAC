package tester;

import java.util.Scanner;

import com.app.foods.Menu;

import static com.app.foods.Menu.*;

public class FoodBillGeneration {

	public static void main(String[] args) {
		double totalBill = 0;
		try (Scanner sc = new Scanner(System.in)) {

			while (true) {
				// display food menu
				System.out.println("Menu : ");
				for (Menu m : values())
					System.out.print(m + " ");
				System.out.println("\n Enter food item n quantity");
				System.out.println("Enter  exit to quit");
				Menu item = valueOf(sc.next().toUpperCase());
				totalBill += sc.nextInt() * item.getPrice();

			}
		} catch (Exception e) {
			System.out.println(e);// IllegalArgumentExc
			System.out.println("Order complete ");
			System.out.println("Total Bill " + totalBill);
		}

	}

}
