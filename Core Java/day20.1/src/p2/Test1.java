package p2;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Test1 {

	public static void main(String[] args) {
	//different ways of attaching streams to data source
		int[] data= {12,34,1,67,89,44,567};
		//Objective : display ints  : FP
		//array -->seq stream ---> forEach
		System.out.println("Orig list");
		Arrays.stream(data).forEach(i -> System.out.print(i+" "));
		System.out.println("\n Sorted list");
	   //array -- seq stream -- sorted asc order ---display
		Arrays.stream(data).//IntStream : src
		sorted(). //intermediate op : rets IntStream : sorted ints
		forEach(i -> System.out.print(i+" "));//terminal op
		//Objective : Create int stream in the range of 1 ....100 , 
		//filter out odd elems , sort the data , print the same
		System.out.println("Chain of ops");
		IntStream.rangeClosed(1, 100)//IntStream : src : 1---100
		.filter(i -> i % 2 != 0) //IntStream : odd nos 1--100
		.sorted() //Intstream of odd nos 1-100 : asc
		.forEach(i -> System.out.print(i+" "));
		
		

	}

}
