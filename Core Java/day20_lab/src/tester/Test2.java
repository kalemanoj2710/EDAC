package tester;
import static utils.CollectionUtils.*;

import java.util.Map;

import com.app.core.Product;

public class Test2 {

	public static void main(String[] args) {
		//get a populated map of products
		Map<Integer, Product> map = populateMap(populateData());
		//Objective display on separate lines : Name of Product : Price
		//Map : forEach 
		map.forEach((i,p)->System.out.println("Name "+p.getName()+"@"+p.getPrice()));

	}

}
