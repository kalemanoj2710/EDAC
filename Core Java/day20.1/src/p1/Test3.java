package p1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.function.Predicate;

public class Test3 {

	public static void main(String[] args) {
		// Objective : remove odd elements from AL of  ints
		ArrayList<Integer> ints =new ArrayList<>(Arrays.asList(10, 23, 1, 234, 56, 78,77,45,24));
		ints.add(99);
		System.out.println(ints);
		//Collection i/f method : public boolean removeIf(Predicate<? super T> filter)
		// Predicate : Func i/f
		//SAM : public boolean test(T t)
		//rets : true => elem removed o.w not
		
//		ints.removeIf(new Predicate<Integer>() {
//
//			@Override
//			public boolean test(Integer t) {
//				// TODO Auto-generated method stub
//				return t % 2 != 0;//odd : true =>elem will removed
//			}
//			
//		});
		ints.removeIf(i -> i % 2 != 0);
		
		System.out.println(ints);
	}

}
