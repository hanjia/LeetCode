package org.hanjia.leetcode.linkedlist;


/**
 * 
 * Given a linked list, return the node where the cycle begins. If there is no cycle, return null.
 * 
 * Note: Do not modify the linked list.
 * 
 * @author hanjia
 *
 */
public class Problem142_LinkedListCycle2 {
	public ListNode detectCycle(ListNode head) {
	    ListNode fast = head;
	    ListNode slow = head;
	    while (fast != null && fast.next != null) {
	        fast = fast.next.next;
	        slow = slow.next;
	        if (fast == slow) {
	            slow = head;
	            while (slow != fast) {
	                fast = fast.next;
	                slow = slow.next;
	            }
	            return slow;
	        }
	    }
	    return null;
	}
}
