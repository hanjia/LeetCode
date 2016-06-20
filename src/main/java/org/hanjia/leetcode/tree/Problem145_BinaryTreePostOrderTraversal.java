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
	
	// TODO Fix this method
	public List<Integer> postorderTraversal2(TreeNode root) {
	    List<Integer> result = new ArrayList<Integer>();
		if (root == null)
			return result;
		Stack<TreeNode> stack = new Stack<TreeNode>();
		while (true) {
			if (root != null) {
				stack.push(root);
				root = root.left;
			} else {
				if (stack.isEmpty()) {
					break;
				}
				if (stack.peek().right == null) {
					root = stack.pop();
					result.add(root.val);
	
					// If the current node is the same with right child of the top node in stack,
					// that means we are done with both left and right subtree and then we should go to root
					if (root == stack.peek().right) {
						root = stack.pop();
						result.add(root.val);
					}
				}
	
				if (!stack.isEmpty()) {
					root = stack.peek().right;
				} else {
					root = null;
				}
			}
		}
		return result;
	} 
	
	public static void postorderTraversalIterative(TreeNode root){
		if(root == null) return;
		Stack<TreeNode> s = new Stack<TreeNode>();
		while(true){
			if(root != null){ //To go to the far left node and store all the previous nodes
				s.push(root);
				root = root.left;
			}else{
				if(s.isEmpty())	break;
				else{
					if(s.peek().right == null){
						root = s.pop();
						System.out.print(root.val + ",");
						if(root == s.peek().right){
							root = s.pop();
							System.out.print(root.val + ",");
						}
					}
				}	
				
				if (!s.isEmpty()) {
					root = s.peek().right;
				} else {
					root = null;
				}			
			}
		}
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
    	//System.out.println(postorder.postorderTraversal2(root));
    }
}
