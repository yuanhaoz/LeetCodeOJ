package medium;

import java.util.Arrays;

/**
 * 16. 3Sum Closest Add to List
 * DescriptionHintsSubmissionsSolutions
 * Total Accepted: 122095
 * Total Submissions: 396778
 * Difficulty: Medium
 * Contributor: LeetCode
 * Given an array S of n integers, find three integers in S such that the sum is closest to a given number, target.
 * Return the sum of the three integers. You may assume that each input would have exactly one solution.
 * <p>
 * For example, given array S = {-1 2 1 -4}, and target = 1.
 * <p>
 * The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 * Created by yuanhao on 2017/4/27.
 */
public class ThreeSumClosest16 {

    /**
     * @param nums
     * @param target
     * @return
     */
    public static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums); // 数组排序
        int min = Integer.MAX_VALUE; // 三个数的和与target的差的最小值
        int result = Integer.MAX_VALUE; // 满足条件的三个数的和
        for (int i = 0; i < nums.length - 2; i++) {
            int left = i + 1; // 二分查找，左边
            int right = nums.length - 1; // 二分查找，右边
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right]; // 三个数的和
                int diff = Math.abs(sum - target); // 与目标值的差
                if (sum == target) { // 相等直接返回该值
                    return target;
                } else if (sum < target) { // 小于左指针右移使其和变大，减少误差
                    left++;
                    if (min > diff) { // 更新最小值差值，和满足最小差值的三个数和
                        min = diff;
                        result = sum;
                    }
                } else if (sum > target) { // 大于右指针左移使其和变小，减少误差
                    right--;
                    if (min > diff) {
                        min = diff;
                        result = sum;
                    }
                }
            }

        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {-1, 2, 1, -4, 5, 7};
        int target = 1;
        System.out.println(threeSumClosest(nums, target));
    }

}
