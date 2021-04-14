package implementation;

public class MyQueue implements QueueIntf {

SList obj = new SList();
	
	int front;
	int rear;
	int size;
	
	public MyQueue(int size) {
		front = -1;         	// to remove
		rear = -1;     	   // to add	
		this.size = size;  // to decide size of Queue
	}
	
	
	@Override
	public void push(int elem) {
		if (isFull())
			System.out.println("Queue Is Full..!!!");
		else {
		++rear;
		obj.addAtEnd(elem);
		System.out.println("Element " + elem + " Has Been Pushed Successfully..!!");
		}
	}

	@Override
	public int pop() {
		if (isEmpty())
			return -1;
		else {
		++front;
		return obj.removeFront();
		}
	}

	@Override
	public int top() {
		if(isEmpty())
			//System.out.println("Queue is Empty");
			return -1;
		else {
			return obj.getFront();
		}
	}

	@Override
	public boolean isEmpty() {
		if (front == rear)					// checking is empty or not
			return true;
		return false;
	}

	@Override
	public boolean isFull() {
		if (rear == (size - 1))			// checking is full or not
			return true;
		return false;
	}
	
	public void displayQueue() {
		if (isEmpty())
			System.out.println("Queue is Empty..!!!");
		else
			obj.printlist();
	}
}
