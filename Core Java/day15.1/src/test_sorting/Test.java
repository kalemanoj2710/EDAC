package test_sorting;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Test {

	public static void main(String[] args) {
		List<Integer> intList=Arrays.asList(10,1,23,45,101,-56,-123,34);
		System.out.println(intList);
		Collections.sort(intList);
		System.out.println(intList);

	}

}
