package easy;

import utils.Log;

/**  
 * 27. Remove Element   Add to List QuestionEditorial Solution  My Submissions
Total Accepted: 163198
Total Submissions: 443781
Difficulty: Easy
Contributors: Admin
Given an array and a value, remove all instances of that value in place and return the new length.

Do not allocate extra space for another array, you must do this in place with constant memory.

The order of elements can be changed. It doesn't matter what you leave beyond the new length.

Example:
Given input array nums = [3,2,2,3], val = 3

Your function should return length = 2, with the first two elements of nums being 2.   
 *  
 * @author 郑元浩 
 * @date 2016年12月27日
 */
public class RemoveElement27 {

	public static void main(String[] args) {
		int[] nums = {};
//		int[] nums = {1};
//		int[] nums = {1, 2};
//		int[] nums = {1, 2, 2};
//		int[] nums = {1, 21, 3, 111, 32, 3};
		int val = 3;
		Log.log(removeElement(nums, val));
	}
	
	/**
	 * 方法和  "MovesZeros283"题一致，这个是更一般的情况，之前的题目是val=0的情况
	 * @param nums
	 * @param val
	 * @return
	 */
	public static int removeElement(int[] nums, int val) {
		int count = 0;
		for (int i = 0; i < nums.length; i++) {
			int j = i;
			int temp;
			while (nums[j] == val && j < nums.length - 1){
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
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] != val) {
				count++;
			} else {
				break;
			}
		}
		return count;
    }

}
