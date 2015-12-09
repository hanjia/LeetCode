package org.hanjia.leetcode.tree;

/**
 * 
 * Given a binary tree, find the length of the longest consecutive sequence path.
 * 
 * The path refers to any sequence of nodes from some starting node to any node in the tree along the parent-child connections. The longest consecutive path need to be from parent to child (cannot be the reverse).
 * 
 * For example,
	   1
	    \
	     3
	    / \
	   2   4
	        \
	         5
 * Longest consecutive sequence path is 3-4-5, so return 3.
	   2
	    \
	     3
	    / 
	   2    
	  / 
	 1
 * Longest consecutive sequence path is 2-3, not 3-2-1, so return 2.
 * 
 * @author hajia
 *
 */
public class Problem298_BinaryTreeLongestConsecutiveSequence {
    public int longestConsecutive(TreeNode root) {
        return dfs(root, null, 0);
    }
    
    //In-order DFS
    private int dfs(TreeNode p, TreeNode parent, int length) {
        if (p == null) 
        	return length;
        length = (parent != null && p.val == parent.val + 1) ? length + 1 : 1;
        int maxLength = Math.max(dfs(p.left, p, length), dfs(p.right, p, length));
        return Math.max(length, maxLength);
    }
}
