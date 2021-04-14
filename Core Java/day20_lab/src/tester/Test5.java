package tester;

import java.util.stream.IntStream;

public class Test5 {

	public static void main(String[] args) {
		// 3. Create stream of ints between 1-100 & display all even elements.
		IntStream.range(1, 101) //stream of ints 1-100
		.filter(i -> i % 2 ==0) // stream of even ints within 1-100
		.forEach(i->System.out.print(i+" "));
		
	}

}
