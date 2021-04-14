package practice;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Demo {
public static void main(String[] args) {
	try (Scanner sc = new Scanner(System.in)) {
		String input = null;
		ArrayList<LocalDate> dates = new ArrayList<>();
		while (true) {
			System.out.println("Enter date or type quit to exit");
			input=sc.next();
			if (input.equalsIgnoreCase("quit"))
				break;
			dates.add(LocalDate.parse(input));
		}
		System.out.println("Orig dates " + dates);
		// sorting : based upon Comparable
		Collections.sort(dates);
		for (LocalDate d : dates)
			System.out.println(d);
	} catch (Exception e) {
		e.printStackTrace();
	}

	
	
}
}
