package stackqueueclass;

import stackqueueapp.Queue;

public class MyQueue implements Queue {
	private int[] queue;
	private int front=0;
	private int rear=0;
	public MyQueue(int size) {
		queue=new int[size];
	}
	@Override
	public void add(int x) {
	if(!isFull()) {
		queue[rear]=x;
		rear++;
		System.out.println(x+"Added to The Queue");
	}
	else
		System.out.println("Queue Is Full !!");
		
	}

	@Override
	public void delete() {
		if(!isEmpty()) {
			int temp=queue[front];
			queue[front]=0;
			front++;
			System.out.println(temp +"Is Deleted From Queue");
		}
		else
			System.out.println("Queue is Empty !!");
	}

	@Override
	public boolean isFull() {
		if(rear==queue.length)
			return true;
		return false;
		
	}

	@Override
	public boolean isEmpty() {
		if(front==rear)
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
