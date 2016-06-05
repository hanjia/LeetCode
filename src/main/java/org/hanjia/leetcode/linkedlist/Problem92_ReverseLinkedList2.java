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
	    
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode pre = dummy;
		ListNode current = head;

	    // To determine m and n
	    int i = 0;
	    while (current != null) {
	    	i++;
			if (i == m - 1) {
				pre = current;
			}
			if (i == n) {
				break;
			}
			current = current.next;
	    }
	        
		pre = reverse(pre, current.next);		
	    return dummy.next;
	}
	
	private ListNode reverse(ListNode start, ListNode end) {  // For [1, 3] , start node is 0 and end node is 4
	    ListNode pre = start.next; // To track the the last node in the group after reversal
	    ListNode current = pre.next; 
	    	    
		while (current != end) {
			pre.next = current.next;
			current.next = start.next;
			start.next = current;
			current = pre.next;
		}
	    
	    return pre;  
	} 
	
    public static void main(String[] args){
    	ListNode l1 = new ListNode(1);
    	l1.next = new ListNode(2);
    	l1.next.next = new ListNode(3);
    	l1.next.next.next = new ListNode(4);
    	l1.next.next.next.next = new ListNode(5);
    	l1.next.next.next.next.next = new ListNode(6);
    	Problem92_ReverseLinkedList2 reverse = new Problem92_ReverseLinkedList2();
    	ListNode head = reverse.reverseBetween(l1, 2, 4);
    	while(head != null) {
    		System.out.println(head.val);
    		head = head.next;
    	}
    }	
	
}
