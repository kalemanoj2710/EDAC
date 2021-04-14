package dates;

import java.text.SimpleDateFormat;
import java.util.Scanner;

import com.app.core.Emp;

public class Test2 {
	public static SimpleDateFormat sdf;
	static {
		sdf=new SimpleDateFormat("yyyy-MM-dd");
	}

	public static void main(String[] args) {

		// Accept emp details n create emp instance
		try (Scanner sc = new Scanner(System.in)) {
			System.out.println("Enter emp details : id nm sal join date(yr-mon-day) ");
			Emp e1 = new Emp(sc.nextInt(), sc.next(), sc.nextDouble(), sdf.parse(sc.next()));
			System.out.println(e1);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
