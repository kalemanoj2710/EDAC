package test_generics;

import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;

public class TestGenericMethod {

	public static void main(String[] args) {
		List<Object> list1 = Arrays.asList();
		System.out.println(list1.getClass().getName());
	//	list1.add("dsfads");
		System.out.println(list1);
		//fixed size list of strings
		List<String> strings=Arrays.asList(new String[] {"one","two","three"});
		System.out.println(strings);
		strings.set(0, strings.get(0).toUpperCase());
		System.out.println(strings);
		strings=Arrays.asList("1","3","6","7");
		System.out.println(strings);
		//print the contents of this list in reverse order : can we attach ListIterator : YES
		System.out.println("Printing elems in rev order");
		ListIterator<String> listItr=strings.listIterator(strings.size());
		System.out.println(listItr.getClass().getName());
		while(listItr.hasPrevious())
			System.out.println(listItr.previous());
		
		
		

	}

}
