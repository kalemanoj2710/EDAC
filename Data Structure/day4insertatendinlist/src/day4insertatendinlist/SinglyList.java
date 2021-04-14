package day4insertatendinlist;

public class SinglyList {
	private SListNode head;
	class SListNode{
		int data;
		SListNode next;
	}
	
	public void addAtEnd(int no) {
		SListNode node=new SListNode();
		node.data=no;
		node.next=null;
		if(head ==null) {
			head=node;
		}
		else {
			SListNode last=head;
			while(last.next !=null) {
				last=last.next;
			}
			last.next=node;
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
