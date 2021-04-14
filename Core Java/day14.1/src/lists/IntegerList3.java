package lists;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Scanner;

public class IntegerList3 {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			// create empty array list with def init capa
			ArrayList<Integer> list = new ArrayList<>();
			// size =0 , capa =10
			int[] data = { 10, 12, 21, -45, 10, 23, 56, 77, 89, 12 };
			// populate AL with this data
			for (int i : data)
				list.add(i);// int --->Integer : auto boxing list.add(Integer.valueOf(i))
			// display elems in AL
			System.out.println("AL contents via toString " + list);
			list.add(0, 999);//insert
			System.out.println("list after add "+list);
			//create another list : list2  having same elems ,in the same order.
			ArrayList<Integer> list2=new ArrayList<>(list);
			System.out.println("List 2 contents "+list2);
			System.out.println("Growable Collection-----> Fixed size Array");
			Integer[] refs=new Integer[list.size()];
			System.out.println("Before "+Arrays.toString(refs));
			list.toArray(refs);
			System.out.println("After "+Arrays.toString(refs));
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
