package tester;


import java.sql.Date;
import java.util.Scanner;

import dao.EmployeeDaoImpl;

public class TestJDBCLayers {

	public static void main(String[] args) {
		try(//init phase of the application : one time jobs 			
				Scanner sc=new Scanner(System.in);
									)
		{
			//create DAO instance
			EmployeeDaoImpl dao=new EmployeeDaoImpl();
			System.out.println("Enter deptid , start n end join date(yr-mon-day), enter 'quit' exit");
			while(true)
			{
				String deptId=sc.next();
				if(deptId.equalsIgnoreCase("quit"))
					break;
				dao.getAllEmpDetails(deptId, Date.valueOf(sc.next()), Date.valueOf(sc.next())).
				forEach(e -> System.out.println(e));
			
			}
			//clean up db resources
			dao.cleanUp();
		}catch (Exception e) {
		e.printStackTrace();
		}

	}

}
