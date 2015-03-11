package org.hanjia.leetcode.string;


/**
 * 
Problem 6: 
The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: 
(you may want to display this pattern in a fixed font for better legibility)
P   A   H   N
A P L S I I G
Y   I   R
And then read line by line: "PAHNAPLSIIGYIR"
Write the code that will take a string and make this conversion given a number of rows:

string convert(string text, int nRows);
convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR".
 * 
 * 
 * A   G   M   S
 * B  FH  LN  R
 * C E I K O Q
 * D   J   P
 * 
 * Algorithm:
 * ZigZag Size (A -> F will be one ZigZag) will be (2 * nRows - 2)
 * First and last row elements will be easy: Iterate all the elements and print the elements at (rowNumber + zigzagSize)
 * Rows between first and last rows: Besides elements at (rowNumber + zigzagSize), 
 * we also need to fetch elements at rowNumber + zigzagSize * 2 - rowNumber * 2
 * 
 * @author hajia
 *
 */
public class Problem6_ZigZag {

	
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
