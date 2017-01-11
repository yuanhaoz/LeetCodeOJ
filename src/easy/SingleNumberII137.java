package easy;
/** 
 * 137. Single Number II   Add to List QuestionEditorial Solution  My Submissions
Total Accepted: 105693
Total Submissions: 263198
Difficulty: Medium
Contributors: Admin

Given an array of integers, every element appears three times except for one, which appears exactly once.
Find that single one.

Note:
Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
 * 
 * @author 郑元浩
 * @date 2017年1月11日  上午9:24:33 
 */
public class SingleNumberII137 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static int singleNumber(int[] nums) {
		int ones = 0, twos = 0;
	    for(int i = 0; i < nums.length; i++){
	        ones = (ones ^ nums[i]) & ~twos;
	        twos = (twos ^ nums[i]) & ~ones;
	    }
	    return ones;
    }

}
