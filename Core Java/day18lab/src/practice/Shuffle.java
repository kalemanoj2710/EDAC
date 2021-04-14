package practice;

import java.util.Collections;
import java.util.LinkedList;

public class Shuffle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedList<Integer> ints = new LinkedList<Integer>();
		for(int i = 0; i<100; i++) {
			ints.add(i);
		}
		System.out.println(ints);
		Collections.shuffle(ints);
		System.out.println(ints);

	}

}
