package org.hanjia.leetcode.string;


/**
 * 
 * Given a string s consists of upper/lower-case alphabets and empty space characters ' ', return the length of last word in the string.
 * If the last word does not exist, return 0.
 * 
 * Note: A word is defined as a character sequence consists of non-space characters only.
 * 
 * For example, 
 * Given s = "Hello World",
 * return 5.
 * 
 * @author hanjia
 *
 */
public class Problem58_LengthOfLastWord {
    public int lengthOfLastWord(String s) {
        if(s == null || s.length() == 0)
            return 0;
        
        int length = 0;
        boolean flag = false; // To check whether the string ends with a space
		for (int i = s.length() - 1; i >= 0; i--) {
			char c = s.charAt(i);
			if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z')) {
				flag = true;
				length++;
			} else {
				if (flag)
					return length;
			}
		}
        return length;
    }
}
