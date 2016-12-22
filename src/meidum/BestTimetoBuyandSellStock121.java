package meidum;

import utils.Log;

/**  
 * 121. Best Time to Buy and Sell Stock
Say you have an array for which the ith element is the price of a given stock on day i.
If you were only permitted to complete at most one transaction (ie, buy one and sell one share of the stock), 
design an algorithm to find the maximum profit.

Example 1:
Input: [7, 1, 5, 3, 6, 4]
Output: 5

max. difference = 6-1 = 5 (not 7-1 = 6, as selling price needs to be larger than buying price)
Example 2:
Input: [7, 6, 4, 3, 1]
Output: 0

In this case, no transaction is done, i.e. max profit = 0.  
 *  
 * @author 郑元浩 
 * @date 2016年12月24日
 */
public class BestTimetoBuyandSellStock121 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] prices = {7, 1, 5, 3, 6, 4};
		Log.log(maxProfit(prices));
		int[] prices1 = {7, 6, 4, 3, 1};
		Log.log(maxProfit(prices1));
		int[] prices2 = {7, 6, 8, 9, 10, 11, 5, 6, 8, 10, 3, 6, 9, 15, 1, 10, 15, 20};
		Log.log(maxProfit(prices2));
		int[] prices3 = {7, 6, 8, 9, 10, 11, 5, 6, 8, 10, 3, 6, 9, 15, 1, 10, 15, 20, 1, 60, 0, 5, 6, 1000};
		Log.log(maxProfit(prices3));
		int[] prices4 = {7, 6};
		Log.log(maxProfit(prices4));
		int[] prices5 = {1, 2};
		Log.log(maxProfit(prices5));
		int[] prices6 = {1, 2, 4};
		Log.log(maxProfit(prices6));
		
	}
	
	/**
	 * 
	 * @param prices
	 * @return
	 */
	public static int maxProfit(int[] prices) {
        int maxProfit = 0;
        int min = 99999999;
        int max = 0;
        if (prices.length == 2) {
			maxProfit = Math.max(prices[1]-prices[0], maxProfit);
		}
        for (int i = 0; i < prices.length - 1; i++) {
        	if (prices[i] > prices[i + 1]) { // 相邻两个数前面一个数比较大时，如果min比后面一个数小，那么更新min，并且至max为该数后面一个数。因为之后的数肯定和现在的min相差最大
        		if (min > prices[i + 1] && i < prices.length - 2) {
        			min = prices[i + 1];
        			max = prices[i + 2];
				}
			} else { // 相邻两个数后面一个数比较大时，如果max比后面一个数小，那么更新max，这样子max-min值差越大
				min = Math.min(min, prices[i]);
				if (max < prices[i + 1]) {
					max = prices[i + 1];
				}
			}
        	int profit = max - min;
        	if (profit > maxProfit) {
				maxProfit = profit;
			}
        }
        return maxProfit;
    }
	
	/**
	 * 循环两次，时间复杂度是O(n*n)
	 * @param prices
	 * @return
	 */
	public static int maxProfit2(int[] prices) {
        int maxProfit = 0;
        for (int i = 0; i < prices.length - 1; i++) {
			for (int j = i + 1; j < prices.length; j++) {
				int profit = prices[j] - prices[i];
				maxProfit = Math.max(maxProfit, profit);
			}
		}
        return maxProfit;
    }

}
