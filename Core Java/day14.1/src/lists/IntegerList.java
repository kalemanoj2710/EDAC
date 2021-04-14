package lists;

import java.util.ArrayList;
import java.util.Iterator;

public class IntegerList {

	public static void main(String[] args) {
		//create empty array list with def init capa
		ArrayList<Integer> list=new ArrayList<>();
		//size =0 , capa =10
		int[] data= {10,12,21,-45,10,23,56,77,89,12};
		//populate AL with this data
		for(int i :data)
			list.add(i);//int --->Integer : auto boxing list.add(Integer.valueOf(i))
		//display elems in AL
		System.out.println("AL contents via toString "+list);
		//for loop
		System.out.println("AL via for-loop");
		for(int i=0;i<list.size();i++)
			System.out.print(list.get(i)+" ");
//		list.add(0,null);
		System.out.println("\nAL contents via for-each ");
		for(int i : list) //Integer ---> int : auto un boxing
			System.out.print(i+" ");
		System.out.println("\n List contents via Iterator ");
		//1 : attach iterator
		Iterator<Integer> itr=list.iterator();
		System.out.println(itr.getClass().getName());//ArrayList$Itr
		//itr : before 1st elem.
		while(itr.hasNext())
			System.out.print(itr.next()+" ");
	//	System.out.println(itr.next()); NoSuchElem exc
		
		
		
		
		
			
		
		

	}

}
