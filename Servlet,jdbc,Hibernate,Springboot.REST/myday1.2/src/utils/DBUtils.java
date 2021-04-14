package utils;
import java.sql.*;

public interface DBUtils {
//add a static method for getting fix database connection
	public static Connection fetchDBConnection() throws ClassNotFoundException,SQLException
	{
	//load type IV MySql supplies JDBC driver class, under method area(meta space)
		Class.forName("com.mysql.cj.jdbc.Driver");
		//get the fix connection to DB
		String url="jdbc:mysql://localhost:3306/acts?useSSl=false";
		return DriverManager.getConnection(url, "root", "manoj1997");
	}
	
	
}
