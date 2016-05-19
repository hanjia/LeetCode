package org.hanjia.leetcode.string;

import java.util.ArrayList;
import java.util.List;

/**
 * Input:Digit string "23"
 * Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 * 
 * 
 * @author hanjia
 *
 */
public class Problem17_LetterCombinationsOfAPhoneNumber {

	final String[] letters = new String[]{"", "", "ABC", "DEF", "GHI", "JKL", "MNO", "PQRS", "TUV", "WXYZ"};
	
    public List<String> letterCombinations(String digits) {
        List<String> results = new ArrayList<String>();
        StringBuilder stringBuilder = new StringBuilder();
        // Backtracking through recursion
        backtrack(digits, 0, stringBuilder, results);
        return results;
    }
    
    public void backtrack(String digits, int index, StringBuilder stringBuilder, List<String> results){
    	if (digits.length() == index) {
    		if(stringBuilder.length() != 0)
    			results.add(stringBuilder.toString());
            return;
        }
    	
        String letter = letters[digits.charAt(index) - '0'];
        for (int i = 0; i < letter.length(); i++) {
        	stringBuilder.append(letter.charAt(i));
        	backtrack(digits, index + 1, stringBuilder, results);
            stringBuilder.deleteCharAt(stringBuilder.length() - 1); // Remove one possible solution to process the next
        }
    }
    
	public static void main(String[] args){
		Problem17_LetterCombinationsOfAPhoneNumber phoneNumber = new Problem17_LetterCombinationsOfAPhoneNumber();
		String digits = "38";
		System.out.println(phoneNumber.letterCombinations(digits));
	}
}
