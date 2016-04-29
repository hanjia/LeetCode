package org.hanjia.leetcode.linkedlist;

/**
 * 
 * Given a list, rotate the list to the right by k places, where k is non-negative.
 * 
 * For example:
 * Given 1->2->3->4->5->NULL and k = 2,
 * return 4->5->1->2->3->NULL.
 * 
 * @author hajia
 *
 */
public class Problem61_RotateList {
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null)
            return null;
            
        int length = 1;
        ListNode current = head;
        while(current.next != null){ // To get the length
            current = current.next;
            length++;
        }
        
        k = k % length;
        current.next = head; // Connect head and rear
        
        int steps = length - k - 1; // Need to move (length - k - 1) steps
        while(steps > 0){
            head = head.next;
            steps--;
        }
        ListNode result = head.next;
        head.next = null; // Disconnect head and rear
        
        return result;
    }
}
