package org.hanjia.leetcode.tree;

import org.hanjia.leetcode.linkedlist.ListNode;

/**
 * 
 * Given a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.
 * 
 * @author hanjia
 *
 */
public class Problem109_ConverSortedListIntoBinarySearchTree {
    private ListNode current;

    public TreeNode sortedListToBST(ListNode head) {
        current = head;
        int size = getSize(head);
        return build(0, size - 1);
    }

    private int getSize(ListNode head) {
        int size = 0;
        while (head != null) {
            size++;
            head = head.next;
        }
        return size;
    }
    
    private TreeNode build(int start, int end) {
        if (start > end) {
            return null;
        }
        int mid = start + (end - start) / 2;
        TreeNode left = build(start, mid - 1);
        TreeNode root = new TreeNode(current.val);
        current = current.next;
        TreeNode right = build(mid + 1, end);
    
        root.left = left;
        root.right = right;
        return root;
    }
}
