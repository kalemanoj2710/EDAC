package tester;
import static utils.DBUtils.fetchDBConnection;
import java.sql.*;
import java.util.Scanner;

public class TestPST {

	public static void main(String[] args) {
		String sql="select empid,name,salary,join_date from my_emp where deptid=? and join_date between ? and ?";
		try(//init phase of the application : one time jobs 
				//get cn to db
				Connection cn=fetchDBConnection();
				Scanner sc=new Scanner(System.in);
				//create pre-parsed n pre compiled stmt 
				PreparedStatement pst=cn.prepareStatement(sql);		
				
				)
		{
			System.out.println("Enter deptid , start n end join date(yr-mon-day), enter 'quit' exit");
			while(true)
			{
				String deptId=sc.next();
				if(deptId.equalsIgnoreCase("quit"))
					break;
				//Set IN params : dept strt end
				pst.setString(1,deptId);//dept id
				pst.setDate(2,Date.valueOf(sc.next()));//start date
				pst.setDate(3,Date.valueOf(sc.next()));//end date
				//exec method : executeQuery
				try(ResultSet rst=pst.executeQuery())
				{
					while(rst.next())
						System.out.printf("ID %d Name %s Salary %.1f Joined on %s %n",
								rst.getInt(1),rst.getString(2),rst.getDouble(3),rst.getDate(4));
				}
			}
		}catch (Exception e) {
		e.printStackTrace();
		}

	}

}
