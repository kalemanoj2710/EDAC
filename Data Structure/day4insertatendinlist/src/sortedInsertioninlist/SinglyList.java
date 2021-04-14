package sortedInsertioninlist;

public class SinglyList {
	private SListNode head;
	class SListNode{
		int data;
		SListNode next;
	}
	
	public void insert(int no) {
		SListNode node=new SListNode();
		node.data=no;
		node.next=null;
		if(head ==null) {
			head=node;
		}
		else {
			SListNode previous=null;
			SListNode current=head;
			while(current !=null && current.data < node.data) {
				previous=current;
				current=current.next;	
			}
			node.next=current;
			previous.next=node;
		}
		
	}
	
	public void display() {
	
		SListNode current=head;
		while(current !=null) {
			System.out.print(current.data+" ");
			current=current.next;
		}
	}

}
