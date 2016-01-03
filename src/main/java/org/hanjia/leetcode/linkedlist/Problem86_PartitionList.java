package org.hanjia.leetcode.linkedlist;

/**
 * 
 * Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.
 * 
 * You should preserve the original relative order of the nodes in each of the two partitions.
 * 
 * For example,
 * Given 1->4->3->2->5->2 and x = 3,
 * return 1->2->2->4->3->5.
 * 
 * @author hanjia
 *
 */
public class Problem86_PartitionList {
    public ListNode partition(ListNode head, int x) {
        ListNode h1 = new ListNode(0);
        ListNode h2 = new ListNode(0); 
        ListNode t2 = h2;
        
        h1.next = head;
        head = h1;
        
        while(head.next != null) {
            if (head.next.val < x) {  // skip node
                head = head.next;
            } else {  // remove node from h1 and insert to the tail of h2
                t2.next = head.next;
                head.next = head.next.next;
                t2 = t2.next;
                t2.next = null;
            }
        }
        
        head.next = h2.next;
        head = h1.next;
        return head;
    }
}
