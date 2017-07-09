package easy.array;

import java.util.Arrays;

/**
 * 628. Maximum Product of Three Numbers
Given an integer array, find three numbers whose product is maximum and output the maximum product.

Example 1:
Input: [1,2,3]
Output: 6
Example 2:
Input: [1,2,3,4]
Output: 24
Note:
The length of the given array will be in range [3,104] and all elements are in the range [-1000, 1000].
Multiplication of any three numbers in the input won't exceed the range of 32-bit signed integer.
 * @author 郑元浩
 * @date 2017年7月9日 下午6:11:38
 * 
 * 
 */
public class MaximumProductofThreeNumbers628 {

	public static void main(String[] args) {
		int[] nums = {1,2,3};
		maximumProduct(nums);
		int[] nums1 = {1,2,3,4};
		maximumProduct(nums1);
		int[] nums2 = {1,2,5,8};
		maximumProduct(nums2);
		int[] nums3 = {-10, -7, -3, 2, 5, 8, 12};
		maximumProduct(nums3);
		int[] nums4 = {-1,-2,-3};
		maximumProduct(nums4);
	}
	
	/**
	 * 一遍循环得到数组中最大的三个数和最小的两个数，再计算比较最大值。无需对整个数组元素进行排序。时间复杂度O(n)
	 * @param nums
	 * @return
	 */
	public static int maximumProduct(int[] nums) {
		int max1 = Integer.MIN_VALUE, max2 = Integer.MIN_VALUE, max3 = Integer.MIN_VALUE;
		int min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE;
		for (int num : nums) {
			if (num >= max1) {
				max3 = max2;
				max2 = max1;
				max1 = num;
			} else if (num >= max2) {
				max3 = max2;
				max2 = num; 
			} else if (num >= max3) {
				max3 = num;
			} 
			if (num <= min1) {
				min2 = min1;
				min1 = num;
			} else if (num <= min2) {
				min2 = num;
			}
		}
		System.out.println(Math.max(max1 * max2 * max3, max1 * min1 * min2));
		System.out.println("max1->" + max1 + ", max2->" + max2 + ", max3->" + max3 +
				", min1->" + min1 + ", min2->" + min2);
		return Math.max(max1 * max2 * max3, max1 * min1 * min2);
    }
	
	/**
	 * 对数组进行排序，然后判断“最大的三个数的乘积”和“最小的两个数和最大的一个数的乘积”哪个更大，时间复杂度O(n^log(n))
	 * @param nums
	 * @return
	 */
	public static int maximumProduct2(int[] nums) {
		int len = nums.length;
		Arrays.sort(nums);
		int a = nums[len - 1] * nums[len - 2] * nums[len - 3];
		int b = nums[0] * nums[1] * nums[len - 1];
        System.out.println(Math.max(a, b));
        return Math.max(a, b);
    }
	
	/**
	 * 三遍循环判断数组计算数组乘积，时间复杂度O(n^3)
	 * @param nums
	 * @return
	 */
	public static int maximumProduct3(int[] nums) {
		int result = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length - 2; i++) {
			for (int j = i + 1; j < nums.length - 1; j++) {
				for (int j2 = j + 1; j2 < nums.length; j2++) {
					int temp = nums[i] * nums[j] * nums[j2];
					result = Math.max(temp, result);
//					result = result > temp ? result : temp;
				}
			}
		}
        System.out.println(result);
        return result;
    }

}

