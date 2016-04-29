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
	    ListNode dummy = new ListNode(0);
	    dummy.next = head;
	 
	    ListNode current = dummy;
	    while(current.next != null && current.next.next != null){
	        if(current.next.val == current.next.next.val){
	            int dup = current.next.val;
	            current.next = current.next.next;
	            
	            // To exhaust all the duplicates
	            while(current.next != null && current.next.val == dup){
	            	current.next = current.next.next;
	            }
	        }else{
	        	current = current.next;
	        }	 
	    }
	 
	    return dummy.next;
	}
	
	public static void main(String[] args){
		ListNode node = new ListNode(1);
		node.next = new ListNode(2);
		node.next.next = new ListNode(3);
		node.next.next.next = new ListNode(3);
		node.next.next.next.next = new ListNode(4);
		node.next.next.next.next.next = new ListNode(4);
		node.next.next.next.next.next.next = new ListNode(4);
		node.next.next.next.next.next.next.next = new ListNode(5);
		Problem82_RemoveDuplicatesFromSortedList2 object = new Problem82_RemoveDuplicatesFromSortedList2();
		ListNode result = object.deleteDuplicates(node);
		while(result != null) {
			System.out.println(result.val);
			result = result.next;
		}			
	}
}
