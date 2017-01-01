package easy;

import utils.Log;

/**  
 * 283. Move Zeroes   Add to List QuestionEditorial Solution  My Submissions
Total Accepted: 144013
Total Submissions: 302880
Difficulty: Easy
Contributors: Admin

Given an array nums, write a function to move all 0's to the end of it while 
maintaining the relative order of the non-zero elements.

For example, given nums = [0, 1, 0, 3, 12], after calling your function, nums should be [1, 3, 12, 0, 0].

Note:
You must do this in-place without making a copy of the array.
Minimize the total number of operations.   
 *  
 *  
 *  题目延伸：RemoveElement27.java
 *  
 * @author 郑元浩 
 * @date 2016年12月27日
 */
public class MoveZeroes283 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {1};
//		int[] nums = {1,2,3,0,0,6,7,8};
		int[] a = moveZeroes(nums);
		for (int i = 0; i < a.length; i++) {
			Log.log(a[i]);
		}
	}
	
	public static int[] moveZeroes(int[] nums){
		for (int i = 0; i < nums.length; i++) {
			int j = i;
			int temp;
			while (nums[j] == 0 && j < nums.length - 1){
				j++;
			}
			if (j == nums.length) {
				break;
			} else {
				temp = nums[i];
				nums[i] = nums[j];
				nums[j] = temp;
			}
		}
		return nums;
	}

}
