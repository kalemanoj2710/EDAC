package dao;

import java.sql.Date;
import java.util.List;

import pojos.Employee;

public interface IEmployeeDao {
//add a method declaration for fetching employee details as per criteria
	List<Employee> getAllEmployeeDetails(String dept,Date startDate,Date enddate) throws SQLException;
	
	
}
