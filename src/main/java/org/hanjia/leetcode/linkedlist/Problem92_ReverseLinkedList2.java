package org.hanjia.leetcode.linkedlist;

/**
 * 
 * Reverse a linked list from position m to n. Do it in-place and in one-pass.
 * 
 * For example:
 * Given 1->2->3->4->5->NULL, m = 2 and n = 4,
 * return 1->4->3->2->5->NULL.
 * 
 * Note:
 * Given m, n satisfy the following condition:
 * 1 ≤ m ≤ n ≤ length of list.
 * 
 * 
 * @author hanjia
 *
 */
public class Problem92_ReverseLinkedList2 {
	public ListNode reverseBetween(ListNode head, int m, int n) {
		if (m == n) {
			return head;
		}
	    
	    ListNode previousNodeForM = null; // track (m-1)th node	   
	    
	    // Two pointers: first's next points to mth; second's next points to (n+1)th
	    ListNode start = new ListNode(0); 
	    ListNode end = new ListNode(0); 
	 
	    // To determine m and n
	    int i = 0;
	    ListNode p = head;
	    while (p != null) {
	    	i++;
			if (i == m - 1) {
				previousNodeForM = p;
			}
			if (i == m) {
				start.next = p;
			}
			if (i == n) {
				end.next = p.next;
				p.next = null;
			}
			p = p.next;
	    }
	        
	    ListNode pre = start.next;
	    ListNode current = pre.next;
	    ListNode next = null;
	    
	    // connect to the part after n
	    pre.next = end.next;
	    
	    // reverse list [m, n]    
		while (current != null) {
			next = current.next;
			current.next = pre;
			pre = current;
			current = next;
		}
	 
	    // connect to the part prior to m
		if (previousNodeForM != null) {
			previousNodeForM.next = pre;
		} else {
			return pre;
		}
		
	    return head;
	}
}
