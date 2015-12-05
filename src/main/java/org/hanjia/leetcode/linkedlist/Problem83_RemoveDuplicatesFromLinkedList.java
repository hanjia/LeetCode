package org.hanjia.leetcode.linkedlist;

/**
 * 
 * Given a sorted linked list, delete all duplicates such that each element appear only once.
 * 
 * For example,
 * Given 1->1->2, return 1->2.
 * Given 1->1->2->3->3, return 1->2->3.
 * 
 * @author hanjia
 *
 */
public class Problem83_RemoveDuplicatesFromLinkedList {
    public static ListNode deleteDuplicates(ListNode head) {
        ListNode cur = head;
        while (head != null) {
            while (head.next != null && head.next.val == head.val) {
                head.next = head.next.next;
            }
            head = head.next;
        }
        return cur;
    }
}
