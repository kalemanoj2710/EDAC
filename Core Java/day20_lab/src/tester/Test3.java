package tester;

import java.util.Arrays;

public class Test3 {

	public static void main(String[] args) {
		//Create int[] ---> IntStream & display its contents.
		int[] data= {12,34,123,10,45,67,77,88,91,28,100};
		//Arrays.stream(int[] array) : java.util.stream.IntStream : i/f
		Arrays.stream(data) //stream of ints : IntStream
		.forEach(i -> System.out.print(i+" "));//terminal op

	}

}
