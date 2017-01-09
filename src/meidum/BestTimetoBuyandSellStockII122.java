package meidum;

import utils.Log;

/**  
 * 122. Best Time to Buy and Sell Stock II   Add to List QuestionEditorial Solution  My Submissions
Total Accepted: 116845
Total Submissions: 257982
Difficulty: Medium
Contributors: Admin

Say you have an array for which the ith element is the price of a given stock on day i.

Design an algorithm to find the maximum profit. You may complete as many transactions as you like 
(ie, buy one and sell one share of the stock multiple times). However, you may not engage in multiple 
transactions at the same time (ie, you must sell the stock before you buy again).  
 *  
 * @author 郑元浩 
 * @date 2016年12月24日
 */
public class BestTimetoBuyandSellStockII122 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] prices = {7, 1, 5, 3, 6, 15, 20, 4, 5, 6, 7};
		Log.log(maxProfit(prices));
		int[] prices1 = {7, 6, 4, 3, 1};
		Log.log(maxProfit(prices1));
		
	}
	
	/**
	 * 对于a<b>c<d，有(b-a)+(d-c)>(d-a)，因为b-c>0。如果b-c小于0，那么就是a<b<c<d，直接取d-a
	 * @param prices
	 * @return
	 */
	public static int maxProfit(int[] prices) {
		int total = 0;
        for (int i=0; i< prices.length-1; i++) {
            if (prices[i+1]>prices[i]) total += prices[i+1]-prices[i];
        }
        
        return total;
    }
	

}
