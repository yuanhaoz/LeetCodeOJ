package easy;

import java.util.HashSet;
import java.util.Set;

/**  
 * 349. Intersection of Two Arrays   Add to List QuestionEditorial Solution  My Submissions
Total Accepted: 66423
Total Submissions: 145817
Difficulty: Easy
Contributors: Admin

Given two arrays, write a function to compute their intersection.

Example:
Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2].

Note:
Each element in the result must be unique.
The result can be in any order.   
 *  
 * @author 郑元浩 
 * @date 2017年1月4日 上午9:57:07 
 */
public class IntersectionofTwoArrays349 {

	public static void main(String[] args) {
		int[] nums1 = {1,2,2,1};
		int[] nums2 = {2,2};
//		int[] nums1 = {};
//		int[] nums2 = {};
		intersection(nums1, nums2);
	}
	
	/**
	 * 将两个数组保存到set集合中（因为不需要重复的元素），将两个set集合中重复的元素进行保留就是交集。
	 * @param nums1
	 * @param nums2
	 * @return
	 */
	public static int[] intersection(int[] nums1, int[] nums2) {
		Set<Integer> set = new HashSet<Integer>();
		Set<Integer> table = new HashSet<Integer>();
        for (int i = 0; i < nums1.length; i++) {
        	table.add(nums1[i]);
		}
        for (int i = 0; i < nums2.length; i++) {
			if (table.contains(nums2[i])) {
				set.add(nums2[i]);
			}
		}
        int[] result = new int[set.size()];
        int i = 0;
        for (Integer e : set) {
        	result[i++] = e;
        }
//        for (int j = 0; j < result.length; j++) {
//			System.out.println(result[j]);
//		}
        return result;
    }

}
