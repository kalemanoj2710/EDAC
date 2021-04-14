package p1;
import static utils.CollectionUtils.*;

import java.util.List;

import com.app.core.Product;
public class Test6 {

	public static void main(String[] args) {
		List<Product> list = populateData();
		//display names of all available products
		list.forEach(p -> System.out.println(p.getName()));
		
	}

}
