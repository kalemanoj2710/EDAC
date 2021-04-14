package tester;

import com.app.core.Emp;

public class Test1 {

	public static void main(String[] args) {
		Emp e1=new Emp(101, "Rama", 10000);
		Emp e2=new Emp(101, "Rama123", 40000);
		Emp e3=e1;
		System.out.println(e1.equals(e2));//true
		System.out.println(e1.equals(e3));//true
		System.out.println(e1.hashCode()+" "+e2.hashCode()+" "+e3.hashCode());

	}

}
