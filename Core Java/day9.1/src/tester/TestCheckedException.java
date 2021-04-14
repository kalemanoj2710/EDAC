package tester;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class TestCheckedException {

	public static void main(String[] args) throws FileNotFoundException,IOException {
		Scanner sc = new Scanner(System.in);
		try {
			System.out.println("Enter text file name to read data from");
			// java.io.FileReader(String fileName) throws FileNotFoundException
			// javac forces the handling of checked excs
			FileReader fin = new FileReader(sc.nextLine());
			fin.close();// IOException
			System.out.println("end of try....");
		} catch (FileNotFoundException e) {
			System.out.println("file not found....");
		} catch (IOException e) {
			System.out.println("err in closing file");
		}
		System.out.println("cntd...");
		sc.close();

	}

}
