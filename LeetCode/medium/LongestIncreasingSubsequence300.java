package medium;

import java.util.Arrays;

/**  
 * 300. Longest Increasing Subsequence   Add to List QuestionEditorial Solution  My Submissions
Total Accepted: 59438
Total Submissions: 159444
Difficulty: Medium
Contributors: Admin
Given an unsorted array of integers, find the length of longest increasing subsequence.

For example,
Given [10, 9, 2, 5, 3, 7, 101, 18],
The longest increasing subsequence is [2, 3, 7, 101], therefore the length is 4. Note that there may be more than one LIS combination, it is only necessary for you to return the length.

Your algorithm should run in O(n2) complexity.

Follow up: Could you improve it to O(n log n) time complexity?   
 *  
 * @author 郑元浩 
 * @date 2017年1月5日 上午11:37:18 
 */
public class LongestIncreasingSubsequence300 {

	public static void main(String[] args) {
//		int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};
		int[] nums = {10,9,2,5,3,4};
//		int[] nums = {1,3,6,7,9,4,10,5,6};
//		int[] nums = {2,2};
//		int[] nums = {-2,-1};
//		int[] nums = {3,2,1};
//		int[] nums = {3,1,2};
//		int[] nums = {3,5,6,2,5,4,19,5,6,7,12};
		System.out.println(lengthOfLIS2(nums));
	}
	
	public static int lengthOfLIS(int[] nums) {
		int[] dp = new int[nums.length];
        int len = 0;

        for(int x : nums) {
            int i = Arrays.binarySearch(dp, 0, len, x);
            if(i < 0) i = -(i + 1);
            dp[i] = x;
            if(i == len) len++;
        }

        return len;
    }
	
	public static int lengthOfLIS2(int[] nums) {
		// Base case
		if(nums.length <= 1) 
			return nums.length;

		// This will be our array to track longest sequence length
		int T[] = new int[nums.length];

		// Fill each position with value 1 in the array
		for(int i=0; i < nums.length; i++)
			T[i] = 1;


		// Mark one pointer at i. For each i, start from j=0.  10,9,2,5,3,4
		for(int i=1; i < nums.length; i++)
		{
			System.out.println("第" + (i+1) + "个元素：" + nums[i]);
			for(int j = 0; j < i; j++)
			{
				// It means next number contributes to increasing sequence.
				if(nums[j] < nums[i])
				{
					System.out.println(nums[j]);
					// But increase the value only if it results in a larger value of the sequence than T[i]
					// It is possible that T[i] already has larger value from some previous j'th iteration
					if(T[j] + 1 > T[i])
					{
						System.out.println("第" + (j+1) + "个元素为：" + T[j]);
						System.out.println("第" + (i+1) + "个元素为：" + T[i]);
						T[i] = T[j] + 1;
					}
				}
			}
		}

		// Find the maximum length from the array that we just generated 
		int longest = 0;
		for(int i=0; i < T.length; i++)
			longest = Math.max(longest, T[i]);

		return longest;
	}

}
