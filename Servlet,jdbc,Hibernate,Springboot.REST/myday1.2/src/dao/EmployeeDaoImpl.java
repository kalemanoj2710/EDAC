package dao;

import java.sql.*;
import java.sql.SQLException;
import java.util.List;
import static utils.DBUtils.fetchDBConnection;

import pojos.Employee;

public class EmployeeDaoImpl implements IEmployeeDao {
	//state
	private Connection cn;
	private PreparedStatement pst1;
	
	
	
@Override
public List<Employee> getAllEmployeeDetails(String dept,Date startDate,Date enddate) throws SQLException

	return null;
}
