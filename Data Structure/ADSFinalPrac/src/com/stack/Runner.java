package com.stack;

public class Runner {

	public static void main(String[] args) {
		Stack s=new Stack();
		s.insert(5);
		s.insert(9);
		s.insert(7);
		s.insert(3);
		s.insert(8);
	 System.out.println("last element entered into stack is : "+s.peek());
		s.show();
		s.pop();
		s.show();
		

	}

}
