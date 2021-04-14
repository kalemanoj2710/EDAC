package dao;

import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

import pojos.Employee;

public interface IEmployeeDao {
//add a method declaration for fetching emp details , as per criteria
	List<Employee> getAllEmpDetails(String dept,Date startDate,Date endDate) throws SQLException;
}
