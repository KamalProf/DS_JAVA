package com.sample.LinkedList;

//https://www.youtube.com/watch?v=SMIq13-FZSE
class ListNode 
{
	int data;
	ListNode next;
	public ListNode(int data) {
		this.data = data;
		this.next = null;
	}
}

public class MyLinkedList {
	ListNode head;

	public void insert(int data) {
		ListNode node = new ListNode(data);
		if (head == null) {
			head = node;
		} else {
			ListNode n = head;
			while (n.next != null) {
				n = n.next;
			}
			n.next = node;
		}
	}

	public void insertAtStart(int data) {
		ListNode node = new ListNode(data);
		node.next = head;
		head = node;
	}

	public void insertAtIndex(int index, int data) {
		ListNode node = new ListNode(data);
		if (index == 0) {
			insertAtStart(data);
		} else {
			ListNode prev = head;
			for (int i = 0; i < index - 1; i++) {
				prev = prev.next;
			}
			node.next = prev.next;
			prev.next = node;
		}
	}

	public void deleteAtIndex(int index) {
		if (index == 0) {
			head = head.next;
		} else {
			ListNode n = head;
			ListNode n1 = null;
			for (int i = 0; i < index - 1; i++) {
				n = n.next;
			}
			n1 = n.next;
			n.next = n1.next;
			// System.out.println("n1 " + n1.data);
			n1 = null;
		}
	}

	public void show() {
		ListNode node = head;
		while (node.next != null) {
			System.out.println(node.data);
			node = node.next;
		}
		System.out.println(node.data);
	}

	public static void main(String[] args) {
		MyLinkedList list = new MyLinkedList();
		list.insert(18);
		list.insert(45);
		list.insert(12);
		list.insertAtStart(25);
		list.insertAtIndex(0, 55);
		list.deleteAtIndex(2);
		list.show();
	}
}


