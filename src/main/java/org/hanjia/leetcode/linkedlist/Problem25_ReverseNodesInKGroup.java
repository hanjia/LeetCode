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
	    int count = 0;  
	    
	    ListNode h = new ListNode(0);  
	    h.next = head;  
	    ListNode pre = h;  
	    ListNode current = head;  
	    
	    while(current != null){  
	        count ++;  
	        ListNode next = current.next; 	        
	        if(count == k){  
	            pre = reverse(pre, next);  
	            count = 0;     
	        }  
	        current = next;  
	    }  
	    return h.next;  
	}
	
	private static ListNode reverse(ListNode pre, ListNode end) {  
	    if(pre==null || pre.next==null)  
	        return pre;  
	    
	    ListNode head = pre.next;  
	    ListNode current = pre.next.next; 
	    
	    while(current!= end){  
	        ListNode next = current.next;  
	        current.next = pre.next;  
	        pre.next = current;  
	        current = next;  
	    }  
	    
	    head.next = end;  
	    return head;  
	} 
}


