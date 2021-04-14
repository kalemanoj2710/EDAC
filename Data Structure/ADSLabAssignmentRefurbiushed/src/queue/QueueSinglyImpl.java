package queue;

public class QueueSinglyImpl implements IQueueSingly {

	
	public class QueueNode{
		private String data;
		private QueueNode next;
		
	}
	
	private QueueNode rear=null;
	private QueueNode front=null;
	private int size;
	//I don't know why i declared array i could have simply maintained size integer to 
	//declare capacity(setSize) , an since data is of string type i can store it in 
	//linked list having dynamic size and more efficient than array
	//oo bhai stack ke lie rakh lo
	private String[] arr=new String[size];
	
	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}
	

	//<<<<<<<<<<<<<<<<<<<<<<Methods>>>>>>>>>>>>>>>>>>>>>>
	@Override
	public void addElement(String str) {
		if(isFull())
		{System.out.println("Storing Capacity of Queue is Full");
			return;
		}
		QueueNode node=new QueueNode();
		node.data=str;
		if(isEmpty())
		{
			node.next=null;
			rear=node;
			front=node;
			
		}
		else
		{
		node.next=rear;
		rear=node;
		}
		
		
	}

	@Override
	public void deleteElement(String str) {
		if(isEmpty())
		{
			System.out.println("The Queue is Empty");
			return;
		}
		
		QueueNode trav=rear;
		//Element being the Only Element
		if(rear.data==front.data  )
			{
			if(front.data.equals(str))
			{
			rear=null;
			front=null;
			System.out.println("Empty queue BAchhe ki jaan lega");
			}
			else
				System.out.println("No such Element in Queue");
			return;
			}
			
		//Element being the first element i.e rearNode
		if(rear.data.equals(str))
			{
			rear=rear.next;
			return;
			}
		//Element being the last Element i.e frontNode
		if(front.data.equals(str))
		{
			//
		}
		//assuming element is in b/w rear and front
		while(trav!=front && !(trav.next.data.equals(str)) )
		{
			trav=trav.next;
		}
//		if(trav.next.data==num)
		if(trav.next==null)
		{
			System.out.println("Element Not Present in Queue }=> "+str);
            return;
		}
		else
		trav.next=trav.next.next;

		
	}

	@Override
	public String firstElement() {
		if(isEmpty())
		{
			System.out.println("The Queue is Empty");
			return "Nothing here";
		}
		else
		return front.data;
	}

	@Override
	public String lastElement() {
		if(isEmpty())
		{
			System.out.println("The Queue is Empty");
			return "Nothing here";
		}
		else {
		return rear.data;}
		
	}

	@Override
	public void printQueue() {
		if(isEmpty())
		{
			System.out.println("The Queue is Empty");
			return;
		}
		QueueNode trav=rear;
		while(trav!=null)
		{
		System.out.println(trav.data);
		trav=trav.next;
		}
		
	}

	@Override
	public boolean isFull() {
		int counter = 0;
		QueueNode trav=rear;
		while(trav!=null)
		{
			//System.out.println("Inside While Loop");
			trav=trav.next;
			counter=counter+1;
		}
		System.out.println("Capacity"+getSize());
		System.out.println("length of Queue"+counter);
		if(getSize()<=counter)
		return true;
		else
			return false;
		
	}

	@Override
	public boolean isEmpty() {
		if(rear==null )
			return true;
		else
			return false;
		
	}

}









