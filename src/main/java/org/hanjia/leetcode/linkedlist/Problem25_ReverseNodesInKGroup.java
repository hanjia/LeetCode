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
	    ListNode prev = dummy;  
	    ListNode current = head;  
	    
	    int count = 0;  
	    while(current != null){  
	        count++;  
	        ListNode next = current.next; 	        
	        if(count == k){  
	            prev = reverse(prev, next);  
	            count = 0;     
	        }  
	        current = next;  
	    } 
	    
	    return dummy.next;  
	}
	
	private static ListNode reverse(ListNode start, ListNode end) {  // For [1, 3] group, start node is 0 and end is 4
		if (start == null || start.next == null)
			return start;
	    
	    ListNode prev = start.next; // To track the first node in the group
	    ListNode current = start.next.next; 
	    ListNode next = null;
	    
		while (current != end) {
			next = current.next;
			current.next = start.next;
			start.next = current;
			current = next;
		}
	    
		prev.next = end; // Connect to next group
	    return prev;  
	} 
	
    public static void main(String[] args){
    	ListNode l1 = new ListNode(1);
    	l1.next = new ListNode(2);
    	l1.next.next = new ListNode(3);
    	l1.next.next.next = new ListNode(4);
    	l1.next.next.next.next = new ListNode(5);
    	l1.next.next.next.next.next = new ListNode(6);
    	Problem25_ReverseNodesInKGroup reverse = new Problem25_ReverseNodesInKGroup();
    	ListNode head = reverse.reverseKGroup(l1, 3);
    	while(head != null) {
    		System.out.println(head.val);
    		head = head.next;
    	}
    }	
}


