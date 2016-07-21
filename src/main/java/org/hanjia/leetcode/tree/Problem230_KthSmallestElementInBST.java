package org.hanjia.leetcode.tree;

import java.util.Stack;

public class Problem230_KthSmallestElementInBST {
	// In-order Traversal
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        while(true) {
            while(root != null){
				stack.push(root);
				root = root.left;
			}
			if(stack.isEmpty())
			    break;
			root = stack.pop();
			k--;
			if(k == 0)
			   return root.val;
			root = root.right;
        }
        return -1;
    }
    
    public int kthLargest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        while(true) {
            while(root != null){
				stack.push(root);
				root = root.right;
			}
			if(stack.isEmpty())
			    break;
			root = stack.pop();
			k--;
			if(k == 0)
			   return root.val;
			root = root.left;
        }
        return -1;
    }
    
	public static void main(String[] args) {
		TreeNode root = new TreeNode(5);
		root.left = new TreeNode(3);
		root.left.left = new TreeNode(2);
		root.left.right = new TreeNode(4);
		root.right = new TreeNode(7);
		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(8);
		Problem230_KthSmallestElementInBST kth = new Problem230_KthSmallestElementInBST();
		int result = kth.kthSmallest(root, 2);
		System.out.println(result);		
		result = kth.kthLargest(root, 2);
		System.out.println(result);
	}
}
