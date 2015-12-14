package org.hanjia.leetcode.string;

/**
 * 
 * Given two binary strings, return their sum (also a binary string).
 * 
 * For example,
 * a = "11"
 * b = "1"
 * Return "100".
 * 
 * 
 * @author hanjia
 *
 */
public class Problem67_AddBinary {
    public String addBinary(String a, String b) {
        if(a.length() < 1 && b.length() < 1){
            return null;
        }else if(a.length() < 1){
            return b;
        }else if(b.length() < 1){
            return a;
        }else{
           int p1 = a.length() - 1;
           int p2 = b.length() - 1;
           String str = "";
           int carryon = 0;
           
           while(p1 >= 0 && p2 >= 0){
               int result = (a.charAt(p1) - '0') + (b.charAt(p2) - '0') + carryon;
               carryon = result / 2;
               str = result % 2 + str;
               p1--;
               p2--;
           }
           
           while(p1 >= 0){
               int result = (a.charAt(p1) - '0') + carryon;
               carryon = result / 2;
               str = result % 2 + str;
               p1--;
           }
           
           while(p2 >= 0){
               int result = (b.charAt(p2) - '0') + carryon;
               carryon = result / 2;
               str = result % 2 + str;
               p2--;
           }
           
           if(carryon > 0)
               str = carryon + str;
            
           return str;
        }
    }
}
