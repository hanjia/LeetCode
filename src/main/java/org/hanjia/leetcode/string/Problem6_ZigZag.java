package org.hanjia.leetcode.string;


/**
 * 
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: 
 * (you may want to display this pattern in a fixed font for better legibility)
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * 
 * And then read line by line: "PAHNAPLSIIGYIR"
 * Write the code that will take a string and make this conversion given a number of rows:
 * 
 * string convert(string text, int nRows);
 * convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR".
 * 
 * A   G   M   S
 * B  FH  LN  R
 * C E I K O Q
 * D   J   P
 * 
 * @author hanjia
 *
 */
public class Problem6_ZigZag {

	public static void main(String[] args){
		String line = "abcdefghijklmnopqrs";
		int nRows = 4;
		System.out.println(convert(line,nRows));
	}
	
    public static String convert(String s, int nRows) {
    	
    	if(s == null || s.length() == 0 || nRows <= 0)  
    		return ""; 
    	
    	if(nRows < 2){
    		return s;
    	}
    	
    	int zigZagSize = 2 * nRows - 2;    	
    	
    	StringBuffer result = new StringBuffer(); 
    	for(int i = 0; i < nRows; i++){
    		for(int j = i ; j < s.length(); j+= zigZagSize){
    			result.append(s.charAt(j));
    			
    			if(i != 0 && i != nRows - 1){//except the first row and the last row
    				int temp = j + zigZagSize - 2 * i;
    				if(temp < s.length())
    					result.append(s.charAt(temp));
    			}
    			 			
    		}
    				
    	}
    	
        return result.toString();
    }
    
}
