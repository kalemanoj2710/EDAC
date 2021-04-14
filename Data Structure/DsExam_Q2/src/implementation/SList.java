package implementation;

public class SList {

	public class SingleListNode { 						    			 	// 		1. MAKE A NODE CLASS
		int data;													    				//			 node has data of int type
		SingleListNode next;										  				 // 			 node has (next) part contain null or add. of next node i.e. next should be of class type
	}
	
	private SingleListNode head;											// we require head  as a pointer which will initialise in consructor to NULL

	public SList() {											       				// we will intialise (head) pointer to the NULL
		head = null;
	}
	public void addAtEnd(int no) {
		SingleListNode endNode = new SingleListNode();			// Node Create
		endNode.data = no;														// enter data of node
		endNode.next = null;														// next part should be NULL as we are adding at end 
		if (head != null) {														// if we dont have empty list thenn
			SingleListNode current = head;  								// create a current pointer for traversing
			while (current.next != null)										// traverse till we have (next) value as a null to get last position
				current = current.next;										
			current.next = endNode;											//just assign address of the new node to the next part of the last node
		} else																			// if we have empty list then assign new node to the head
			head = endNode;
	}
	
	public int getFront() {														// to get front element
		if(head == null)															// if linked list is empty then it will return 0
			return -1;
		else
			return head.data;														// if linked list is not empty then return data
	}
	
	public int removeFront() {														// to Remove front element
		if(head == null) {															// if linked list is empty then it will give msg
			System.out.println("NO elment to Pop");
			return -1;
		}
		else	if(head.next == null) {
				int popEle = head.data;
				head=null;					// if there is only one node then head will point to null
				return popEle;
		}
		else {
			head = head.next;													// now head is pointing from second node hence we have deleted 1st node	 														
			int popEle = head.data;
			return popEle;
		}
	}
	
	public boolean isEmpty() {														// to check is it empty or not
		if(head == null)																	// if linked list is empty then it will return true
			return true;
		else 
			return false;																	// if linked list is not empty then it will return false
	}
	
	public void printlist() {															
		SingleListNode current = head;										// create a current pointer for traversing
		while (current != null) 													// traverse till we wil get node object as null
		{
			System.out.println("Element :" + current.data);	// print particular data
			current = current.next;
		}
	}
}
