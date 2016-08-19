package org.hanjia.leetcode.tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * 
 * Given a non-empty array of integers, return the k most frequent elements.
 * 
 * For example,
 * Given [1,1,1,2,2,3] and k = 2, return [1,2].
 * 
 * Note: 
 * You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
 * Your algorithm's time complexity must be better than O(n log n), where n is the array's size.
 * 
 * @author hanjia
 *
 */
public class Problem347_TopKFrequentElements {
    public List<Integer> topKFrequent(int[] nums, int k) {
		// count the frequency for each element
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int num : nums) {
			if (map.containsKey(num)) {
				map.put(num, map.get(num) + 1);
			} else {
				map.put(num, 1);
			}
		}

		// create a min heap (Key: use MIN heap)
		PriorityQueue<Pair> queue = new PriorityQueue<Pair>(nums.length,
				new Comparator<Pair>() {
					public int compare(Pair a, Pair b) {
						if(a.count > b.count)
							return 1;
						else if (a.count < b.count)
							return -1;
						else
							return 0;
					}
				});

		// maintain a heap of size k.
		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			Pair p = new Pair(entry.getKey(), entry.getValue());
			queue.offer(p);
			if (queue.size() > k) {
				queue.poll();
			}
		}

		// get all elements from the heap
		List<Integer> results = new ArrayList<Integer>();
		while (queue.size() > 0) {
			results.add(queue.poll().number);
		}

		// reverse the order
		Collections.reverse(results);
		return results;
    }
    
    public static void main(String[] args) {
    	int[] nums = {5,2,3,4,7,8,9,1,6,2,2,2,3,3,5,7,8,2,3};
    	Problem347_TopKFrequentElements topK = new Problem347_TopKFrequentElements();
    	List<Integer> results = topK.topKFrequent(nums, 3);
    	System.out.println(results);
    }
}

class Pair{
    int number;
    int count;
    public Pair(int number, int count){
        this.number = number;
        this.count = count;
    }
}
