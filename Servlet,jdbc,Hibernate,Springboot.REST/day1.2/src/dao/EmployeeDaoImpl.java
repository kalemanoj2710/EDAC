package dao;

import java.sql.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import static utils.DBUtils.fetchDBConnection;

import pojos.Employee;

public class EmployeeDaoImpl implements IEmployeeDao {
	// state
	private Connection cn;
	private PreparedStatement pst1;

	// def constr : invoked by Tester , exactly once @ init phase of app
	public EmployeeDaoImpl() throws ClassNotFoundException, SQLException {
		String sql = "select empid,name,salary,join_date from my_emp where deptid=? and join_date between ? and ?";
		// get db cn
		cn = fetchDBConnection();
		// pst
		pst1 = cn.prepareStatement(sql);
		System.out.println("emp dao created...");

	}

	// invoked by Tester : once per clnt's request : in clnt's servicing phase
	@Override
	public List<Employee> getAllEmpDetails(String dept, Date startDate, Date endDate) throws SQLException {
		List<Employee> emps = new ArrayList<>();
		// set IN params
		pst1.setString(1, dept);
		pst1.setDate(2, startDate);
		pst1.setDate(3, endDate);
		try (ResultSet rst = pst1.executeQuery()) {
			while (rst.next())
				emps.add(new Employee(rst.getInt(1), rst.getString(2), rst.getDouble(3), rst.getDate(4)));
		}
		return emps;
	}

	// invoked by Tester : once @ ending phase(destroy) of app
	public void cleanUp() throws SQLException {
		if (pst1 != null)
			pst1.close();
		if (cn != null)
			cn.close();
		System.out.println("emp dao clened up...");

	}

}
