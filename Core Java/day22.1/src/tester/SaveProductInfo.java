package tester;

import static com.app.core.Category.FRUITS;
import static java.time.LocalDate.parse;

import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.FileOutputStream;

import com.app.core.Product;

public class SaveProductInfo {

	public static void main(String[] args) {
		//Store single product information in binary file , using filtering streams
		Product p1=new Product(100, "mango", FRUITS, parse("2019-01-01"), 500);
		//chain of I/O streams
		//Java App  ---->  DOS (conversion stream) ---->BOS (buffering) ----> FOS(node strm)---->Bin File
		try(DataOutputStream out=new DataOutputStream
		(new BufferedOutputStream(new FileOutputStream("products.data"))))
		{
			//id , name , category , date , price

			
		}catch (Exception e) {
		e.printStackTrace();
		}
		System.out.println("main over....");
		

	}

}
