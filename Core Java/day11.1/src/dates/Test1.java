package dates;

import java.util.Date;

public class Test1 {

	public static void main(String[] args) {
		Date d1 = new Date();
		System.out.println(d1);
		Date d2 = new Date(0);
		System.out.println(d2);
		System.out.println("d1 before d2" + d1.before(d2));// f
		System.out.println(d1.compareTo(d2));// 1
	}

}
