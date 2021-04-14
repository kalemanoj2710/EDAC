package stack;
public class GrawableStack implements Stack {

	private Employee[] emp;
	
	 private int counter=0;
	 public GrawableStack() {
		 emp=new Employee[STACK_SIZE];
	}
		@Override
		public void push(Employee employ) {
			
			if(counter == emp.length-1) {
				
				Employee[] employeesNew = new Employee[emp.length * 2];
				for(int i = 0; i < emp.length; i++) {	
					employeesNew[i] = emp[i];	
				}
				emp = employeesNew;
			}
			emp[counter] = employ;	
			counter++;
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
			// TODO Auto-generated method stub
			
		}

}
