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
        ListNode cur = head;
        ListNode next = null;
        while (cur != null) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
}
