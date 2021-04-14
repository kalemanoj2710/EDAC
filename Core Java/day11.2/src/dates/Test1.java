package dates;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Test1 {

	public static void main(String[] args) throws ParseException{
		SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
		Date d1 = new Date();
		System.out.println(d1);
		Date d2 = new Date(0);
		System.out.println(d2);
		System.out.println("d1 before d2" + d1.before(d2));// f
		System.out.println(d1.compareTo(d2));// 1
		Date d3=sdf.parse("12/3/2020");
		System.out.println(d3);//Date's toString : un formatted
		System.out.println(sdf.format(d3));
	}

}
