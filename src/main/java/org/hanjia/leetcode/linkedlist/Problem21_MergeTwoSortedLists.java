package org.hanjia.leetcode.linkedlist;

/**
 * Merge two sorted linked lists and return it as a new list. 
 * The new list should be made by splicing together the nodes of the first two lists.
 * 
 * @author hajia
 *
 */
public class Problem21_MergeTwoSortedLists {
	
	public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		if (l1 == null)
			return l2;
		if (l2 == null)
			return l1;
		ListNode dummy = new ListNode(-1);
		ListNode current = dummy;

		while (l1 != null && l2 != null) {
			if (l1.val <= l2.val) {
				current.next = l1;
				l1 = l1.next;
			} else {
				current.next = l2;
				l2 = l2.next;
			}
			current = current.next;
		}

		if (l1 != null) { // To attach the rest of List 1 directly to the result list
			current.next = l1;
		}
		
//		while(l1 != null) {
//			current.next = l1;
//			l1 = l1.next;
//			current = current.next;
//		}

		if (l2 != null) {
			current.next = l2;
		}

		return dummy.next;
	}
    
    public static void main(String[] args){
    	ListNode l1 = new ListNode(1);
    	l1.next = new ListNode(3);
    	l1.next.next = new ListNode(4);
    	l1.next.next.next = new ListNode(5);
    	
    	ListNode l2 = new ListNode(0);
    	l2.next = new ListNode(2);
  	
    	ListNode mergedList = mergeTwoLists(l1, l2);
    	while(mergedList != null){
    		System.out.println(mergedList.val);
    		mergedList = mergedList.next;
    	}
    }
}
