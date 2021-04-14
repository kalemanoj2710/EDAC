package char_io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;

public class BufferedFileRead {

	public static void main(String[] args) {
		System.out.println("Enter file name along with path");
		try (Scanner sc = new Scanner(System.in);
				// Java App <-----BR : buffering strm<-----FR : Node strm<-----Text File device
				BufferedReader br = new BufferedReader(new FileReader(sc.nextLine()))) {
			//chain of strms created.
			//imperative style
			System.out.println("File Contents");
			String line=null;
			while((line=br.readLine())!= null)
				System.out.println(line);
			System.out.println("File read over....");
			

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
