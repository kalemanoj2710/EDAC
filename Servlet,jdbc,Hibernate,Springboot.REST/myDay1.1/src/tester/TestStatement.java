package tester;

import static utils.DBUtils.fetchDBConnection;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class TestStatement {
	public static void main(String[] args) {
		String sql="select * from my_emp";
		try (// get fixed db connection
				Connection cn = fetchDBConnection();
		// create empty statement object to hold a query(later: @exec time)
		Statement st = cn.createStatement();
				//exec query : public ResultSet executeQuery(String sql) thnrows SQLException
				ResultSet rst=st.executeQuery(sql);
		)
		{
			//rst cursor before first row
			while(rst.next())
				System.out.printf("ID %d Name %s Address %s salary %f Dept %s Join on %s%n",
					rst.getInt(1),
					rst.getString(2), rst.getString(3), rst.getDouble(4), rst.getString(5), rst.getDate(6));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
