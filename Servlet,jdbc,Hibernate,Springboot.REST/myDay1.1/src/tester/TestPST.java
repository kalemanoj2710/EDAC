package tester;
import static utils.DBUtils.fetchDBConnection;
import java.sql.*;
import java.util.Scanner;
public class TestPST {
	public static void main(String[] args) {
		String sql="select empid,name,salary,join_date from my_emp where deptid=? and join_date between ? and ?";
      try(//init phase of the apll:one time jobs
    		  //get cn to db
    		  Connection cn=fetchDBConnection();
    		  Scanner sc=new Scanner(System.in);
    		  //create prepassed and precompiled statement
    		  PreparedStatement pst=cn.prepareStatement(sql);
    		  ) 
      {
    	  System.out.println("Enter dept id, start n end join date, enter 'quit' exit");
    	  while(true)
    	  {
    		  String deptID=sc.next();
    		  if(deptID.equalsIgnoreCase("quit"))
    			  break;
    		  //Set in params;dept start n end data
    		  pst.setString(1, deptID);//deptId
    		  pst.setDate(2, Date.valueOf(sc.next()));//start date
    		  pst.setDate(3, Date.valueOf(sc.next()));// end date
    		  //exec method :executeQuery 
    		  try(ResultSet rst=pst.executeQuery())
    		  {
    			  while(rst.next())
    				  System.out.printf("ID %d Name %s salary %.1f Joined on %s %n",
    						  rst.getInt(1),rst.getString(2),rst.getDouble(3),rst.getDate(4));
    			  
    		  }
    		  
    	  }
    	  
		
	} catch (Exception e) {
		e.printStackTrace();
	}
	}
}
