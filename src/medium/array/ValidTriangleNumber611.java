package medium.array;

import java.util.Arrays;

/**
 *  
Add to List
611. Valid Triangle Number
DescriptionHintsSubmissionsSolutions
Discuss   Editorial Solution Pick One
Given an array consists of non-negative integers, your task is to count the number of triplets chosen from the array that can make triangles if we take them as side lengths of a triangle.

Example 1:
Input: [2,2,3,4]
Output: 3
Explanation:
Valid combinations are: 
2,3,4 (using the first 2)
2,3,4 (using the second 2)
2,2,3
Note:
The length of the given array won't exceed 1000.
The integers in the given array are in the range of [0, 1000].
 * @author 郑元浩
 * @date 2017年7月9日 下午10:05:13
 *
 */
public class ValidTriangleNumber611 {

	public static void main(String[] args) {
		int[] nums = {2,2,3,4};
		triangleNumber(nums);
	}
	
	/**
	 * 二分搜索
	 * @param nums
	 * @return
	 */
	public static int triangleNumber(int[] nums) {
		int count = 0;
		Arrays.sort(nums); // 数组排序
		for (int i = nums.length - 1; i >= 2; i--) { // 从数组最大的数，即最长的边开始比较
			int left = 0, right = i - 1;
			while (left < right) {
				if (nums[left] + nums[right] > nums[i]) { // 两短边之和大于长边，left之后的都满足
					count += right - left;
					right--;
				} else { // 否则左指针前移
					left++;
				}
				
			}
		}
		System.out.println(count);
		return count;
	}
	
	/**
	 * 时间复杂度O(n^3)，最蠢的办法，竟然accepted，时间限制不高，测试案例不够复杂
	 * @param nums
	 * @return
	 */
	public static int triangleNumber2(int[] nums) {
        int count = 0;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
			for (int j = i + 1; j < nums.length - 1; j++) {
				for (int j2 = j + 1; j2 < nums.length; j2++) {
					if ((nums[i] + nums[j] > nums[j2]) && (nums[j2] - nums[i] < nums[j])) {
						count++;
					}
				}
			}
		}
		System.out.println(count);
		return count;
    }

}
