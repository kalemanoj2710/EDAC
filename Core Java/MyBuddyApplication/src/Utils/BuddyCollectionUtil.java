package Utils;

import static java.time.LocalDate.parse;

import java.util.ArrayList;
import java.util.HashMap;

import com.app.core.MyBuddy;

public class BuddyCollectionUtil {
	public static ArrayList<MyBuddy> populateData() {

		ArrayList<MyBuddy> arr = new ArrayList<MyBuddy>();

		MyBuddy b1 = new MyBuddy("manoj@gmail", "Manoj", 942037980, parse("1997-10-27"), "Pune");
		MyBuddy b2 = new MyBuddy("priti@gmail", "Priti", 800755555, parse("2000-01-01"), "Pune");
		MyBuddy b3 = new MyBuddy("anannya@gmail", "Anannya", 904993333, parse("2002-05-05"), "Pune");
		MyBuddy b4 = new MyBuddy("jayesh@gmail", "Jayesh", 696963339, parse("2005-11-15"), "Pune");
		arr.add(b1);
		arr.add(b2);
		arr.add(b3);
		arr.add(b4);
		return arr;
	}

	// Map Collection
	public static HashMap<String, MyBuddy> populateMapData(ArrayList<MyBuddy> arr) {
		HashMap<String, MyBuddy> map = new HashMap<>();
		for (MyBuddy b : arr)
			map.put(b.getEmail(), b);
		return map;

	}
}
