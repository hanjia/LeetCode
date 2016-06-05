package org.hanjia.leetcode.linkedlist;

/**
 * Given a linked list, swap every two adjacent nodes and return its head.
 * 
 * For example, given 1->2->3->4, you should return the list as 2->1->4->3.
 * 
 * @author hanjia
 *
 */
public class Problem24_SwapNodeInPair {	
	public static ListNode swapPairs(ListNode head) {
		if (head == null || head.next == null)
			return head;

		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode pre = dummy;
		ListNode current = head;
		
		while (current != null && current.next != null) {
			pre.next = current.next;
			current.next = current.next.next;
			pre.next.next = current;
			pre = current;
			current = current.next;			
		}

		return dummy.next;
	}
	
	public static void main(String[] args){
		ListNode node2 = new ListNode(1);
		node2.next = new ListNode(2);
		node2.next.next = new ListNode(3);
		node2.next.next.next = new ListNode(4);
		node2.next.next.next.next = new ListNode(5);
		node2.next.next.next.next.next = new ListNode(6);
		node2.next.next.next.next.next.next = new ListNode(7);
		node2.next.next.next.next.next.next.next = new ListNode(8);
		node2.next.next.next.next.next.next.next.next = new ListNode(9);
		node2.next.next.next.next.next.next.next.next.next = new ListNode(10);
		
		ListNode result = swapPairs(node2);
		while(result != null){
			System.out.println(result.val);
			result = result.next;
		}

	}
}
