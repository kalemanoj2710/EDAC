package com.stack.linklist;

public class Runner {

	public static void main(String[] args) {
		 Stack obj = new Stack(); 
		    obj.push(11);
	        obj.push(22);
	        obj.push(33);
	        obj.push(44);
	 
	     
	        obj.display();
	 
	        System.out.printf("Top element is : "+ obj.peek());
	 
	        obj.pop();
	        obj.pop();
	        System.out.println();
	 
	        obj.display();
	 
	     
	        System.out.printf("Top element is : " + obj.peek());
	    

	}

}
