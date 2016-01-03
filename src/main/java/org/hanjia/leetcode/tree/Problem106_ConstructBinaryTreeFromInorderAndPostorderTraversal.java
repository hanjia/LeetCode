package org.hanjia.leetcode.tree;

/**
 * 
 * Given inorder and postorder traversal of a tree, construct the binary tree.
 * 
 * Note:
 * You may assume that duplicates do not exist in the tree.
 * 
 * 
 * @author hanjia
 *
 */
public class Problem106_ConstructBinaryTreeFromInorderAndPostorderTraversal {
	public TreeNode buildTree(int[] inorder, int[] postorder) {
		int inorderStart = 0;
		int inorderEnd = inorder.length - 1;
		int postorderStart = 0;
		int postorderEnd = postorder.length - 1;	 
		return buildTree(inorder, inorderStart, inorderEnd, postorder, postorderStart, postorderEnd);
	}
	 
	public TreeNode buildTree(int[] inorder, int inorderStart, int inorderEnd, int[] postorder, int postorderStart, int postorderEnd) {
		if ((inorderStart > inorderEnd) || (postorderStart > postorderEnd))
			return null;
	 
		int rootValue = postorder[postorderEnd]; // Use postorder to get root element
		TreeNode root = new TreeNode(rootValue);
	 
		int k = 0; // Find parent element index from inorder
		for (int i = 0; i < inorder.length; i++) {
			if (inorder[i] == rootValue) {
				k = i;
				break;
			}
		}
	 
		root.left = buildTree(inorder, inorderStart, k - 1, postorder, postorderStart, postorderStart + k - (inorderStart + 1));
		root.right = buildTree(inorder, k + 1, inorderEnd, postorder, postorderStart + k - inorderStart, postorderEnd - 1);	 
		return root;
	}
}
