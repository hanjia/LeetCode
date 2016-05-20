package org.hanjia.leetcode.string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 
 * You are given a string, s, and a list of words, words, that are all of the same length. 
 * Find all starting indices of substring(s) in s that is a concatenation of each word in words exactly once and without any intervening characters.
 * 
 * For example,
 * s: "barfoothefoobarman"
 * words: ["foo", "bar"]
 * 
 * You should return the indices: [0,9]. (order does not matter).
 * 
 * @author hanjia
 *
 */
public class Problem30_SubstringWithConcatenationOfAllWords {
	
	public static List<Integer> findSubstring(String s, String[] words) {
		List<Integer> result = new ArrayList<Integer>();
		if(s == null || s.length() == 0 || words == null || words.length == 0)  
	        return result;
		
        Map<String, Integer> map = new HashMap<String, Integer>(); // Create a map for word count
		for (String word : words) {
			if (map.containsKey(word))
				map.put(word, map.get(word) + 1);
			else
				map.put(word, 1);
		}
        
        int wordLength = words[0].toCharArray().length;
        for(int i = 0; i < wordLength; i++){
            Map<String, Integer> currentMap = new HashMap<String, Integer>();
            int start = i; // starting index
            int count = 0; // number of qualified words
            
            for (int j = i; j <= s.length() - wordLength; j += wordLength) {
            	String subString = s.substring(j, j + wordLength); // Every time we check a fixed length of substring
            	
            	if (map.containsKey(subString)) {
            		count++;
					if (currentMap.containsKey(subString)) {
						currentMap.put(subString, currentMap.get(subString) + 1);
					} else {
						currentMap.put(subString, 1);
					}
            		            		
					if (currentMap.get(subString) > map.get(subString)) {
						String temp = s.substring(start, start + wordLength);
						if (currentMap.containsKey(temp)) {
							currentMap.put(temp, currentMap.get(temp) - 1);
						}
						count--;
						start += wordLength;
					}
            		
            		if (count == words.length) { // find one result 
                        result.add(start);    
                        String temp = s.substring(start, start + wordLength); // shift right and update currentMap, count & starting index         
                        if (currentMap.containsKey(temp)) {
                        	currentMap.put(temp, currentMap.get(temp) - 1);
                        }
                        count--;
                        start += wordLength;
                    }           		
				} else {
					currentMap.clear();
					start = j + wordLength;
					count = 0;
				}
            }
        }
               
        return result;
    }
	
	public static void main(String[] args){
		String s = "cbarfoofoofoobarthefoobarfooman";
		String[] words = {"foo","bar"};
		System.out.println(findSubstring(s, words));
	}
}
