package easy;

/**  
 * 485. Max Consecutive Ones
Description  Submission  Solutions  Add to List
Total Accepted: 16497
Total Submissions: 29659
Difficulty: Easy
Contributors: Stomach_ache

Given a binary array, find the maximum number of consecutive 1s in this array.

Example 1:
Input: [1,1,0,1,1,1]
Output: 3
Explanation: The first two digits or the last three digits are consecutive 1s.
    The maximum number of consecutive 1s is 3.
Note:

The input array will only contain 0 and 1.
The length of input array is a positive integer and will not exceed 10,000
Subscribe to see which companies asked this question.   
 *  
 * @author 郑元浩 
 * @date 2017年2月10日 下午2:53:54 
 */
public class MaxConsecutiveOnes485 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {1, 1, 0, 1, 1, 1};
		int[] nums1 = {1,0,1,1,0,1};
		findMaxConsecutiveOnes(nums);
		findMaxConsecutiveOnes(nums1);
	}
	
	/**
	 * 实现1:
	 * 设置标志位，如果是1，则为true。否则直到遇到0。
	 * 
	 * @param nums
	 * @return
	 */
	public static int findMaxConsecutiveOnes(int[] nums) {
		int max = 0; // 最大的值
		int count = 0; // 计算连续的1的个数
		int i = 0;
		boolean flag = false;
		while (i < nums.length) {
			if (nums[i] == 1) {
				flag = true;
			}
			if (flag == true && nums[i] == 1) {
				count++;
			}
			if (nums[i] == 0) {
				max = Math.max(max, count);
				flag = false;
				count = 0;
			}
			i++;
		}
		max = Math.max(max, count);
		return max;
    }

}
