package org.hanjia.leetcode.tree;

/**
 * 
 * Given a binary tree
	    struct TreeLinkNode {
	      TreeLinkNode *left;
	      TreeLinkNode *right;
	      TreeLinkNode *next;
	    }
 * Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.
 * 
 * Initially, all next pointers are set to NULL.
 * 
 * Note:
 * 
 * You may only use constant extra space.
 * You may assume that it is a perfect binary tree (ie, all leaves are at the same level, and every parent has two children).
 * For example,
 * Given the following perfect binary tree,
	         1
	       /  \
	      2    3
	     / \  / \
	    4  5  6  7
 * After calling your function, the tree should look like:
	         1 -> NULL
	       /  \
	      2 -> 3 -> NULL
	     / \  / \
	    4->5->6->7 -> NULL
 * 
 * 
 * @author hanjia
 *
 */
public class Problem116_PopulatingNextRightPointersInEachNode {
    public void connect(TreeLinkNode root) {
        if(root == null)
            return;
        
        //Use Three pointers
        TreeLinkNode current = root;
        TreeLinkNode next = root.left;
        while (current != null && next != null) {
            TreeLinkNode previous = null;
            while (current != null) {
                if (previous == null) {
                    previous = current.left;
                } else {
                    previous.next = current.left;
                    previous = previous.next;
                }
                previous.next = current.right;
                previous = previous.next;
                current = current.next;
            }
            current = next;
            next = current.left;
        }
    }
    
    public class TreeLinkNode {
    	int val;
    	TreeLinkNode left, right, next;
    	TreeLinkNode(int x) { 
    		val = x; 
    	}
    }  
}

