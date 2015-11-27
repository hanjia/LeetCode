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
        
        while(true){
        	while(current != null){
        		stack.push(current);
        		current = current.left;
        	}
        	
        	if(stack.isEmpty()){
        		break;
        	}
        	
        	current = stack.pop();
        	result.add(current.val);
        	current = current.right;
        }
        
        return result;
    }
    
    public static void main(String[] args){
    	
    }
}
