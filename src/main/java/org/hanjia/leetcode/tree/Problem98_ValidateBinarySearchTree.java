package org.hanjia.leetcode.tree;

import java.util.PriorityQueue;
import java.util.Queue;

public class Problem98_ValidateBinarySearchTree {
	public boolean isValidBSTIterative(TreeNode root) {
		if (root == null)
			return true;

		Queue<BoundedNode> queue = new PriorityQueue<BoundedNode>();
		queue.offer(new BoundedNode(root, Double.MIN_VALUE, Double.MAX_VALUE));
		while (!queue.isEmpty()) {
			BoundedNode current = queue.poll();
			if (current.node.left != null
					&& current.node.right != null
					&& (current.node.val <= current.leftBound || current.node.val >= current.rightBound)) {
				return false;
			}
			
			if (current.node.left != null) {
				queue.offer(new BoundedNode(current.node.left, current.leftBound, current.node.val));
			}
			
			if (current.node.right != null) {
				queue.offer(new BoundedNode(current.node.right, current.node.val, current.rightBound));
			}
		}
		return true;
	}
	
	class BoundedNode {
		public TreeNode node;
		public double leftBound;
		public double rightBound;
		
	    public BoundedNode(TreeNode node, double left, double right){
	        this.node = node;
	        this.leftBound = left;
	        this.rightBound = right;
	    }
	}
    
	public boolean isValidBSTRecursive(TreeNode node) {
		return isValidBST(node, Double.MIN_VALUE, Double.MAX_VALUE);
	}
	
	public boolean isValidBST(TreeNode node, double min, double max) {
		if (node == null)
			return true;

		if (node.val <= min || node.val >= max)
			return false;

		return isValidBST(node.left, min, node.val)
				&& isValidBST(node.right, node.val, max);
	}
	
	public static void main(String[] args){
		
	}
}
