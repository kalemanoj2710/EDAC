package com.linklist;

public class Runner {

	public static void main(String[] args) {
		
		LinkList list=new LinkList();
		list.insert(2);
		list.insert(3);
		list.insert(4);
		list.insert(5);
		list.insert(6);
		list.insert(7);
		list.insertAtStart(12);
		list.insertAtPosition(2,13);
		list.show();

	}

}
