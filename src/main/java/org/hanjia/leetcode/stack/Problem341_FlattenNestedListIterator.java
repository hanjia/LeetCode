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
		Stack<NestedInteger> stack = new Stack<>();

		public NestedIterator(List<NestedInteger> nestedList) {
			if (nestedList == null || nestedList.size() == 0)
				return;

			for (int i = nestedList.size() - 1; i >= 0; i--) {
				stack.push(nestedList.get(i));
			}
		}

		@Override
		public Integer next() {
			return stack.pop().getInteger();
		}

		@Override
		public boolean hasNext() {
			while (!stack.isEmpty()) {
				NestedInteger top = stack.peek();
				if (top.isInteger()) {
					return true;
				} else {
					stack.pop();
					for (int i = top.getList().size() - 1; i >= 0; i--) {
						stack.push(top.getList().get(i));
					}
				}
			}
			return false;
		}
	}
	
	public interface NestedInteger {
		public boolean isInteger();
		public Integer getInteger();
		public List<NestedInteger> getList();
	}
}
