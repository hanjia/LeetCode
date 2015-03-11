package org.hanjia.leetcode.linkedlist;

/**
 * 
You are given two linked lists representing two non-negative numbers. 
The digits are stored in reverse order and each of their nodes contain a single digit. 
Add the two numbers and return it as a linked list.

Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8
 *
 *
 *Algorithm:
 *
 * @author hanjia
 *
 */
public class Problem2_AddTwoNumber {
	
	public static void main(String[] args){

		ListNode node1 = new ListNode(9);
		node1.next = new ListNode(8);
		node1.next.next = new ListNode(3);

		ListNode node2 = new ListNode(1);
		node2.next = new ListNode(9);
		node2.next.next = new ListNode(9);
		node2.next.next.next = new ListNode(9);
		node2.next.next.next.next = new ListNode(9);
		node2.next.next.next.next.next = new ListNode(9);
		node2.next.next.next.next.next.next = new ListNode(9);
		node2.next.next.next.next.next.next.next = new ListNode(9);
		node2.next.next.next.next.next.next.next.next = new ListNode(9);
		node2.next.next.next.next.next.next.next.next.next = new ListNode(9);
		
		//ListNode result = addTwoNumbersFirstSolution(node1,node2);
		ListNode result = addTwoNumbersBetterSolution(node1,node2,0);
		while(result != null){
			System.out.println("Result: " + result.val);
			result = result.next;
		}

	}
	
	
    public static ListNode addTwoNumbersFirstSolution(ListNode l1, ListNode l2) {
        ListNode currentNode1 = l1;
        ListNode currentNode2 = l2;
        ListNode resultNode = new ListNode(0);
        ListNode finalResult = resultNode;
        
        while(currentNode1 != null && currentNode2 != null){
        	int result =  resultNode.val + currentNode1.val + currentNode2.val;
        	if(result < 10){
        		resultNode.val = result;
        		if(currentNode1.next != null || currentNode2.next != null)resultNode.next = new ListNode(0);
        	}else{
        		resultNode.val = result - 10;
        		resultNode.next = new ListNode(1);        		
        	}      	
	        currentNode1 = currentNode1.next;
	        currentNode2 = currentNode2.next;
	        resultNode = resultNode.next;        	
        }        
    	
        while(currentNode1 != null){
        	int result = resultNode.val + currentNode1.val;
        	if(result < 10){
        		resultNode.val = result;
        		if(currentNode1.next != null) resultNode.next = new ListNode(0);
        	}else{
        		resultNode.val = result - 10;
        		resultNode.next = new ListNode(1);        		
        	}        		
        	currentNode1 = currentNode1.next;
        	resultNode = resultNode.next;        	
        }
        
        while(currentNode2 != null){
        	int result = currentNode2.val + resultNode.val;
        	if(result < 10){
        		resultNode.val = result;
            	if(currentNode2.next != null) resultNode.next = new ListNode(0);
        	}else{
        		resultNode.val = result - 10;
        		resultNode.next = new ListNode(1);        		
        	} 
        	currentNode2 = currentNode2.next;
        	resultNode = resultNode.next;
        }
        
    	return finalResult;
    }
    
    public static ListNode addTwoNumbersSecondSolution(ListNode l1, ListNode l2){
        ListNode resultNode = new ListNode(0);
        ListNode finalResult = resultNode;
        Long sum1 = 0L; 
        Long times1 = 1L;
        while(l1 != null){
        	sum1 = sum1 + l1.val * times1;
        	l1 = l1.next;
        	times1 = times1 * 10;
        }
        Long sum2 = 0L;
        Long times2 = 1L;
        while(l2 != null){
        	sum2 = sum2 + l2.val * times2;
        	l2 = l2.next;
        	times2 = times2 * 10;
        }
        Long sum = sum1 + sum2;
        while(sum > 0){
        	resultNode.val = (int)(sum % 10);
        	sum = sum / 10;
        	if(sum > 0) resultNode.next = new ListNode(0);
        	resultNode = resultNode.next;
        }
        return finalResult;
    }
    
    public static ListNode addTwoNumbersBetterSolution(ListNode l1, ListNode l2, int carry){

	    ListNode result = new ListNode(carry);
	
    	if(l1 == null && l2 == null){
    		return result;
    	}

    	int value = carry;
    	
    	if(l1 != null){
    		value += l1.val;
    	}
    	if(l2 != null){
    		value += l2.val;
    	}
    	result.val = value % 10;
    	carry = (value >= 10) ? 1 : 0;
    	
    	if(l1 == null){
    	    if(!(l2.next == null && carry == 0)){
        	    result.next = addTwoNumbersBetterSolution(null, l2.next, carry);
    	    }
    	}else if(l2 == null){
    	    if(!(l1.next == null && carry == 0)){
        	    result.next = addTwoNumbersBetterSolution(l1.next, null, carry);
    	    }
    	}
    	else{
        	if(!(l1.next == null && l2.next == null && carry == 0)){
        	    result.next = addTwoNumbersBetterSolution(l1.next,l2.next, carry);
        	}
    	}
    	return result;
	
}
}

/**
 * Definition for singly-linked list.
 * 
 */
   	class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
      }
  }
 