package test_iterator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class Test1 {

	public static void main(String[] args) {
		ArrayList<Integer> list=new ArrayList<>(Arrays.asList(1,21,3,4,512,34,51));
		Iterator<Integer> itr=list.iterator();
//		list.add(1234);// strt modification
	//	list.remove(0);// strt modification
		list.set(0, 9999);// no strt modification
		System.out.println("List elems");
	//	itr.remove();//illegal state exc
		while(itr.hasNext()) {
			int i=itr.next();
			
//			if(i > 10)
//				itr.remove();
			System.out.println(i);
	//		itr.remove();
	//		itr.remove();//illegal state exc
		}
	//	System.out.println(itr.next());no such elem exc
	//	System.out.println(list.get(list.size()));index out of bounds exc : valid range of indices : 0 ---size-1
		System.out.println("list again");
		list.forEach(i->System.out.println(i));

	}

}
