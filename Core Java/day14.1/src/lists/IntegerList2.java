package lists;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class IntegerList2 {

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
			//search elem in the list
			System.out.println("Enter the elem to search");
			System.out.println(list.contains(sc.nextInt())?"Present":"Absent");
			System.out.println("Enter the elem to display 1st n last occurrence of the elem");
			int elem=sc.nextInt();
			System.out.println("1st occur "+list.indexOf(elem)+" "+" last occur "+list.lastIndexOf(elem));
			System.out.println("enter the index to remove an elem");
			System.out.println(list.remove(sc.nextInt()));
			System.out.println("list "+list);
			//double values of elems > 30
			for(int i=0;i<list.size();i++)
				if(list.get(i) > 30)
					System.out.println("replaced "+list.set(i, list.get(i)*2));
			System.out.println("list after set"+list);
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
