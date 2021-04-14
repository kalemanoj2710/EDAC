package tester;

import java.util.ArrayList;
import java.util.Arrays;

/*
 * 2. Create AL<Integer> , populate it.
Convert it to seq stream & display elems
Convert it to parallel stream & display elems
 */
public class Test4 {

	public static void main(String[] args) {
		// Create AL<Integer> , populate it.
		ArrayList<Integer> list=new ArrayList<>(Arrays.asList(12,34,123,10,45,67,77,88,91,28,100));
		//how to convert collection ---> seq stream : Collection i/f : stream() : Stream<T>
		System.out.println("Seq stream");
		list.stream() //rets Stream<Integer> : for seq processing
		.forEach(i -> System.out.print(i+" "));
		System.out.println("parallel stream");
		//how to convert collection --->  stream  to be processed in parallel manner: Collection i/f : parallelstream() : Stream<T>
		list.parallelStream() //rets Stream<Integer> : parallel processing
		.forEach(i -> System.out.print(i+" "));
	}

}
