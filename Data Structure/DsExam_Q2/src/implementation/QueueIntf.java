package implementation;

public interface QueueIntf {
	// Push the number on stack.
	public void push(int elem);

	// Return the topmost element and remove it from stack.
	public int pop();

	// Return the topmost element without removing it from stack.
	public int top();

	// Return true if stack is empty else false.
	public boolean isEmpty();

	// Return true if stack is full else false.
	public boolean isFull();
}
