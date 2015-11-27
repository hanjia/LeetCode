package org.hanjia.leetcode.tree;

import java.util.PriorityQueue;
import java.util.Queue;

public class Problem98_ValidateBinarySearchTree {
    public static boolean isValidBST(TreeNode root) {
        if(root == null)
            return true;
 
        Queue<TreeNode> queue = new PriorityQueue<TreeNode>();
        queue.offer(root);
        while(!queue.isEmpty()){
        	TreeNode b = queue.poll();
            if(b.left != null && b.right != null && (b.val <= b.left.val || b.val >= b.right.val)){
                return false;
            }
            if(b.left != null){
                queue.offer(b.left);
            }
            if(b.right != null){
                queue.offer(b.right);
            }
        }
        return true;
    }
    
    public static boolean isValidBST(TreeNode p, double min, double max){
        if(p==null) 
            return true;
     
        if(p.val <= min || p.val >= max)
            return false;
     
        return isValidBST(p.left, min, p.val) && isValidBST(p.right, p.val, max);
    }
}
