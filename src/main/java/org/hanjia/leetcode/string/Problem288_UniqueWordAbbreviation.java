package org.hanjia.leetcode.string;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 
 * An abbreviation of a word follows the form <first letter><number><last letter>. Below are some examples of word abbreviations:
 * 
 * a) it                      --> it    (no abbreviation)
 * 
 *      1
 * b) d|o|g                   --> d1g
 * 
 *               1    1  1
 *      1---5----0----5--8
 * c) i|nternationalizatio|n  --> i18n
 * 
 *               1
 *      1---5----0
 * d) l|ocalizatio|n          --> l10n
 * 
 * Assume you have a dictionary and given a word, find whether its abbreviation is unique in the dictionary. 
 * A word's abbreviation is unique if no other word from the dictionary has the same abbreviation.
 * 
 * Example: 
 * Given dictionary = [ "deer", "door", "cake", "card" ]
 * 
 * isUnique("dear") -> false
 * isUnique("cart") -> true
 * isUnique("cane") -> false
 * isUnique("make") -> true
 * 
 * 
 * @author hanjia
 *
 */
public class Problem288_UniqueWordAbbreviation {

	
	// Brute force – O(n) time
	// A word's abbreviation is unique when all the following conditions are met:
	// - They are not the same word.
	// - They both have equal lengths.
	// - They both share the same first and last letter.
	private String[] dictionary;

	public void ValidWordAbbrBruteForce(String[] dictionary) {
	    this.dictionary = dictionary;
	}

	public boolean isUniqueBruteForce(String word) {
	    int n = word.length();
	    for (String s : dictionary) {
	        if (word.equals(s)) {
	            continue;
	        }
	        int m = s.length();
	        if (m == n && s.charAt(0) == word.charAt(0)
	                && s.charAt(m - 1) == word.charAt(n - 1)) {
	            return false;
	        }
	    }
	    return true;
	}
	
	// Hash table – O(1) time
	// We should pre-process the dictionary to speed it up.
	// The logic in isUnique(word) is tricky. You need to consider the following cases:
	// - Does the word's abbreviation exists in the dictionary? If not, then it must be unique.
	// - If above is yes, then it can only be unique if the grouping of the abbreviation contains no other words except word.
	private final Map<String, Set<String>> abbrDict = new HashMap<String, Set<String>>();

	public void ValidWordAbbrHashTable(String[] dictionary) {
	    for (String s : dictionary) {
	        String abbr = toAbbr(s);
	        Set<String> words = abbrDict.containsKey(abbr) ? abbrDict.get(abbr) : new HashSet<String>();
	        words.add(s);
	        abbrDict.put(abbr, words);
	    }
	}

	public boolean isUnique(String word) {
	    String abbr = toAbbr(word);
	    Set<String> words = abbrDict.get(abbr);
	    return words == null || (words.size() == 1 && words.contains(word));
	}

	private String toAbbr(String s) {
	    int n = s.length();
	    if (n <= 2) {
	        return s;
	    }
	    return "" + s.charAt(0) + String.valueOf(n - 2) + s.charAt(n - 1);
	}
}
