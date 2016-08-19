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
 * @author hanjia
 *
 */
public class Problem298_BinaryTreeLongestConsecutiveSequence {
    public int longestConsecutive(TreeNode root) {
        return dfs(root, null, 0);
    }
    
    // pre-order traversal
	private int dfs(TreeNode current, TreeNode parent, int length) {
		if (current == null)
			return length;
		
		length = (parent != null && current.val == parent.val + 1) ? length + 1 : 1;
		int leftLength = dfs(current.left, current, length);
		int rightLength = dfs(current.right, current, length);
		
		int maxLength = Math.max(leftLength, rightLength);
		return Math.max(length, maxLength);
	}
	
	public static void main(String[] args) {
		
	}
}
