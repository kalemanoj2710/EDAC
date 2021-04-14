package tester;

import java.util.Scanner;

public class TestTryWithResources {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			System.out.println("Enter a number");
			System.out.println("Number " + sc.nextInt());
			System.out.println("end of try");
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("main over...");

	}

}
