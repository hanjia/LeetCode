package org.hanjia.leetcode.tree;

/**
 * 
 * Given a binary tree, check whether it is a mirror of itself (i.e, symmetric around its center).
 * 
 * For example, this binary tree is symmetric:
	    1
	   / \
	  2   2
	 / \ / \
	3  4 4  3
 * But the following is not:
	    1
	   / \
	  2   2
	   \   \
	   3    3
 * 
 * 
 * @author hanjia
 *
 */
public class Problem101_SymmetricTree {
	public boolean isSymmetric(TreeNode root) {
	    if (root == null) {
	        return true;
	    }
	    return helper(root.left, root.right);
	}

	private boolean helper(TreeNode left, TreeNode right) {
	    if (left == null && right == null) {
	        return true;
	    }
	    if (left == null || right == null) {
	        return false;
	    }
	    return (left.val == right.val) && helper(left.left, right.right) 
	        && helper(left.right, right.left);
	}
}
