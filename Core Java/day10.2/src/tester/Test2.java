package tester;

import com.app.core.Emp;

public class Test2 {

	public static void main(String[] args) {
		Object e1 = new Emp(101, "Rama", 10000);//up casting
		Object e2 = new Emp(100, "Rama123", 40000);
		System.out.println(e1.equals(e2));// false

	}

}
