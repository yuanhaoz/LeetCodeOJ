package meidum;

import java.util.Arrays;

/**  
 * 152. Maximum Product Subarray   Add to List QuestionEditorial Solution  My Submissions
Total Accepted: 84020
Total Submissions: 344345
Difficulty: Medium
Contributors: Admin
Find the contiguous subarray within an array (containing at least one number) which has the largest product.

For example, given the array [2,3,-2,4],
the contiguous subarray [2,3] has the largest product = 6.

Subscribe to see which companies asked this question   
 *  
 * @author 郑元浩 
 * @date 2017年1月6日 下午8:33:29 
 */
public class MaximumProductSubarray152 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int[] nums = {2, 3, -2, 4, 5, 6, 3, -4, -3, -2, 3, 2};
//		int[] nums = {2, 3, -2, 4};
//		int[] nums = {-2};
//		int[] nums = {-3,2,1,-2};
		int[] nums = {-4,-3,-2};
//		maxProduct(nums, 1, 3);
		System.out.println(maxProduct3(nums));
	}
	
	/**
	 * 这道题跟Maximum Subarray模型上和思路上都比较类似，还是用一维动态规划中的“局部最优和全局最优法”。
	 * 这里的区别是维护一个局部最优不足以求得后面的全局最优，这是由于乘法的性质不像加法那样，累加结果只要是正的一定是递增，
	 * 乘法中有可能现在看起来小的一个负数，后面跟另一个负数相乘就会得到最大的乘积。
	 * 不过事实上也没有麻烦很多，我们只需要在维护一个局部最大的同时，在维护一个局部最小，这样如果下一个元素遇到负数时，
	 * 就有可能与这个最小相乘得到当前最大的乘积和，这也是利用乘法的性质得到的。 
	 * @param nums
	 * @return
	 */
	public static int maxProduct3(int[] nums) {
	    if (nums.length == 0) {
	        return 0;
	    }
	    
	    int maxLocalPre = nums[0]; // 局部最大值(上一步)
	    int minLocalPre = nums[0]; // 局部最小值(上一步)
	    int maxGlobal = nums[0]; // 全局最大值
	    int maxLocal = 0, minLocal = 0; // 局部最大值、最小值(当前)
	    
	    for (int i = 1; i < nums.length; i++) {
	    	System.out.println("maxherepre:" + maxLocalPre + "，minherepre:" + minLocalPre + "，maxsofar：" + maxGlobal
	    			+ "，maxhere：" + maxLocal + "，minhere：" + minLocal);
	        maxLocal = Math.max(Math.max(maxLocalPre * nums[i], minLocalPre * nums[i]), nums[i]); // 三个数中的最大值（上一步最大值、最小值分别和当前数的乘积，和当前数这三个数字之间进行比较）
	        minLocal = Math.min(Math.min(maxLocalPre * nums[i], minLocalPre * nums[i]), nums[i]); // 三个数中的最小值
	        maxGlobal = Math.max(maxLocal, maxGlobal); // 更新全局最大值
	        maxLocalPre = maxLocal; // 更新局部最大值
	        minLocalPre = minLocal; // 更新局部最小值
	        System.out.println("maxherepre:" + maxLocalPre + "，minherepre:" + minLocalPre + "，maxsofar：" + maxGlobal
	    			+ "，maxhere：" + maxLocal + "，minhere：" + minLocal);
	    }
	    return maxGlobal;
	}
	
	public static int maxProduct(int[] nums) {
		int len = nums.length;
		if (len == 0) {
			return 0;
		}
		int biggest = Integer.MIN_VALUE;
		for (int i = 0; i < len - 1; i++) {
			for (int j = i + 1; j < len; j++) {
				int[] pro = maxProduct(nums, i, j);
				Arrays.sort(pro);
				biggest = Math.max(biggest, pro[pro.length-1]);
			}
		}
		biggest = Math.max(biggest, nums[len - 1]);
		
        return biggest;
	}
	
	public static int[] maxProduct(int[] nums, int begin, int end) {
		int[] product = new int[end - begin + 1];
		product[0] = nums[begin];
		for (int i = begin + 1; i <= end; i++) {
			product[i - begin] = product[i - begin - 1] * nums[i];
		}
//		for (int i = 0; i < product.length; i++) {
//			System.out.print(product[i] + " ");
//		}
		return product;
	}
	
	
	/**
	 * 遍历数组的每一个元素，时间复杂度很高
	 * @param nums
	 * @return
	 */
	public static int maxProduct2(int[] nums) {
		int len = nums.length;
		if (len == 0) {
			return 0;
		}
		int biggest = Integer.MIN_VALUE;
		int fu = 0;
		int zero = 0;
		for (int i = 0; i < len; i++) {
			if (nums[i] < 0) {
				fu++;
			} else if(nums[i] == 0) {
				zero++;
			}
		}
		if (fu%2==0&&zero==0) {
			biggest = 1;
			for (int i = 0; i < nums.length; i++) {
				biggest *= nums[i];
			}
		}
        for (int i = 0; i < len - 1; i++) {
        	int result = nums[i];
        	biggest = Math.max(biggest, result);
        	for (int j = i + 1; j < len; j++) {
				result = result * nums[j];
				biggest = Math.max(biggest, result);
			}
		}
        biggest = Math.max(biggest, nums[len - 1]);
        return biggest;
    }

}
