package meidum;

import java.util.ArrayList;
import java.util.List;

import utils.Log;

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
	
	public static int maxProfit(int[] prices) {
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
        while(i < minus.length) {
        	int j = i + 1;
        	while (j < index.size() && index.get(j) - a == 1) {
        		
			}
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
