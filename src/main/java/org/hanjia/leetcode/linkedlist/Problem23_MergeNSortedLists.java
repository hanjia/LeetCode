package org.hanjia.leetcode.linkedlist;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;


/**
 * Merge k sorted linked lists and return it as one sorted list. 
 * 
 * 
 * @author hajia
 *
 */
public class Problem23_MergeNSortedLists {
	
	public ListNode mergeNLists(ArrayList<ListNode> lists) {
		if (lists.size() == 0) 
			return null;
 
		PriorityQueue<ListNode> queue = new PriorityQueue<ListNode>(lists.size(),
				new Comparator<ListNode>() {
					public int compare(ListNode a, ListNode b) {
						if (a.val > b.val)
							return 1;
						else if(a.val == b.val)
							return 0;
						else 
							return -1;
					}
				});
 
		//add first node of each list to the queue
		for (ListNode list: lists) {
			if (list != null)
				queue.add(list);
		}
 
		ListNode dummy = new ListNode(-1);
		ListNode current = dummy;
 
		while (queue.size() > 0) {
			ListNode temp = queue.poll(); //get the top node from the queue
			current.next = temp;
 
			//keep adding next element of the node we just fetched from the queue
			if (temp.next != null) {
				queue.add(temp.next);
			}
			current = current.next;
		}
 
		return dummy.next;
	}
}
