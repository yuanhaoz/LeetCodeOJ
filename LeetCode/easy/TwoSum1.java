package easy;
/**  
 * 1. Two Sum   Add to List QuestionEditorial Solution  My Submissions
Total Accepted: 383882
Total Submissions: 1296504
Difficulty: Easy
Contributors: Admin
Given an array of integers, return indices of the two numbers such that they add up to a specific target.

You may assume that each input would have exactly one solution.

Example:
Given nums = [2, 7, 11, 15], target = 9,

Because nums[0] + nums[1] = 2 + 7 = 9,
return [0, 1].
UPDATE (2016/2/13):
The return format had been changed to zero-based indices. Please read the above updated description carefully.

Subscribe to see which companies asked this question   
 *  
 * @author 郑元浩 
 * @date 2016年12月30日 下午10:26:03 
 */
public class TwoSum1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        for(int index1 = 0; index1 < nums.length - 1; index1++){
            for(int index2 = index1 + 1; index2 < nums.length; index2++){
                int a = nums[index1] + nums[index2];
                if(a == target){
                    result[0] = index1 + 1;
                    result[1] = index2 + 1;
                }
            }
        }
        return result;
    }

}
