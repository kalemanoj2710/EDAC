package custom_comparators;

import java.util.Comparator;

import com.app.core.Emp;

public class EmpJoinDateComparator implements Comparator<Emp>{
	@Override
	public int compare(Emp e1,Emp e2)
	{
		System.out.println("in compare  : join date");
		// > 0 : e1 has joined before e2 , 0 , < 0
		return e2.getJoinDate().compareTo(e1.getJoinDate());
		
	}

}
