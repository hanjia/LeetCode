package org.hanjia.leetcode.array;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * The gray code is a binary numeral system where two successive values differ in only one bit.
 * 
 * Given a non-negative integer n representing the total number of bits in the code, print the sequence of gray code. 
 * A gray code sequence must begin with 0.
 * 
 * For example, given n = 2, return [0,1,3,2]. Its gray code sequence is:

	00 - 0
	01 - 1
	11 - 3
	10 - 2
 * Note:
 * For a given n, a gray code sequence is not uniquely defined.
 * 
 * For example, [0,2,3,1] is also a valid gray code sequence according to the above definition.
 * 
 * For now, the judge is able to judge based on one instance of gray code sequence. Sorry about that.
 * 
 * 
 * @author hanjia
 *
 */
public class Problem89_GrayCode {
	public List<Integer> grayCode(int n) {  
		List<Integer> result = new ArrayList<Integer>();
		helper(n, result);
		return result;
	}
	
	public void helper(int n, List<Integer> result){ 
		if(n == 0) {  
			result.add(0); 
			return;
		}
		 
		helper(n-1, result);  
		int addNumber = 1 << (n-1);
		int size = result.size();
		
		for(int i = size - 1;i >= 0; i--) {  
			result.add(addNumber + result.get(i));  
		}  
	}
	
	public static void main(String[] args){
		Problem89_GrayCode grayCode = new Problem89_GrayCode();
		System.out.println(grayCode.grayCode(0));
	}
}
