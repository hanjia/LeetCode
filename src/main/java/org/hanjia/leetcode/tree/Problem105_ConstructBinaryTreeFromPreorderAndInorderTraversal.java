package org.hanjia.leetcode.tree;

/**
 * 
 * Given preorder and inorder traversal of a tree, construct the binary tree.
 * 
 * Note:
 * You may assume that duplicates do not exist in the tree.
 * 
 * @author hanjia
 *
 */
public class Problem105_ConstructBinaryTreeFromPreorderAndInorderTraversal {
	public TreeNode buildTree(int[] preorder, int[] inorder) {
	    int preorderStart = 0;
	    int preorderEnd = preorder.length-1;
	    int inorderStart = 0;
	    int inorderEnd = inorder.length-1;
	    return construct(preorder, preorderStart, preorderEnd, inorder, inorderStart, inorderEnd);
	}
	 
	public TreeNode construct(int[] preorder, int preorderStart, int preorderEnd, int[] inorder, int inorderStart, int inorderEnd){
	    if((preorderStart > preorderEnd) || (inorderStart > inorderEnd)){
	        return null;
	    }
	 
	    int rootValue = preorder[preorderStart]; // Use preorder to get root element
	    TreeNode p = new TreeNode(rootValue);
	 
	    int k = 0; // Find parent element index from inorder
	    for(int i = 0; i < inorder.length; i++){
	        if(rootValue == inorder[i]){
	            k = i;
	            break;
	        }
	    }
	 
	    p.left = construct(preorder, preorderStart + 1, preorderStart + (k - inorderStart), inorder, inorderStart, k - 1);
	    p.right= construct(preorder, preorderStart + (k - inorderStart) + 1, preorderEnd, inorder, k + 1, inorderEnd); 
	    return p;
	}
}
