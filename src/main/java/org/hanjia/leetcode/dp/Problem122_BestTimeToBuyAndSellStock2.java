package org.hanjia.leetcode.dp;

/**
 * 
 * Say you have an array for which the ith element is the price of a given stock on day i.
 * Design an algorithm to find the maximum profit. 
 * You may complete as many transactions as you like (ie, buy one and sell one share of the stock multiple times). 
 * However, you may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
 * 
 * @author hanjia
 *
 */
public class Problem122_BestTimeToBuyAndSellStock2 {
	
	public int maxProfit(int[] prices) {
		if (prices.length < 2) {
			return 0;
		}
	    int sum = 0;
	    for (int i = 1; i < prices.length; i++) {
	        if (prices[i] - prices[i-1] > 0) {
	            sum += (prices[i] - prices[i-1]);
	        }
	    }
	    return sum;
    } 
    
    public static void main(String[] args) {
    	Problem122_BestTimeToBuyAndSellStock2 stock = new Problem122_BestTimeToBuyAndSellStock2();
    	int[] prices1 = {7, 1, 5, 3, 6, 4};
    	System.out.println(stock.maxProfit(prices1));
    	int[] prices2 = {7, 6, 4, 3, 1};
    	System.out.println(stock.maxProfit(prices2));
    }
}
