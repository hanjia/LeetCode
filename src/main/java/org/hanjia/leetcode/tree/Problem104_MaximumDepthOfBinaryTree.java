package org.hanjia.leetcode.tree;

/**
 * 
 * Given a binary tree, find its maximum depth.
 * 
 * The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
 * 
 * @author hanjia
 *
 */
public class Problem104_MaximumDepthOfBinaryTree {
	public int getMaxDepth(TreeNode root) {
	    if (root == null) {
	        return 0;
	    }
	    return 1 + Math.max(getMaxDepth(root.left), getMaxDepth(root.right));
	}
}
