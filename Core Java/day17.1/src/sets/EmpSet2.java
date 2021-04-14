package sets;

import java.util.HashSet;

import com.app.core.Emp;

public class EmpSet2 {

	public static void main(String[] args) {
		Emp e1=new Emp(101, "abc", "rnd", 10000);
		Emp e2=new Emp(10, "abc2", "rnd", 10000);
		Emp e3=new Emp(50, "abc3", "rnd", 10000);
		Emp e4=new Emp(67, "abc4", "rnd", 10000);
		//create empty HS to store emp type of refs
		HashSet<Emp> emps=new HashSet<>();
		System.out.println("Added "+emps.add(e1));//t , hc
		System.out.println("Added "+emps.add(e2));//t , hc , eq
		System.out.println("Added "+emps.add(e3));//t , hc , eq , eq
		System.out.println("Added "+emps.add(e4));//t , hc , eq : 3 (if new ref) or 1 (dup)
	
		System.out.println("size "+emps.size());//3
		System.out.println("Contents ");
		for(Emp e : emps)
			System.out.println(e);//no dups
	

	}

}
