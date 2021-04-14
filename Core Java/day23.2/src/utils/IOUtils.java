package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Map;

import com.app.core.Product;

public interface IOUtils {
//add a static method to restore product details using de -serialization
	@SuppressWarnings("unchecked")
	static Map<Integer, Product> restoreProduct(String fileName) throws IOException,ClassNotFoundException
	{
		//validate if file : exists , regular data file , read permission : before creating chain of I/O streams
		//java.io.File : class => meta data of file /folder(dir) : abstract path that refers to a file or a folder
		//File (String fileName/path)
		File file=new File(fileName);//File class instance simply wraps a path
		if(file.exists() && file.isFile() && file.canRead())
		{
			//readable , existing data file ---> attach i/o strms
			//Java app <----OIS <--- FIS <----Bin file
			try(ObjectInputStream in=new ObjectInputStream(new FileInputStream(file)))
			{
				//de -serial
				return (Map<Integer, Product>)in.readObject();
				
			}
			
		}
		return null;
		
	}
}
