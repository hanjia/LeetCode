package org.hanjia.leetcode.linkedlist;


/**
 * 
 * Remove all elements from a linked list of integers that have value val.
 * 
 * Example:
 * Given: 1 --> 2 --> 6 --> 3 --> 4 --> 5 --> 6, val = 6
 * Return: 1 --> 2 --> 3 --> 4 --> 5
 * 
 * @author hanjia
 *
 */
public class Problem203_RemoveLinkedListElements {
	public ListNode removeElements(ListNode head, int val) {
	    ListNode dummy = new ListNode(-1);
	    ListNode pre = dummy;
	    dummy.next = head;
	    while (head != null) {
	        if (head.val == val) {
	            pre.next = head.next;
	            head = head.next;
	            continue;
	        }
	        pre = head;
	        head = head.next;
	    }
	    return dummy.next;
	}
}
