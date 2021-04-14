package p1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.function.Predicate;

public class Test5 {

	public static void main(String[] args) {
		// Objective : remove odd elements from AL of  ints
		ArrayList<Integer> ints =new ArrayList<>(Arrays.asList(10, 23, 1, 234, 56, 78,77,45,24));
		ints.add(99);
		System.out.println(ints);
		//Objective : Display sorted ints in desc order
//		Collections.sort(ints,new Comparator<Integer>() {
//
//			@Override
//			public int compare(Integer o1, Integer o2) {
//				// TODO Auto-generated method stub
//				return o2.compareTo(o1);
//			}
//			
//		});
//		for(int i : ints)
//			System.out.println(i);
		Collections.sort(ints, (i1,i2)-> i2.compareTo(i1));
		//lambda expr to display elems in the list
		ints.forEach(i -> System.out.print(i+" "));
		
		
		
		
}

}
