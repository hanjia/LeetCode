package org.hanjia.leetcode.tree;

/**
 * 
 * Given a binary tree, determine if it is height-balanced.
 * 
 * For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
 * 
 * @author hanjia
 *
 */
public class Problem110_BalancedBinaryTree {
	public boolean isBalanced(TreeNode root) {
		if (getMaxDepth(root) == -1) {
			return false;
		}
		return true;
	}

	public int getMaxDepth(TreeNode node) {
		if (node == null) {
			return 0;
		}
		int left = getMaxDepth(node.left);
		int right = getMaxDepth(node.right);
		if (left == -1 || right == -1 || Math.abs(left - right) > 1) {
			return -1;
		}
		return Math.max(left, right) + 1;
	}
}
