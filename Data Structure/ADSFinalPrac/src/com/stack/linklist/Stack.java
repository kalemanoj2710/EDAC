package com.stack.linklist;

public class Stack {
	
	 Node top;
	 
	 Stack()
	    {
	        this.top = null;
	    }
	
	public void push(int x) // insert at the beginning
    {
       
        Node temp = new Node();
 
        
        if (temp == null) {
            System.out.println("Heap Overflow");
            return;
        }
    
        temp.data = x;
        temp.next = top;
        top = temp;
    }
    public boolean isEmpty()
    {
        return top == null;
    }

    public int peek()
    {
        
        if (!isEmpty()) {
        	 System.out.println();
            return top.data;
        }
        else {
            System.out.println("Stack is empty");
            System.out.println();
            return -1;
        }
        
    }
 
    public void pop() 
    {
        if (top == null) {
            System.out.println("Stack Underflow");
            return;
        }
 
        top = (top).next;
    }
 
    public void display()
    {
       
        if (top == null) {
            System.out.println("Stack Underflow");
          
        }
        else {
            Node temp = top;
            while (temp != null) {
 
                System.out.print(temp.data +" ");
 
                temp = temp.next;
            }
            System.out.println();
        }
    }
}
        
    



