package com.sample.LinkedList;

public class ReverseLinkedList_Iterative {

	public Node reverseList(Node node) {
		Node prev = null;
		Node current = node;
		Node next = null;
		while (current != null) {
			next = current.next;
			current.next = prev;
			prev = current;
			current = next;
		}
		node = prev;
		return node;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}
	
	
	class Node {
		int data;
		Node next;

		Node(int data) {
			data = data;
			next = null;
		}
	}	
}



/*
Iterative Approach
We will use 3 variables: prevNode, head, and nextNode.
prevNode to NULL
nextNode can stay empty;

Then we will continue our loop until our current maidenhead pointer is truthy (ie: not NULL), 
which implies that we reached the end of the linked list

During our loop, we first of all update nextNode so that it acquires its namesake value, as head->next.
Finally, we update the head with the value we stored in nextNode.
And finally, we go on with the loop until we can. After the loop, we return prevNode.
*/
//https://www.youtube.com/watch?v=ugQ2DVJJroc
//https://www.geeksforgeeks.org/reverse-a-linked-list/