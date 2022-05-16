package com.sample.LinkedList;

import com.sample.LinkedList.AddTwoIntegers.ListNode;
//https://www.techiedelight.com/merge-given-sorted-linked-lists/
//https://www.youtube.com/watch?v=KVf1Uuqfv8E
//Input l1= 1->2->4 ,l2= 1->3->4
//Output l3 = 1->1->2->3->4->4

public class MergeTwoLists {
	
	public static ListNode mergeTwoLists(ListNode l1,ListNode l2) {
		//Start with the head node
		ListNode temp_node = new ListNode(0);
		ListNode current_node = temp_node;
		while (l1 != null || l2 != null) {
			// add shortest value first 
			if(l1.data < l2.data) {
				current_node.next = l1;
				l1 = l1.next;
			}else {
				current_node.next = l2;
				l2 = l2.next;
			}
			//Update Current Node
			current_node = current_node.next;
		}
		return temp_node.next;
	}

	public static void main(String[] args) {
        ListNode head1 = new ListNode(1);
        head1.next = new ListNode(2);
        head1.next.next = new ListNode(4);

        ListNode head2 = new ListNode(1);
        head2.next = new ListNode(3);
        head2.next.next = new ListNode(4);

        ListNode result = mergeTwoLists(head1, head2);
        while (result != null) {
            System.out.print(result.data + " ");
            result = result.next;
        }

	}

}
