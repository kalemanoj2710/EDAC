package tester;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.time.LocalDate;

import com.app.core.Category;
import com.app.core.Product;

public class RestoreProductDetails {

	public static void main(String[] args) {
		// Java App <------DIS<----- BIS <------ FIS <------Bin File
		try (DataInputStream in = new DataInputStream
				(new BufferedInputStream(new FileInputStream("products.data")))) {
			Product p = new Product(in.readInt(), in.readUTF(), Category.valueOf(in.readUTF()),
					LocalDate.parse(in.readUTF()), in.readDouble());
			System.out.println("Restored product details from a bin file "+p);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
