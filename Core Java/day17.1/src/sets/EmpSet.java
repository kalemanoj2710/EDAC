package sets;

import java.util.HashSet;

import com.app.core.Emp;

public class EmpSet {

	public static void main(String[] args) {
		Emp e1=new Emp(101, "abc", "rnd", 10000);
		Emp e2=new Emp(101, "abc", "rnd", 10000);
		//create empty HS to store emp type of refs
		HashSet<Emp> emps=new HashSet<>();
		System.out.println("Added "+emps.add(e1));//true
		System.out.println("Added "+emps.add(e2));//exp : false
		System.out.println("size "+emps.size());//2
		System.out.println("Contents ");
		for(Emp e : emps)
			System.out.println(e);//dups : id
		System.out.println(e1.hashCode()+" "+e2.hashCode());//different
		System.out.println(e1.equals(e2));//true

	}

}
