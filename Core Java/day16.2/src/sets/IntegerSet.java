package sets;

import java.util.Arrays;
import java.util.HashSet;
import java.util.TreeSet;

public class IntegerSet {
	public static void main(String[] args) {
		int[] data = { 12, 34, 1, 45, 12, -90, 48, 111, 12, 34 };
		// create an empty HashSet to store Integer type of refs
		HashSet<Integer> intSet = new HashSet<>();
		for (int i : data)
			System.out.println("Added " + intSet.add(i));
		System.out.println("HS : " + intSet);
		System.out.println("Size " + intSet.size());
		System.out.println("HS contains 45" + intSet.contains(45));
		System.out.println("HS remove 45 " + intSet.remove(45));
		System.out.println("HS contains 45" + intSet.contains(45));
		System.out.println("HS " + intSet);
	}
}
