package easy;

import utils.Log;

import java.util.ArrayList;
import java.util.List;

/**  
 * 448. Find All Numbers Disappeared in an Array   Add to List QuestionEditorial Solution  My Submissions
Total Accepted: 11194
Total Submissions: 19164
Difficulty: Easy
Contributors: yuhaowang001

Given an array of integers where 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and others appear once.

Find all the elements of [1, n] inclusive that do not appear in this array.

Could you do it without extra space and in O(n) runtime? 
You may assume the returned list does not count as extra space.

Example:

Input:
[4,3,2,7,8,2,3,1]

Output:
[5,6]   
 *  
 * @author 郑元浩 
 * @date 2016年12月27日
 */
public class FindAllNumbersDisappeared448 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {1,2,3,2,3,6,7,8};
		Log.log(findDisappearedNumbers(nums));
	}
	
	
	/**
	 * The basic idea is that we iterate through the input array and mark elements as negative using 
	 * nums[nums[i] -1] = -nums[nums[i]-1]. In this way all the numbers that we have seen will be 
	 * marked as negative. In the second iteration, if a value is not marked as negative, 
	 * it implies we have never seen that index before, so just add it to the return list.
	 * @param nums
	 * @return
	 */
	public static List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> ret = new ArrayList<Integer>();
        
        for(int i = 0; i < nums.length; i++) {
            int val = Math.abs(nums[i]) - 1;
            if(nums[val] > 0) {
             nums[val] = -nums[val];
            }
        }
        
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] > 0) {
                ret.add(i+1);
            }
        }
        return ret;
    }
	
	/**
	 * 需要额外的空间
	 * @param nums
	 * @return
	 */
	public static List<Integer> findDisappearedNumbers2(int[] nums) {
        List<Integer> numList = new ArrayList<Integer>();
        int len = nums.length;
        int[] times = new int[len];
        for (int i = 0; i < len; i++) {
			times[nums[i] - 1]++;
		}
        for (int i = 0; i < len; i++) {
			if (times[i] == 0) {
				numList.add(i + 1);
			}
		}
        return numList;
    }

}
