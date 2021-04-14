package com.stack;

public class Stack {
	
	int [] stack=new int[5];
			
	int top=0;
	int size;
	
	
	public void insert(int data) {
		
		if(isEmpty()) {
			
			stack[top]=data;
			top++;
			size++;
		}
		else {
			System.out.println("Stack is full");
		}
	
	}
	
	public int pop() {
		int data;
		top--;
		data=stack[top];
		stack[top]=0;
		return data;
	}
	
	public int peek() {
		int data;
		data=stack[top-1];
		
		return data;
	}
	
	public boolean isEmpty() {
		
		if(top==size-1) {
			System.out.println("Stack is full");
			return false;
		}
		
		return true;
	}
	
	public boolean isFull() {
		
		if(top==-1) {
			return false;
		}
		return true;
	}
	
	public void show() {
		for(int c:stack) {
			System.out.print(c+" ");
		}
		System.out.println();
		
	}
	
	

}
