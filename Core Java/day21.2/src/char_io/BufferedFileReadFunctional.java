package char_io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;

public class BufferedFileReadFunctional {

	public static void main(String[] args) {
		System.out.println("Enter file name along with path");
		try (Scanner sc = new Scanner(System.in);
				// Java App <-----BR : buffering strm<-----FR : Node strm<-----Text File device
				BufferedReader br = new BufferedReader(new FileReader(sc.nextLine()))) {
			//chain of strms created.
			//imperative style
			System.out.println("File Contents");
		    br.lines()//Stream<Stirng> => line
		    .forEach(System.out::println);
			System.out.println("File read over....");
			

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
