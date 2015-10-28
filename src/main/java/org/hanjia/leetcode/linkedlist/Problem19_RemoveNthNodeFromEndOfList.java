package org.hanjia.leetcode.linkedlist;

/**
 * Given a linked list, remove the nth node from the end of list and return its head.
 * 
 * For example,
 * Given linked list: 1->2->3->4->5, and n = 2.
 * After removing the second node from the end, the linked list becomes 1->2->3->5.
 * 
 * 
 * Algorithm:
 * Set two pointers: First one at the beginning of the list; Second one at the node which is n steps away from the first
 * Then move both them until the second point reaches the end of the list so the first pointer should be at the nth node from the end.
 * Just remove the node that the first pointer points to.
 * 
 * 
 * @author hajia
 *
 */
public class Problem19_RemoveNthNodeFromEndOfList {

}
