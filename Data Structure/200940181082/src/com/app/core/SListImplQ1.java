package com.app.core;

import interfaces.SListQ1;

public class SListImplQ1 implements SListQ1 {

//	creating a new node
	public class SListNode {
		int data;
		SListNode next;
	}

	private SListNode head;
	private SListNode tail;

	public SListImplQ1() {
		head = null;
		tail = null;
	}

	@Override
	public void addAtEnd(int element) {
		SListNode newNode = new SListNode();
		newNode.data = element;

		if (head == null) {
			head = newNode;
			tail = newNode;
			newNode.next = head;
			return;
		} else {
			tail.next = newNode;
			tail = newNode;
		}
	}

	@Override
	public int getFront() {
		if (head == null)
			return 0;
		return head.data;

	}

	@Override
	public void removeFront() {
		if (head == null) {
			System.out.println("No element to remove..!!!");
		} else {
			SListNode currentNode = head;
			currentNode = currentNode.next;
			head = currentNode;
		}
	}

	@Override
	public boolean isEmpty() {
		if (head == null)
			return true;
		return false;
	}

	@Override
	public void printList() {
		SListNode curr = head; // 1. Set curr to head
		while (curr != null) {
			// 2.
			System.out.println(curr.data); // 2.1 process curr's data
			curr = curr.next; // 2.2 make curr point to curr's next node
		}
	}

}
