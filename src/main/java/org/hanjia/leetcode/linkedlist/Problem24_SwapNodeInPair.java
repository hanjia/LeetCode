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
	    if(head == null || head.next == null)   
	        return head;
	 
	    ListNode h = new ListNode(0);
	    h.next = head;
	    ListNode p = h;
	 
	    while(p.next != null && p.next.next != null){
	        ListNode t1 = p; //use t1 to track 0th node
	        p = p.next;
	        t1.next = p.next;
	 
	        ListNode t2 = p.next.next; 	//use t2 to track 3rd node
	        p.next.next = p;
	        p.next = t2;  	
	    }
	 
	    return h.next;
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
			System.out.println("Result: " + result.val);
			result = result.next;
		}

	}
}
