package utils;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Map;

import com.app.core.Product;

public interface IOUtils {
	//add a static method for storing all product details in bin file : using serialization
	static void saveProducts(Map<Integer, Product> productMap, String fileName) throws IOException
	{
		//chain of strms
		//Java App ---> OOS ---> FOS ---> Bin file
		try(ObjectOutputStream out=new ObjectOutputStream(new FileOutputStream(fileName)))
		{
			out.writeObject(productMap);//serialization
			//JVM chks serializabilty of ENTIRE obj graph : HashMap : YES , 
			//Key : Integer : YES , 
			//Product : NO : entire ser fails : throws exc
		}
	}
}
