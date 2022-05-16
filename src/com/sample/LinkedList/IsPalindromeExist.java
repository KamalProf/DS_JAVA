package com.sample.LinkedList;

public class IsPalindromeExist {
	
	public boolean isPalindrome(ListNode head) {
		if (head == null)
				return false;
		// find the mid of LinkedList
		ListNode mid = middle(head); //Call mid function
		ListNode last = reverse(mid.next); // Call reverse function
		ListNode current = head;
		while (last.next!=null) {
			if(last.data != current.data)
				return false;
			current = current.next;
			last = last.next;
		}
		return true;

	}
	
	public ListNode middle(ListNode head) {
		ListNode slow = head;
		ListNode fast = head;
		while ( fast!=null && fast.next!=null) {
			slow= slow.next;
			fast = fast.next.next;
		}
		return slow;
	}
	
	public ListNode reverse(ListNode head) {
		ListNode current = head;
		ListNode previous = null;
		ListNode temp = null;
		while (current != null) {
			temp = current.next;
			current.next = previous;
			previous = current;
			current= temp;
		}
		head = previous;
		return head;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
