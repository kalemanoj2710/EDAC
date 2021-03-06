package com.app.core;

import interfaces.SListQ2;

public class SListImplQ2 implements SListQ2 {

//	creating a new node
	public class SListNode {
		int data;
		SListNode next;
	}

	private SListNode head;
	private SListNode tail;

	public SListImplQ2() {
		head = null;
		tail = null;
	}

	@Override
	public void push(int element) {
		SListNode newNode = new SListNode();
		newNode.data = element;
		newNode.next = head;
		if (head == null) {
			head = newNode;
			tail = newNode;
			return;
		}
		head = newNode;
	}

	@Override
	public int top() {
		if (head == null)
			return 0;
		return head.data;

	}

	@Override
	public int pop() {
		if (head == null) {
			return -1;
		} else {
			SListNode currentNode = head;
			int deletedElem = head.data;
			currentNode = currentNode.next;
			head = currentNode;
			return deletedElem;
		}

	}

	@Override
	public boolean isEmpty() {
		if (head == null)
			return true;
		return false;
	}

	@Override
	public boolean isFull() {
		if (head == null)
			return false;
		return true;
	}

	@Override
	public void printStack() {
		SListNode curr = head; // 1. Set curr to head
		while (curr != null) {
			// 2.
			System.out.println(curr.data); // 2.1 process curr's data
			curr = curr.next; // 2.2 make curr point to curr's next node
		}
	}

}
