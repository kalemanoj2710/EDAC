package stsckqueueclass;

import stackqueueapp.Stack;

public class MyStack implements Stack {
	private int[] stack;
	private int top;
	// private int size;

	public MyStack(int size) {
		stack = new int[size];
		top = -1;
	}

	@Override
	public void push(int x) {
		if (!isEmpty()) {
			++top;
			stack[top] = x;
			System.out.println(x + "Added to stack");
		} else
			System.out.println("Stack is Full...");
	}

	@Override
	public int pop() {
		if (!isEmpty()) {
			int temp = stack[top];
			--top;
			System.out.println(temp + "remove from stack");
			return temp;
		} else
			System.out.println("Stack is empty...");
		return -1;
	}

	@Override
	public boolean isEmpty() {
		if (top == -1)
			return true;
		else
			return false;
	}

	@Override
	public boolean isFull() {
		if (top == stack.length - 1)
			return true;
		else
			return false;
	}

	@Override
	public void display() {
		for (int i : stack) {
			if (i != 0)
				System.out.print(i + " ");
		}
	}

	@Override
	public void displayInReverse() {
		for (int i = stack.length - 1; i >= 0; i--)
			if (i != 0)
				System.out.print(i + " ");
	}
}
