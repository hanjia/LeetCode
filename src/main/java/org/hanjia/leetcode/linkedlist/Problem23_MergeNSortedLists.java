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
		if (lists.size() == 0) return null;
 
		PriorityQueue<ListNode> q = new PriorityQueue<ListNode>(lists.size(),
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
		for (ListNode list : lists) {
			if (list != null)
				q.add(list);
		}
 
		ListNode head = new ListNode(-1);
		ListNode p = head;
 
		while (q.size() > 0) {
			ListNode temp = q.poll(); //get the top node from the queue
			p.next = temp;
 
			//keep adding next element of the node we just fetched from the queue
			if (temp.next != null)
				q.add(temp.next);
 
			p = p.next;
		}
 
		return head.next;
	}
}
