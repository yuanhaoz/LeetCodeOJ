package easy;

import java.util.ArrayList;
import java.util.List;

import utils.Log;

/**  
 * 448. Find All Numbers Disappeared in an Array   Add to List QuestionEditorial Solution  My Submissions
Total Accepted: 11194
Total Submissions: 19164
Difficulty: Easy
Contributors: yuhaowang001
Given an array of integers where 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and others appear once.

Find all the elements of [1, n] inclusive that do not appear in this array.

Could you do it without extra space and in O(n) runtime? You may assume the returned list does not count as extra space.

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
	
	
	public static List<Integer> findDisappearedNumbers(int[] nums) {
        
        List<Integer> numList = new ArrayList<Integer>();
        int len = nums.length;
        int[] times = new int[len];
//        for (int i = 0; i < len; i++) {
//			times[i] = 0;
//		}
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
