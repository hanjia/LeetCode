package org.hanjia.leetcode.string;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * Given a string containing only digits, restore it by returning all possible valid IP address combinations.
 * 
 * For example:
 * Given "25525511135",
 * 
 * return ["255.255.11.135", "255.255.111.35"]. (Order does not matter)
 * 
 * @author hanjia
 *
 */
public class Problem93_RestoreIPAddresses {
	public List<String> restoreIpAddresses(String s) {
	    List<List<String>> result = new ArrayList<List<String>>();
	    List<String> addresses = new ArrayList<String>();
	    
	    backtrack(result, addresses, s, 0);
	 
	    // To construct ip addresses from a list of subnet addresses 
	    List<String> finalResult = new ArrayList<String>();	 
		for (List<String> l : result) {
			StringBuilder sb = new StringBuilder();
			for (String str : l) {
				sb.append(str + ".");
			}
			sb.setLength(sb.length() - 1);
			finalResult.add(sb.toString());
		}
	 
	    return finalResult;
	}
	 
	public void backtrack(List<List<String>> result, List<String> addresses, String s, int index){
		// if already get 4 numbers, but s is not fully consumed, return
		if (addresses.size() >= 4 && index != s.length())
			return;

		// make sure addresses's size + remaining string's length >=4
		if ((addresses.size() + (s.length() - index + 1)) < 4)
			return;

		// addresses's size is 4 and no remaining part that is not consumed.
		if (addresses.size() == 4 && index == s.length()) {
			List<String> temp = new ArrayList<String>(addresses);
			result.add(temp);
			return;
		}

		for (int i = 1; i <= 3; i++) {
			if (index + i > s.length())
				break;

			// handle cases like 001. i.e., if length > 1 and first char is 0, ignore the case.
			if (i > 1 && s.charAt(index) == '0') 
				break;

			String sub = s.substring(index, index + i);
			if (Integer.valueOf(sub) > 255)
				break;

			addresses.add(sub);
			backtrack(result, addresses, s, index + i);
			addresses.remove(addresses.size() - 1);
		}
	}
}
