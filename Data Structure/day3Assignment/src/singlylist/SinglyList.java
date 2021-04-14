package singlylist;

public class SinglyList {
	class SListNode{
		int data;
		SListNode next;
		
	}
	private SListNode head;
	public SinglyList() {
		head=null;
	}
	
	public void addAtFront(int no) {
		SListNode n=new SListNode();
		n.data=no;
		n.next=head;
		head=n;
		
	}
	
	public void printList() {
		SListNode cursur=head;
		while(cursur != null) {
			System.out.print(cursur.data+" ");
			cursur=cursur.next;
		}
	}
	
	public int count() {
		SListNode cursur=head;
		int count=0;
		while(cursur != null) {
			count++;
			cursur=cursur.next;
		}
		return count;
	}
	
	public int countFrequency(int no) {
		SListNode cursur=head;
		int frequency=0;
		while(cursur != null) {
			if(cursur.data==no) {
				frequency++;
			}
			cursur=cursur.next;
		}
		return frequency;
	}
	
	public boolean find(int no) {
		SListNode cursur=head;
		
		while(cursur != null) {
			if(cursur.data==no) {
				return true;
			}
			cursur=cursur.next;
		}
		return false;
	}

}
