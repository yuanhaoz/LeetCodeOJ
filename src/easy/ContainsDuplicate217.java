package easy;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**  
 * 217. Contains Duplicate   Add to List QuestionEditorial Solution  My Submissions
Total Accepted: 133021
Total Submissions: 305661
Difficulty: Easy
Contributors: Admin
Given an array of integers, find if the array contains any duplicates. 
Your function should return true if any value appears at least twice in the array, 
and it should return false if every element is distinct.

 *  
 * @author 郑元浩 
 * @date 2016年12月28日 下午7:45:14 
 */
public class ContainsDuplicate217 {

	public static void main(String[] args) {
		int[] nums = {0,1,2,3,3,4,5,6};
//		int[] nums = {0,1,2,3,4,5,6};
//		int[] nums = {};
		System.out.println(containsDuplicate2(nums));
	}
	
	public static boolean containsDuplicate(int[] nums) {
		Boolean flag = false;
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < nums.length; i++) {
			if (map.keySet().contains(nums[i])) {
				return true;
			} else {
				map.put(nums[i], i);
			}
		}
		return flag;
    }
	
	public static boolean containsDuplicate2(int[] nums) {
		Boolean flag = false;
		Set<Integer> set = new HashSet<Integer>();
		for (int i = 0; i < nums.length; i++) {
			if (set.contains(nums[i])) {
				return true;
			} else {
				set.add(nums[i]);
			}
		}
		return flag;
    }

}
