package org.hanjia.leetcode.linkedlist;


/**
 * 
 * Given a linked list, remove the nth node from the end of list and return its head.
 * 
 * For example,
 * 
 * Given linked list: 1->2->3->4->5, and n = 2.
 * After removing the second node from the end, the linked list becomes 1->2->3->5.
 * 
 * Note:
 * Given n will always be valid.
 * Try to do this in one pass.
 * 
 * @author hanjia
 *
 */
public class Problem19_RemoveNthNodeFromEndOfList {
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode p1 = head;
		ListNode p2 = head;
		while (n > 0){
			p2 = p2.next;
			n--;
		}
		
		if(p2 == null){
		    return head.next;
		}
		
		while(p2.next != null){
			p2 = p2.next;
			p1 = p1.next;
		}
		
		p1.next = p1.next.next;
		return head;
    }
}
