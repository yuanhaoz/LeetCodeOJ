package meidum;

import java.util.Arrays;

/** 
 * 268. Missing Number   Add to List QuestionEditorial Solution  My Submissions
Total Accepted: 86247
Total Submissions: 198153
Difficulty: Medium
Contributors: Admin
Given an array containing n distinct numbers taken from 0, 1, 2, ..., n, find the one that is missing from the array.

For example,
Given nums = [0, 1, 3] return 2.

Note:
Your algorithm should run in linear runtime complexity. 
Could you implement it using only constant extra space complexity?
 * 
 * @author 郑元浩
 * @date 2017年1月11日  上午12:08:52 
 */
public class MissingNumber268 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int[] nums = {0,1,3};
//		int[] nums = {0};
//		int[] nums = {0,1};
		int[] nums = {1};
		System.out.println(missingNumber(nums));
	}
	
	/**
	 * 这里需要注意的是，input的数组不一定的sorted的，并且是从0-n这n+1个数字中选出n个.所以这里n == len(nums), 记住下面的办法就行。
	 * 类似的题目还有，只有一个数出现一次，其余都出现两次，也可以用xor来找出那个数
		对于no missing array, [0,1,2,3]对应于index也是[0,1,2,3]. 所以value与index对应位置xor得到的结果肯定是0.
		但如果不相同的话，例如[0,1,3]对应的index是[0,1,2], 那么对应位置value与index对应位置xor之后，得到的数值再xor len(nums)，
		 e.g. 3 就可以得到最后的missing number
		是对index，和数，而且要先数后index。最后弄len(num)这个index
		
		位运算：将数组每个元素及其下标进行xor运算，0 xor n = n, n xor n = 0, 所以最终的结果再和数组长度xor即可
		
		5 2 1 0 4
		0 xor 5 xor 1 xor 2 xor 2 xor 1 xor 3 xor 0 xor 4 xor 4 = 5 xor 3 
		将其与nums.length = 5 xor (5 xor 3)= 3
		
	 * @param nums
	 * @return
	 */
	public static int missingNumber(int[] nums) {
		int xor = 0, i = 0;
    	for (i = 0; i < nums.length; i++) {
    		xor = xor ^ i ^ nums[i];
    	}
    
    	return xor ^ nums.length;
    }
	
	public static int missingNumber2(int[] nums) {
		Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
			if(nums[i] != i){
				return nums[i]-1;
			}
		}
        return nums[nums.length-1] + 1;
    }

}
