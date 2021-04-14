package stack;
public class Employee {
public int id;
public String name;
public double salary;
public Employee() {}
public Employee(int id,String name,double salary) {
	this.id=id;
	this.name=name;
	this.salary=salary;
}
@Override
public String toString() {
	return "Employee Details : \n Id: "+this.id+"\n Name :"+this.name+"\n Salary :"+this.salary;
	}

}
