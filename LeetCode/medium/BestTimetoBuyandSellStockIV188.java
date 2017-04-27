package medium;
/** 
 * 188. Best Time to Buy and Sell Stock IV   Add to List QuestionEditorial Solution  My Submissions
Total Accepted: 39111
Total Submissions: 164302
Difficulty: Hard
Contributors: Admin
Say you have an array for which the ith element is the price of a given stock on day i.

Design an algorithm to find the maximum profit. You may complete at most k transactions.

Note:
You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
 * 
 * @author 郑元浩
 * @date 2017年1月11日  上午9:22:02 
 */
public class BestTimetoBuyandSellStockIV188 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	/**
	 * dp[i, j] represents the max profit up until prices[j] using at most i transactions. 
	 * dp[i, j] = max(dp[i, j-1], prices[j] - prices[jj] + dp[i-1, jj]) { jj in range of [0, j-1] }
	 *          = max(dp[i, j-1], prices[j] + max(dp[i-1, jj] - prices[jj]))
	 * dp[0, j] = 0; 0 transactions makes 0 profit
	 * dp[i, 0] = 0; if there is only one price data point you can't make any transaction.
	 * @param k
	 * @param prices
	 * @return
	 */
	public int maxProfit(int k, int[] prices) {
		int n = prices.length;
		if (n <= 1)
			return 0;
		
		//if k >= n/2, then you can make maximum number of transactions.
		if (k >=  n/2) {
			int maxPro = 0;
			for (int i = 1; i < n; i++) {
				if (prices[i] > prices[i-1])
					maxPro += prices[i] - prices[i-1];
			}
			return maxPro;
		}
		
	    int[][] dp = new int[k+1][n];
	    for (int i = 1; i <= k; i++) {
	    	int localMax = dp[i-1][0] - prices[0];
	    	for (int j = 1; j < n; j++) {
	    		dp[i][j] = Math.max(dp[i][j-1],  prices[j] + localMax);
	    		localMax = Math.max(localMax, dp[i-1][j] - prices[j]);
	    	}
	    }
	    return dp[k][n-1];
	}

}
