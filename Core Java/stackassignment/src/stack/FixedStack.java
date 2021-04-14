package stack;

import java.util.Arrays;

public class FixedStack implements Stack {
 private Employee[] emp;
 private int counter=0;
 
 public FixedStack() {
	 emp=new Employee[STACK_SIZE];
 }
	@Override
	public void push(Employee employ) {
		if(counter < STACK_SIZE) {
			emp[counter]=employ;
		counter++;
		}
		else {
			
			System.out.println("Stack is full!!");
		
		}
	}

	@Override
	public Employee pop() {
		if(counter != 0) {
			counter --;
			Employee temp=emp[counter];
			emp[counter]=null;
			return temp;
		}
		else {
			System.out.println("Stack is Empty !!");
		}
		return null;
	}
	@Override
	public String toString() {
		String empData="";
		for(Employee employee:emp) {
			if(null != employee) {
			 empData = " "+employee.toString();
			}
		}
		return empData;
	}
	@Override
	public void display() {
		
		System.out.println(Arrays.toString(emp));
		
	}

}
