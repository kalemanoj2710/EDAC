package p1;
import static utils.CollectionUtils.*;

import java.util.Map;
import static java.util.Map.Entry;

import com.app.core.Product;
public class Test7 {

	public static void main(String[] args) {
		//get populated map of products
		Map<Integer, Product> map = populateMap(populateData());
	//	System.out.println(map);
		//display entries from this map : on separate lines
//		for(Entry e : map.entrySet())
//			System.out.println(e.getKey()+":"+e.getValue());
		map.forEach((i,p) -> System.out.println(i+":"+p));

	}

}
