package utils;
import java.sql.*;

public interface DBUtils {
//add a static method for getting a FIXED DB connection
	static Connection fetchDBConnection(String drvrClass,String url,String userName,String password) throws ClassNotFoundException,SQLException
	{
		//load Type IV JDBC driver
		Class.forName(drvrClass);
		return DriverManager.getConnection(url, userName,password);
	}
	
}
