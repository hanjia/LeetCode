package org.hanjia.leetcode.dp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 
 * Given a string s and a dictionary of words dict, add spaces in s to construct a sentence where each word is a valid dictionary word.
 * 
 * Return all such possible sentences.
 * 
 * For example, given
 * s = "catsanddog",
 * dict = ["cat", "cats", "and", "sand", "dog"].
 * 
 * A solution is ["cats and dog", "cat sand dog"].
 * 
 * 
 * @author hanjia
 *
 */
public class Problem140_WordBreak2 {
	// DP Solution
	public List<String> wordBreakDPSolution(String s, Set<String> wordDict) {
	    ArrayList<String> [] pos = new ArrayList[s.length()+1];
	    pos[0]=new ArrayList<String>();
	 
	    for(int i=0; i<s.length(); i++){
	        if(pos[i]!=null){
	            for(int j=i+1; j<=s.length(); j++){
	                String sub = s.substring(i,j);
	                if(wordDict.contains(sub)){
	                    if(pos[j]==null){
	                        ArrayList<String> list = new ArrayList<String>();
	                        list.add(sub);
	                        pos[j]=list;
	                    }else{
	                        pos[j].add(sub);
	                    }
	 
	                }
	            }
	        }
	    }
	 
	    if(pos[s.length()]==null){
	        return new ArrayList<String>();
	    }else{
	        ArrayList<String> result = new ArrayList<String>();
	        dfs(pos, result, "", s.length());
	        return result;
	    }
	}
	 
	public void dfs(ArrayList<String> [] pos, ArrayList<String> result, String curr, int i){
	    if(i==0){
	        result.add(curr.trim());
	        return;
	    }
	 
	    for(String s: pos[i]){
	        String combined = s + " "+ curr;
	        dfs(pos, result, combined, i-s.length());
	    }
	}
	
	
	// Recursive
	public List<String> wordBreak(String s, Set<String> dict) {
		Map<String, List<String>> map = new HashMap<String, List<String>>();
		return wordBreakHelper(s, dict, map);
	}

    public List<String> wordBreakHelper(String s, Set<String> dict, Map<String, List<String>> memo){
		if (memo.containsKey(s)) {
			return memo.get(s);
		}
		List<String> result = new ArrayList<String>();
		int n = s.length();
		if (n <= 0) {
			return result;
		}
		
		for (int length = 1; length <= n; ++length) {
			String subfix = s.substring(0, length);
			if (dict.contains(subfix)) {
				if (length == n) {
					result.add(subfix);
				} else {
					String prefix = s.substring(length);
					List<String> tmp = wordBreakHelper(prefix, dict, memo);
					for (String item : tmp) {
						item = subfix + " " + item;
						result.add(item);
					}
				}
			}
		}
		memo.put(s, result);
		return result;
    }
    
    public static void main(String[] args) {
    	// TODO add tests
    }
}
