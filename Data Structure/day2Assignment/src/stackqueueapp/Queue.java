package stackqueueapp;


public interface Queue {

	public void add(int x);
	public void delete();
	public boolean isFull();
	public boolean isEmpty();
	void display();
}
