package org.hanjia.leetcode.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 
 * Given a binary tree, return the preorder traversal of its nodes' values.
 * 
 * For example:
 * Given binary tree {1,#,2,3},
	   1
	    \
	     2
	    /
	   3
 * return [1,2,3].
 * 
 * Note: Recursive solution is trivial, could you do it iteratively?
 * 
 * @author hanjia
 *
 */
public class Problem144_BinaryTreePreorderTraversal {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();     
        if(root == null)
            return result;
        
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode current = stack.pop();
            result.add(current.val);
            
            if(current.right != null){
                stack.push(current.right);
            }
            if(current.left != null){
                stack.push(current.left);
            }
        }
        return result;
    }
    
    public List<Integer> preorderTraversal2(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();     
        if(root == null)
            return result;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        while (true) {
        	while (root != null) {
        		result.add(root.val);
        		stack.push(root);
        		root = root.left;
        	}
        	
        	if (stack.isEmpty())
        		break;
        	
        	root = stack.pop();
        	root = root.right;
        }
        
        return result;
    }
    
    public static void main(String[] args) {
    	TreeNode root = new TreeNode(1);
    	root.left = new TreeNode(2);
    	root.right = new TreeNode(3);
    	root.left.left = new TreeNode(4);
    	root.left.right = new TreeNode(5);
    	root.right.left = new TreeNode(6);
    	root.right.right = new TreeNode(7);  
    	
    	Problem144_BinaryTreePreorderTraversal preorder = new Problem144_BinaryTreePreorderTraversal();
    	System.out.println(preorder.preorderTraversal(root));
    	System.out.println(preorder.preorderTraversal2(root));
    }
}
