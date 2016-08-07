package org.hanjia.leetcode.dp;

/**
 * 
 * Say you have an array for which the ith element is the price of a given stock on day i. 
 * 
 * If you were only permitted to complete at most one transaction (ie, buy one and sell one share of the stock), design an algorithm to find the maximum profit.
 * 
 * Example 1:
 * Input: [7, 1, 5, 3, 6, 4]
 * Output: 5
 * 
 * max. difference = 6-1 = 5 (not 7-1 = 6, as selling price needs to be larger than buying price)
 * Example 2:
 * Input: [7, 6, 4, 3, 1]
 * Output: 0
 * 
 * In this case, no transaction is done, i.e. max profit = 0.
 * 
 * @author hanjia
 *
 */
public class Problem121_BestTimeToBuyAndSellStock {
	
    public int maxProfit(int[] prices) {
		if (prices.length < 2) {
			return 0;
		}
	    int minPrice = prices[0];
	    int maxProfit = prices[1] - prices[0];
	    for (int i = 2; i < prices.length; i++) {
	        minPrice = Math.min(minPrice, prices[i-1]);
	        maxProfit = Math.max(maxProfit, prices[i] - minPrice);
	    }
	    return (maxProfit > 0) ? maxProfit : 0;
    } 
    
    public static void main(String[] args) {
    	Problem121_BestTimeToBuyAndSellStock stock = new Problem121_BestTimeToBuyAndSellStock();
    	int[] prices1 = {7, 1, 5, 3, 6, 4};
    	System.out.println(stock.maxProfit(prices1));
    	int[] prices2 = {7, 6, 4, 3, 1};
    	System.out.println(stock.maxProfit(prices2));
    }
}
