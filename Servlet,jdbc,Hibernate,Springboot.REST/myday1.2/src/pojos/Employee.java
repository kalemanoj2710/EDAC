package pojos;
//empid | name    | addr    | salary | deptid | join_date

import java.sql.Date;

public class Employee {
	private int empId;
	private String name, address;
	private double salary;
	private String deptid;
	private Date joinDate;

	public Employee() {

	}

	public Employee(int empId, String name, String address, double salary, String deptid, Date joinDate) {
		super();
		this.empId = empId;
		this.name = name;
		this.address = address;
		this.salary = salary;
		this.deptid = deptid;
		this.joinDate = joinDate;
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public String getDeptid() {
		return deptid;
	}

	public void setDeptid(String deptid) {
		this.deptid = deptid;
	}

	public Date getJoinDate() {
		return joinDate;
	}

	public void setJoinDate(Date joinDate) {
		this.joinDate = joinDate;
	}

	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", name=" + name + ", address=" + address + ", salary=" + salary
				+ ", deptid=" + deptid + ", joinDate=" + joinDate + "]";
	}

}
