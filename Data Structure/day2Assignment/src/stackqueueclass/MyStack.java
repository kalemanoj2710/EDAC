package stackqueueclass;

import stackqueueapp.Stack;

public class MyStack implements Stack {

	private int[] stack;
	private int top=-1;
	public MyStack(int size) {
		stack=new int[size];
	}
	@Override
	public void push( int x) {
		if(!isFull()) {
			++top;
			stack[top]=x;
			System.out.println(x+"Added to The Stacks");
		}
		else
			System.out.println("Stack is full !!");
		
	}

	@Override
	public void pop() {
		if(!isEmpty()) {
			int temp=stack[top];
			stack[top]=0;
			top--;
			System.out.println(temp +"Removed from Stack");
		}
		else
			System.out.println("Stack is Empty !!");
		
	}

	@Override
	public boolean isFull() {
		if(top==stack.length-1)
			return true;
		
		return false;
		
	}

	@Override
	public boolean isEmpty() {
		if(top==-1)
			return true;
		return false;
		
	}

	@Override
	public void display() {
		for(int i:stack) {
			if(i != 0) {
				System.out.print(i +" ");
			}
		}
		
	}
	
	@Override
	public void displayInReverse() {
		for(int i=stack.length;i>=0;i--) {
			if(i != 0) {
				System.out.print(i+" ");
			}
		}
		
	}

	
}
