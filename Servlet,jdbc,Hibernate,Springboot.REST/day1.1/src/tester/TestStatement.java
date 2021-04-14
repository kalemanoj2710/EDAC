package tester;

import static utils.DBUtils.fetchDBConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class TestStatement {

	public static void main(String[] args) {
		String sql = "select * from my_emp";
		try (// get fixed db connection
				Connection cn = fetchDBConnection();
				// create empty statement object, to a hold a query (later : @ exec time)
				Statement st = cn.createStatement();
				// exec query : public ResultSet executeQuery(String sql) throws SQLException
				ResultSet rst = st.executeQuery(sql);) {
			System.out.println("Emp Data");
			// rst cursor : before 1st row
			while (rst.next())
				System.out.printf("ID %d Name %s Address %s Salary %.2f Dept %s Joined on %s%n",
						rst.getInt(1),
						rst.getString(2), rst.getString(3), rst.getDouble(4), rst.getString(5), rst.getDate(6));

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
