package strms;

import java.util.Arrays;
import java.util.List;

public class TestMethodReference {

	public static void main(String[] args) {
		List<Integer> ints=Arrays.asList(12,34,56,1,2,50,-67);
		System.out.println("display via lambda expr : ");
		ints.stream().forEach(i->System.out.println(i));
		//Is there any way to add more conciseness to lambda expression ? YES : method reference
		//If lmabda expression is simply calling existing method in its body : then it can be replaced by a method ref.
		//syntax of meth ref : Invoker object :: existing method name
		System.out.println("display via method ref : ");
		ints.stream().forEach(System.out::println);
		//Can this be replaced by method ref ? NO
		ints.stream().forEach(i->System.out.print(i+" "));
		//Later : Sort the products as per manufacture date : again with method ref.
		//List<Product> --- Stream<Product> : sorted(Comparator)
	}

}
