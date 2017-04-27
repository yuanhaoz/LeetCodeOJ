package easy;

import java.util.Arrays;

/**
 * 561. Array Partition I Add to List
 * DescriptionHintsSubmissionsSolutions
 * Total Accepted: 4012
 * Total Submissions: 5367
 * Difficulty: Easy
 * Contributors:
 * Stomach_ache
 * Given an array of 2n integers, your task is to group these integers into n pairs of integer, say (a1, b1), (a2, b2), ...,
 * (an, bn) which makes sum of min(ai, bi) for all i from 1 to n as large as possible.
 * <p>
 * Example 1:
 * Input: [1,4,3,2]
 * <p>
 * Output: 4
 * Explanation: n is 2, and the maximum sum of pairs is 4.
 * Note:
 * n is a positive integer, which is in the range of [1, 10000].
 * All the integers in the array will be in the range of [-10000, 10000].
 * Created by yuanhao on 2017/4/27.
 */
public class ArrayPartitionI561 {

    public static void main(String[] args) {
        int[] nums = {1, 4, 3, 2};
        System.out.println(arrayPairSum(nums));
    }

    /**
     * 求数组中所有每两个元素最小值和的最大值
     * 思路：对数组进行排序，每两个元素为一组，这样得到的和最大
     *
     * @param nums
     * @return
     */
    public static int arrayPairSum(int[] nums) {
        int n = nums.length; // 数组元素应该是偶数
        if (n % 2 != 0) {
            return -1;
        } else {
            n = n / 2;
        }
        Arrays.sort(nums); // 对数组进行排序
        int count = 0;
        for (int i = 0; i < n; i++) {
            count += Math.min(nums[2 * i], nums[2 * i + 1]);
        }
        return count;
    }

}
