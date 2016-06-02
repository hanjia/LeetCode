package org.hanjia.leetcode.tree;

import java.util.Stack;

import org.hanjia.leetcode.linkedlist.ListNode;

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
    
    public ListNode flattenToLinkedList(TreeNode root) {
    	if (root == null)
    		return null;
    	Stack<TreeNode> stack = new Stack<TreeNode>();
    	ListNode dummy = new ListNode(-1);
    	ListNode current = dummy;
    	stack.push(root);
    	
    	while (!stack.isEmpty()) {
    		TreeNode top = stack.pop();
    		current.next = new ListNode(top.val);
    		current = current.next;
    		if(top.right != null)
    			stack.push(top.right);
    		if(top.left != null)
    			stack.push(top.left);
    	}
    	
    	return dummy.next;
    }
    
    public static void main(String[] args){
    	TreeNode root = new TreeNode(1);
    	root.left = new TreeNode(2);
    	root.right = new TreeNode(3);
    	root.left.left = new TreeNode(4);
    	root.left.right = new TreeNode(5);
    	root.right.left = new TreeNode(6);
    	root.right.right = new TreeNode(7);  
    	Problem114_FlattenBinaryTreeToLinkedList flatten = new Problem114_FlattenBinaryTreeToLinkedList();
    	ListNode node = flatten.flattenToLinkedList(root);
    	while (node != null) {
    		System.out.println(node.val);
    		node = node.next;
    	}
    }
}
