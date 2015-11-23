package org.hanjia.leetcode.string;


/**
 * 
 * Given two strings s and t, write a function to determine if t is an anagram of s.
 * 
 * For example,
 * s = "anagram", t = "nagaram", return true.
 * s = "rat", t = "car", return false.
 * 
 * Note: You may assume the string contains only lowercase alphabets.
 * 
 * Follow up: What if the inputs contain unicode characters? How would you adapt your solution to such case?
 * 
 * @author hanjia
 *
 */
public class Problem242_ValidAnagram {
    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        int[] counter = new int[26];
        for (int i = 0; i < s.length(); i++) {
            counter[s.charAt(i) - 'a']++;
            counter[t.charAt(i) - 'a']--;
        }
        for (int count : counter) {
            if (count != 0) return false;
        }
        return true;
    }
    
    public static void main(String[] args){
    	String s = "anagram";
    	String t = "nagaram";
    	System.out.println(isAnagram(s,t));
    	String h = "hello";
    	String j = "java";
    	System.out.println(isAnagram(h,j));
    }
}
