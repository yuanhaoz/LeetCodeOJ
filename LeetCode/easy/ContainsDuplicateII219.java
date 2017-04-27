package easy;

import java.util.HashMap;
import java.util.Map;

/**  
 * 219. Contains Duplicate II   Add to List QuestionEditorial Solution  My Submissions
Total Accepted: 89407
Total Submissions: 285001
Difficulty: Easy
Contributors: Admin

Given an array of integers and an integer k, find out whether there are two distinct indices i and j in the array 
such that nums[i] = nums[j] and the difference between i and j is at most k.   
 *  
 * @author 郑元浩 
 * @date 2016年12月28日 下午8:04:09 
 */
public class ContainsDuplicateII219 {

	public static void main(String[] args) {
		int[] nums = {0,1,2,3,4,5,0};
//		int[] nums = {0,1,2,3,4,5,6};
//		int[] nums = {};
		System.out.println(containsNearbyDuplicate(nums, 7));
		System.out.println(containsNearbyDuplicate2(nums, 7));
	}
	
	/**
	 * 使用 HashMap 保存并判断，key为数组元素的值，value为对应的数组下标
	 * 判断key相同的两个value之间的差和k的区别
	 * @param nums
	 * @param k
	 * @return
	 */
	public static boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
			if (map.keySet().contains(nums[i])) { // 第一次出现直接加入map
				int dis = i - map.get(nums[i]);
				if (dis <= k) {
					return true;
				}
			}
			map.put(nums[i], i);
		}
        return false;
    }
	
	public static boolean containsNearbyDuplicate2(int[] nums, int k) {
        boolean flag = false;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
			if (!map.keySet().contains(nums[i])) { // 第一次出现直接加入map
				map.put(nums[i], i);
			} else { // 后面出现的判断两次出现之间的下标差距
				int dis = i - map.get(nums[i]);
				if (dis <= k) {
					return true;
				} else {
					map.put(nums[i], i);
				}
			}
		}
        return flag;
    }

}
