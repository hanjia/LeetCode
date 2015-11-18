package org.hanjia.leetcode.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * 
 * Given an array of strings, group anagrams together.
 * 
 * For example, given: ["eat", "tea", "tan", "ate", "nat", "bat"], 
 * Return:[
 * ["ate", "eat","tea"],
 * ["nat","tan"],
 * ["bat"]
 * ]
 * 
 * Note: For the return value, each inner list's elements must follow the lexicographic order.
 * All inputs will be in lower-case.
 * 
 * @author hanjia
 *
 */
public class Problem49_GroupAnagrams {
    public static List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<List<String>>();
    	if(strs == null || strs.length == 0)
    		return result;
        
    	Map<String, List<Integer>> map = new HashMap<String, List<Integer>>();
        for(int i = 0; i < strs.length; i++){
        	char[] chars = strs[i].toCharArray();
        	Arrays.sort(chars);
        	String sortedString = String.valueOf(chars);
        	if(map.containsKey(sortedString)){
        		map.get(sortedString).add(i);
        	}else{
        		List<Integer> list = new ArrayList<Integer>();
                list.add(i);
        		map.put(sortedString, list);
        	}
        	
        }

        for(List<Integer> stringIndexes : map.values()){
        	List<String> stringGroup = new ArrayList<String>();
        	for(int index: stringIndexes){
        		stringGroup.add(strs[index]);
        	}
        	Collections.sort(stringGroup);
        	result.add(stringGroup);
        }
        return result;
    }
}
