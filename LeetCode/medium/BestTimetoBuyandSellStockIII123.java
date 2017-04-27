package medium;

import utils.Log;

import java.util.ArrayList;
import java.util.List;

/**  
 * 123. Best Time to Buy and Sell Stock III   Add to List QuestionEditorial Solution  My Submissions
Total Accepted: 75269
Total Submissions: 266356
Difficulty: Hard
Contributors: Admin
Say you have an array for which the ith element is the price of a given stock on day i.

Design an algorithm to find the maximum profit. You may complete at most two transactions.

Note:
You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).   
 *  
 * @author 郑元浩 
 * @date 2017年1月9日 下午4:01:09 
 */
public class BestTimetoBuyandSellStockIII123 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] prices = {1,2,4,2,5,7,2,4,9,0};
//		int[] prices = {2,1,2,0,1};
//		int[] prices = {7,1,5,3,6,18,20,4,5,1,6,30,5};
//		int[] prices = {7, 1, 5, 3, 6, 4, 9};
//		int[] prices = {2,1};
//		int[] prices = {1,6};
//		int[] prices = {1,2,4};
//		int[] prices = {0};
//		int[] prices = {};
		Log.log("prices: " + maxProfit(prices));
	}
	
	/**
	 * 动态规划1：
	 * First assume that we have no money, so buy1 means that we have to borrow money from others, 
	 * we want to borrow less so that we have to make our balance as max as we can(because this is negative).
	 * 假设我们一开始米有钱，所以buy1表示我们借的钱，我们想去借尽量少的钱使得我们的利润最大（借1元比借5元好，一开始是负值）
	 * 
	 * sell1 means we decide to sell the stock, after selling it we have price[i] money and we have to give back 
	 * the money we owed, so we have price[i] - |buy1| = prices[i ] + buy1, we want to make this max.
	 * sell1是指我们决定卖掉股票，卖了以后我们有prices[i]的钱，再加上之前的buy1，就是减去上一步需要还的钱，得到我们的利润，使得利润最大。
	 * 
	 * buy2 means we want to buy another stock, we already have sell1 money, so after buying stock2 we have 
	 * buy2 = sell1 - price[i] money left, we want more money left, so we make it max.
	 * buy2表示我们又想买另外一只股票，我们已经有sell1的钱，因此在买完第二支股票的时候我们还剩余sell1-prices[i]的钱，我们需要更多的钱剩余，因此希望buy2很大。
	 * 
	 * sell2 means we want to sell stock2, we can have price[i] money after selling it, and we have buy2 money 
	 * left before, so sell2 = buy2 + prices[i], we make this max.
     * So sell2 is the most money we can have.
     * sell2意味着我们想卖掉第二支股票，我们可以获得price[i]的钱，我们之前有buy2的钱剩余，所以我们要使得sell2的利润最大。
	 * @param prices
	 * @return
	 */
	public static int maxProfit(int[] prices) {
		int sell1 = 0, sell2 = 0, buy1 = Integer.MIN_VALUE, buy2 = Integer.MIN_VALUE;
		for (int i = 0; i < prices.length; i++) {
			buy1 = Math.max(buy1, -prices[i]);
			sell1 = Math.max(sell1, buy1 + prices[i]);
			buy2 = Math.max(buy2, sell1 - prices[i]);
			sell2 = Math.max(sell2, buy2 + prices[i]);
		}
		return sell2;
	}
	
	/**
	 * 动态规划2
	 * @param prices
	 * @return
	 */
	public static int maxProfit3(int[] prices) {
		int hold1 = Integer.MIN_VALUE, hold2 = Integer.MIN_VALUE;
        int release1 = 0, release2 = 0;
        for(int i:prices){                              // Assume we only have 0 money at first
            release2 = Math.max(release2, hold2+i);     // The maximum if we've just sold 2nd stock so far.
            hold2    = Math.max(hold2,    release1-i);  // The maximum if we've just buy  2nd stock so far.
            release1 = Math.max(release1, hold1+i);     // The maximum if we've just sold 1nd stock so far.
            hold1    = Math.max(hold1,    -i);          // The maximum if we've just buy  1st stock so far. 
        }
        return release2; ///Since release1 is initiated as 0, so release2 will always higher than release1.
    }
	
	/**
	 * 自己没有写出来
	 * @param prices
	 * @return
	 */
	public static int maxProfit2(int[] prices) {
		if (prices.length == 0 || prices.length == 1) {
			return 0;
		}
		int[] minus = new int[prices.length - 1];
        for (int i = 0; i < prices.length - 1; i++) {
			minus[i] = prices[i + 1] - prices[i];
		}
        List<Integer> index = new ArrayList<Integer>();
        List<Integer> indexFu = new ArrayList<Integer>();
        for (int i = 0; i < minus.length; i++) {
			if (minus[i] > 0) {
				index.add(i);
			} else {
				indexFu.add(i);
			}
		}
        Log.log("index: " + index);
        for (int i = 0; i < minus.length; i++) {
			System.out.print(minus[i] + " ");
		}
        System.out.println();
        
        if (index.size() == 0) {
			return 0;
		}
        if (index.size() == 1) {
			return minus[index.get(0)];
		}
        
        List<Integer> value = new ArrayList<Integer>();
        int i = 0;
        while( i < index.size() - 1 ) {
        	int j = i + 1;
        	int a = index.get(i);
        	while (j < index.size() && index.get(j) - a == 1) {
				j++;
				a = a + 1;
			}
        	if (j - i == 1) {
				value.add(minus[index.get(i)]);
				i++;
			} else {
				int sum = 0;
				for (int k = i; k < j; k++) {
					sum += minus[index.get(k)];
				}
				value.add(sum);
				i = j;
			}
		}
        if (i != index.size()) {
        	value.add(minus[index.get(index.size() - 1)]);
		}
        Log.log("value: " + value);
        if (value.size() == 0) {
			return 0;
		}
        if (value.size() == 1) {
			return value.get(0);
		}
        int big = Integer.MIN_VALUE;
        for (int j = 0; j < value.size()-1; j++) {
        	for (int j2 = j+1; j2 < value.size(); j2++) {
        		big= Math.max(big, value.get(j)+value.get(j2));
			}
		}
        return big;
    }
	

}
