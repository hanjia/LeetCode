package org.hanjia.leetcode.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;


/**
 * 
 * Given a binary tree, return the inorder traversal of its nodes' values.
 * 
 * For example:
 * Given binary tree {1,#,2,3},
   1
    \
     2
    /
   3
 * return [1,3,2].
 * 
 * Note: Recursive solution is trivial, could you do it iteratively?
 * 
 * @author hanjia
 *
 */
public class Problem94_BinaryTreeInOrderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode current = root;
        
        while(!stack.isEmpty() || current != null){
        	while(current != null){
        		stack.push(current);
        		current = current.left;
        	}        	
        	current = stack.pop();
        	result.add(current.val);
        	current = current.right;
        }
        
        return result;
    }
    
    public static void main(String[] args){
    	TreeNode root = new TreeNode(1);
    	root.left = new TreeNode(2);
    	root.right = new TreeNode(3);
    	root.left.left = new TreeNode(4);
    	root.left.right = new TreeNode(5);
    	root.right.left = new TreeNode(6);
    	root.right.right = new TreeNode(7);  
    	Problem94_BinaryTreeInOrderTraversal inorder = new Problem94_BinaryTreeInOrderTraversal();
    	System.out.println(inorder.inorderTraversal(root));
    }
}
