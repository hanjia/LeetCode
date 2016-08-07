package org.hanjia.leetcode.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Problem145_BinaryTreePostOrderTraversal {
	public List<Integer> postorderTraversal(TreeNode root) {
	    List<Integer> result = new ArrayList<Integer>();
	    if (root == null) {
	        return result;
	    }
	    
	    Stack<TreeNode> stack = new Stack<TreeNode>();
	    TreeNode previous = null; // previously traversed node	    
	    stack.push(root);
	    while (!stack.empty()) {
	    	TreeNode current = stack.peek();
	        if (previous == null || previous.left == current || previous.right == current) { // traverse down the tree
	            if (current.left != null) {
	                stack.push(current.left);
	            } else if (current.right != null) {
	                stack.push(current.right);
	            } else {
	            	stack.pop();
	            	result.add(current.val);
	            }
	        } 
	        
	        if (current.left == previous) { // traverse up the tree from the left
	            if (current.right != null) {
	                stack.push(current.right);
	            }
	        } 
	        
	        if (current.right == previous) { // traverse up the tree from the right
	            stack.pop();
	            result.add(current.val);
	        }
	        previous = current;
	    }
	    return result;
	}
	
	public List<Integer> postorderTraversalIterative(TreeNode root){
	    List<Integer> result = new ArrayList<Integer>();
		if (root == null) {
			return result;
		}
		
		Stack<TreeNode> stack = new Stack<TreeNode>();
		TreeNode previous = null;
		while (root != null || !stack.isEmpty()) {
			if (root != null) {
				stack.push(root);
				root = root.left;
			} else {
				TreeNode current = stack.peek();
				if (current.right != null && current.right != previous) {
					root = current.right;
				} else {
					current = stack.pop();
					result.add(current.val);
					previous = current;
				}
			}
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
    	
    	Problem145_BinaryTreePostOrderTraversal postorder = new Problem145_BinaryTreePostOrderTraversal();
    	System.out.println(postorder.postorderTraversal(root));
    	System.out.println(postorder.postorderTraversalIterative(root));
    }
}
