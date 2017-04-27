package medium;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**  
 * 15. 3Sum   Add to List QuestionEditorial Solution  My Submissions
Total Accepted: 171818
Total Submissions: 825124
Difficulty: Medium
Contributors: Admin
Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? Find all unique triplets in 
the array which gives the sum of zero.

Note: The solution set must not contain duplicate triplets.

For example, given array S = [-1, 0, 1, 2, -1, -4],

A solution set is:
[
  [-1, 0, 1],
  [-1, -1, 2]
]   
 *  
 * @author 郑元浩 
 * @date 2017年1月3日 下午11:09:04 
 */
public class ThreeSum15 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}
	
	/**
     * The idea is to sort an input array and then run through all indices of a possible first element of a triplet. 
	 * For each possible first element we make a standard bi-directional 2Sum sweep of the remaining part of the array. 
	 * Also we want to skip equal elements to avoid duplicates in the answer without making a set or smth like that.
	 * 1. 对数组进行排序，遍历数组的每一个元素
	 * 2. 对于每一个元素，对其余部分的进行双向遍历（2个指针）
	 * 3. 忽略重复元素，省去用set存储元素
	 * @param nums
	 * @return
	 */
	public static List<List<Integer>> threeSum(int[] nums) {
		Arrays.sort(nums); // 1. 数组排序
		List<List<Integer>> list = new LinkedList<>();
        for (int i = 0; i < nums.length - 2; i++) {
        	if (i == 0 || (i > 0 && nums[i] != nums[i - 1])) { // 3. 忽略重复元素，如果发现重复元素什么都不做，直接跳过
				int left = i + 1, right = nums.length - 1, sum = 0 - nums[i]; // 2. 两个指针遍历元素
				while (left < right) {
					int result = nums[left] + nums[right];
					if (result == sum) {
						list.add(Arrays.asList(nums[i], nums[left], nums[right]));
						while (left < right && nums[left] == nums[left + 1]) { // // 3. 忽略重复元素，如果发现重复元素什么都不做，直接跳过
							left++;
						} 
						while (left < right && nums[right] == nums[right - 1]) {
							right--;
						}
						left++;
						right--;
					} else if (result < sum) {
						left++;
					} else if (result > sum) {
						right--;
					}
				}
			}
        }
        return list;
    }

}
