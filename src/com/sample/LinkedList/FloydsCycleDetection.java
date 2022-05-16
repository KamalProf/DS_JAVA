package com.sample.LinkedList;

//https://www.youtube.com/watch?v=jcZtMh_jov0
//https://www.geeksforgeeks.org/detect-and-remove-loop-in-a-linked-list/
public class FloydsCycleDetection {
	

	// Function to detect a cycle in a linked list using
	// Floyd’s cycle detection algorithm
	public static boolean detectCycle(Node head) {
		// take two references – `slow` and `fast`
		Node fast = head;
		Node slow = head;
		while (slow != null && fast != null && fast.next != null) {
			// move slow by one
			slow = slow.next;
			// move fast by two
			fast = fast.next.next;
			// if they meet any node, the linked list contains a cycle
			if (slow == fast) {
				System.out.println("Cycle detected");
				return true;
			}
		}
		System.out.println("No Cycle detected");
		return false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// input keys
		int[] keys = { 1, 2, 3, 4, 5 };
		Node head = null;
		for (int i = keys.length - 1; i >= 0; i--) {
			head = new Node(keys[i], head);
		}
		// insert cycle
		head.next.next.next.next.next = head.next.next;
		if (detectCycle(head)) {
			System.out.println("Cycle Found");
		}
		else {
			System.out.println("No Cycle Found");
		}
	}

}


