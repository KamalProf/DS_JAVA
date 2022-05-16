package com.sample.LinkedList;

import javax.naming.LinkException;
//https://java2blog.com/implement-stack-using-linked-list-in-java/
public class LIFOStack {
	private Node head; // the first node

	// nest class to define linkedlist node
	private class Node {
		int value;
		Node next;
	}

	public LIFOStack() {
		head = null;
	}

	// Remove value from the beginning of the list for demonstrating behaviour of stack
	public int pop() throws Exception {
		if (head == null) {
			throw new Exception();
		}
		int value = head.value;
		head = head.next;
		return value;
	}

	// Add value to the beginning of the list for demonstrating behaviour of stack
	public void push(int value) {
		Node oldHead = head;
		head = new Node();
		head.value = value;
		head.next = oldHead;
	}

	public static void main(String[] args) throws Exception {
		LIFOStack lls = new LIFOStack();
		lls.push(20);
		lls.push(50);
		lls.push(80);
		lls.push(40);
		lls.push(60);
		lls.push(75);
		System.out.println("Element removed from LinkedList: " + lls.pop());
		System.out.println("Element removed from LinkedList: " + lls.pop());
		lls.push(10);
		System.out.println("Element removed from LinkedList: " + lls.pop());
		printList(lls.head);
	}

	public static void printList(Node head) {
		Node temp = head;
		while (temp != null) {
			System.out.format("%d ", temp.value);
			temp = temp.next;
		}
		System.out.println();
	}

}

class LinkedListEmptyException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public LinkedListEmptyException() {
		super();
	}

	public LinkedListEmptyException(String message) {
		super(message);
	}
}
