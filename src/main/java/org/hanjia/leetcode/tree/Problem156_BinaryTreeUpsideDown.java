package org.hanjia.leetcode.tree;

/**
 * 
 * Given a binary tree where all the right nodes are either leaf nodes with a sibling (a left node that shares the same parent node) or empty, 
 * flip it upside down and turn it into a tree where the original right nodes turned into left leaf nodes.
 * Return the new root.
 * 
 * For example:
 * Given a binary tree {1,2,3,4,5},
	    1
	   / \
	  2   3
	 / \
	4   5
 * return the root of the binary tree [4,5,2,#,#,3,1].
	   4
	  / \
	 5   2
	    / \
	   3   1  
 * 
 * 
 * @author hanjia
 *
 */
public class Problem156_BinaryTreeUpsideDown {
	 
	public TreeNode upsideDownBinaryTree(TreeNode root) {
		if(root == null)
			return null;
		return upsideDownBinaryTreeHelper(root, null);
	}
	    
	private TreeNode upsideDownBinaryTreeHelper(TreeNode root, TreeNode parent) {
		if (root == null)
			return parent;

		TreeNode newNode = upsideDownBinaryTreeHelper(root.left, root);
		root.left = (parent == null) ? null : parent.right;
		root.right = parent;
		return newNode;
	}
	
	public static void main(String[] args) {
    	TreeNode root = new TreeNode(1);
    	root.left = new TreeNode(2);
    	root.right = new TreeNode(3);
    	root.left.left = new TreeNode(4);
    	root.left.right = new TreeNode(5);
		Problem156_BinaryTreeUpsideDown upsideDown = new Problem156_BinaryTreeUpsideDown();
		TreeNode result = upsideDown.upsideDownBinaryTree(root);
		System.out.println(result.val);
		System.out.println(result.left.val);
		System.out.println(result.right.val);
		System.out.println(result.right.left.val);
		System.out.println(result.right.right.val);
	}
}
