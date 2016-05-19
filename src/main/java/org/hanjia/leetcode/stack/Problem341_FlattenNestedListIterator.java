package org.hanjia.leetcode.stack;

import java.util.Iterator;
import java.util.List;
import java.util.Stack;

/**
 * 
 * Given a nested list of integers, implement an iterator to flatten it.
 * 
 * Each element is either an integer, or a list -- whose elements may also be integers or other lists.
 * 
 * Example 1:
 * Given the list [[1,1],2,[1,1]],
 * 
 * By calling next repeatedly until hasNext returns false, the order of elements returned by next should be: [1,1,2,1,1].
 * 
 * Example 2:
 * Given the list [1,[4,[6]]],
 * 
 * By calling next repeatedly until hasNext returns false, the order of elements returned by next should be: [1,4,6].
 * 
 * @author hanjia
 *
 */
public class Problem341_FlattenNestedListIterator {

	public class NestedIterator implements Iterator<Integer> {
		public Stack<NestedInteger> s = new Stack<NestedInteger>();
	    public NestedIterator(List<NestedInteger> nestedList) {
	        for (NestedInteger integer: nestedList) {
	            s.push(integer);
	        }
	    }

	    public Integer next() {
	        NestedInteger t = s.pop();
	        return t.getInteger();
	    }

	    public boolean hasNext() {
	        while (!s.empty()) {
	            NestedInteger t = s.pop(); 
	            if (t.isInteger()) 
	            	return true;
	            
	            s.pop();
	            for (NestedInteger integer: t.getList()) {
	                s.push(integer);
	            }
	        }
	        return false;
	    }

		public void remove() {
			
		}
	}
	
	public interface NestedInteger {
		public boolean isInteger();
		public Integer getInteger();
		public List<NestedInteger> getList();
	}
}
