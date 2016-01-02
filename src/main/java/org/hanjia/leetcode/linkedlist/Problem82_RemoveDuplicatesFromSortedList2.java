package org.hanjia.leetcode.linkedlist;

/**
 * 
 * Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.
 * 
 * For example,
 * Given 1->2->3->3->4->4->5, return 1->2->5.
 * Given 1->1->1->2->3, return 2->3.
 * 
 * @author hanjia
 *
 */
public class Problem82_RemoveDuplicatesFromSortedList2 {
	public ListNode deleteDuplicates(ListNode head) {
	    ListNode previous = new ListNode(0);
	    previous.next = head;
	 
	    ListNode current = previous;
	    while(current.next != null && current.next.next != null){
	        if(current.next.val == current.next.next.val){
	            int dup = current.next.val;
	            while(current.next != null && current.next.val == dup){
	            	current.next = current.next.next;
	            }
	        }else{
	        	current = current.next;
	        }
	 
	    }
	 
	    return previous.next;
	}
}
