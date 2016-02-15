package org.hanjia.leetcode.dpdq;

/**
 * 
 * Given two words word1 and word2, find the minimum number of steps required to convert word1 to word2. (each operation is counted as 1 step.)
 * 
 * You have the following 3 operations permitted on a word:
 * a) Insert a character
 * b) Delete a character
 * c) Replace a character
 * 
 * 
 * @author hanjia
 *
 */
public class Problem72_EditDistance {

    public int minDistance(String word1, String word2) {
    	if(word1 == null || word2 == null)
    		return 0;
    	
    	if(word1.equals("")){
    	    return word2.length();
    	}
    	
    	if(word2.equals("")){
    	    return word1.length();
    	}
    	
    	int[][] table = new int[word2.length() + 1][word1.length() + 1];
    	// To insert base cases
    	for(int i = 0; i <= word1.length(); i++){
    		table[0][i] = i;
    	}
    	for(int j = 0; j <= word2.length(); j++){
    		table[j][0] = j;
    	}
    	// To fill up the entire table
    	for(int i = 1; i <= word1.length(); i++){
    		for(int j = 1; j <= word2.length(); j++){
    			// Subproblems: E(i,j) = min{E(i - 1, j) + 1, E(i, j - 1) + 1, E(i - 1, j - 1) + diff(i, j)}
    			int min = Math.min(table[j][i-1], table[j-1][i]) + 1;
    			int previous = (word1.charAt(i-1) == word2.charAt(j-1)) ? table[j-1][i-1] : table[j-1][i-1] + 1;   				
    			table[j][i] = Math.min(min, previous);
    		}
    	}
        return table[word2.length()][word1.length()];
    }
	
	public static void main(String[] args){
		String word1 = "POLYNOMIAL";
		String word2 = "EXPONENTIAL";
		// The answer should be 6
		Problem72_EditDistance editDistance = new Problem72_EditDistance();
		System.out.println(editDistance.minDistance(word1, word2));
	}
}
