package org.hanjia.leetcode.tree;

import java.util.Stack;

/**
 * 
 * Given a binary tree, flatten it to a linked list in-place.
 * 
 * For example,
 * 
 * Given
	         1
	        / \
	       2   5
	      / \   \
	     3   4   6
 * The flattened tree should look like:
	   1
	    \
	     2
	      \
	       3
	        \
	         4
	          \
	           5
	            \
	             6
 * 
 * 
 * @author hanjia
 *
 */
public class Problem114_FlattenBinaryTreeToLinkedList {
    public void flatten(TreeNode root) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode result = root;
        
        while(result != null || !stack.isEmpty()){
        	//Go down through the left, when right is not null, push right to stack.
            if(result.right != null){
                stack.push(result.right);
            }
 
            if(result.left != null){
                result.right = result.left;
                result.left = null;
            }else if(!stack.empty()){
                TreeNode temp = stack.pop();
                result.right=temp;
            }
 
            result = result.right;
        }
    }
}
