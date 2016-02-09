package org.hanjia.leetcode.string;

/**
 * 
 * Given two strings S and T, determine if they are both one edit distance apart.
 * 
 * 
 * @author hanjia
 *
 */
public class Problem161_OneEditDistance {
    public boolean isOneEditDistance(String s, String t) {
        int m = s.length(), n = t.length();
        if(m == n) return isOneModified(s, t);
        if(m - n == 1) return isOneDeleted(s, t);
        if(n - m == 1) return isOneDeleted(t, s);
        return false;
    }
    
    private boolean isOneModified(String s, String t){
        boolean modified = false;
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) != t.charAt(i)){
                if(modified) return false;
                modified = true;
            }
        }
        return modified;
    }
    
    public boolean isOneDeleted(String longer, String shorter){
        for(int i = 0; i < shorter.length(); i++){
            if(longer.charAt(i) != shorter.charAt(i)){
                return longer.substring(i + 1).equals(shorter.substring(i));
            }
        }
        return true;
    }
}
