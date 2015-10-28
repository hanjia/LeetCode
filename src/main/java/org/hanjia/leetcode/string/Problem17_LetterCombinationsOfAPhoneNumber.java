package org.hanjia.leetcode.string;

import java.util.ArrayList;
import java.util.List;

/**
 * Input:Digit string "23"
 * Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 * @author hajia
 *
 *
 * Backtracking
 */
public class Problem17_LetterCombinationsOfAPhoneNumber {

	
	public static void main(String[] args){
		String digits = "31";
		System.out.println(letterCombinations(digits));
	}
	
    public static List<String> letterCombinations(String digits) {
    	String[] letters = new String[]{"", "", "ABC", "DEF", "GHI", "JKL", "MNO", "PQRS", "TUV", "WXYZ"};
        List<String> results = new ArrayList<String>();
        StringBuilder stringBuilder = new StringBuilder();
        backtrack(digits, 0, letters, stringBuilder, results);
        return results;
    }
    
    public static void backtrack(String digits, int number, String[] letters, StringBuilder stringBuilder, List<String> results){
    	if (digits.length() == number) {
    		if(stringBuilder.length() != 0)
    			results.add(stringBuilder.toString());
            return;
        }
        String letter = letters[digits.charAt(number) - '0'];
        for (int i = 0; i < letter.length(); i++) {
        	stringBuilder.append(letter.charAt(i));
        	backtrack(digits, number + 1, letters, stringBuilder, results);
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        }
    }
}
