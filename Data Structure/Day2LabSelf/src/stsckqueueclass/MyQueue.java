package stsckqueueclass;

import stackqueueapp.Queue;

public class MyQueue implements Queue {
	private int[] queue;
	private int front = 0;
	private int rear = 0;

	public MyQueue(int size) {
		queue = new int[size];
	}

	@Override
	public void add(int x) {
		if (!isFull()) {
			queue[rear] = x;
			++rear;
			System.out.println(x + "Added to queue");
		}else
			System.out.println("Queue is full...");

	}

	@Override
	public int delete() {
		if(!isEmpty()) {
			int temp=queue[front];
			//queue[front]=0;
			++front;
			System.out.println(temp +"Is Deleted From Queue");
			return temp;
		}else
		return -1;
	}

	@Override
	public boolean isEmpty() {
		if(front==rear)
			return true;
		return false;
	}

	@Override
	public boolean isFull() {
		if(rear==queue.length)
			return true;
		return false;
	}

	@Override
	public void display() {
		for(int i: queue)
			if(i !=0)
				System.out.print(i +" ");

	}


}
