package org.hanjia.leetcode.linkedlist;

/**
 * 
 * Reverse a singly linked list.
 * 
 * @author hanjia
 *
 */
public class Problem206_ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode current = head;
        ListNode next = null;
        while (current != null) {
            next = current.next;
            current.next = pre;
            pre = current;
            current = next;
        }
        return pre;
    }
}
