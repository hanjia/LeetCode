package org.hanjia.leetcode.linkedlist;

/**
 * Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.
 * 
 * If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.
 * 
 * You may not alter the values in the nodes, only nodes itself may be changed.
 * 
 * Only constant memory is allowed.
 * 
 * For example, given this linked list: 1->2->3->4->5
 * For k = 2, you should return: 2->1->4->3->5
 * For k = 3, you should return: 3->2->1->4->5
 * 
 * @author hanjia
 *
 */
public class Problem25_ReverseNodesInKGroup {

	public ListNode reverseKGroup(ListNode head, int k) {  
	    if(head == null){  
	        return null;  
	    } 
	    
	    ListNode dummy = new ListNode(0);  
	    dummy.next = head;  
	    ListNode pre = dummy;  
	    ListNode current = head;  
	    
	    int count = 0;  
	    while(current != null){  
	        count++;  
	        ListNode next = current.next; 	        
	        if(count == k){  
	            pre = reverse(pre, next);  
	            count = 0;     
	        }  
	        current = next;  
	    } 
	    
	    return dummy.next;  
	}
	
	private static ListNode reverse(ListNode start, ListNode end) {  
		if (start == null || start.next == null)
			return start;
	    
	    ListNode head = start.next;  
	    ListNode current = start.next.next; 
	    
		while (current != end) {
			ListNode next = current.next;
			current.next = start.next;
			start.next = current;
			current = next;
		}
	    
	    head.next = end;  
	    return head;  
	} 
}


