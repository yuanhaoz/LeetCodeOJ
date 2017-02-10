package medium;

import java.util.Arrays;

/**  
 * 215. Kth Largest Element in an Array   Add to List QuestionEditorial Solution  My Submissions
Total Accepted: 103509
Total Submissions: 275678
Difficulty: Medium
Contributors: Admin
Find the kth largest element in an unsorted array. Note that it is the kth largest element in the sorted order, not the kth distinct element.

For example,
Given [3,2,1,5,6,4] and k = 2, return 5.

Note: 
You may assume k is always valid, 1 ≤ k ≤ array's length.

Credits:
Special thanks to @mithmatt for adding this problem and creating all test cases.   
 *  
 * @author 郑元浩 
 * @date 2017年1月18日 上午11:32:21 
 */
public class KthLargestElementinanArray215 {

	public static void main(String[] args) {
		int[] nums = {3,2,1,5,5,6,4};
		int k =4;
		findKthLargest(nums, k);
	}
	
	/**
	 * 对数组进行排序，取后面的几个元素
	 * @param nums
	 * @param k
	 * @return
	 */
	public static int findKthLargest(int[] nums, int k) {
		Arrays.sort(nums);
		System.out.println(nums[nums.length - k]);
		return nums[nums.length - k];
    }

}
