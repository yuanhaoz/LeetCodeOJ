package easy;

import java.util.Arrays;

/**
 * 532. K-diff Pairs in an Array Add to List
 * DescriptionHintsSubmissionsSolutions
 * Total Accepted: 10954
 * Total Submissions: 39831
 * Difficulty: Easy
 * Contributors:
 * murali.kf370
 * Given an array of integers and an integer k, you need to find the number of unique k-diff pairs in the array. Here a k-diff pair is defined as an integer pair (i, j), where i and j are both numbers in the array and their absolute difference is k.
 * <p>
 * Example 1:
 * Input: [3, 1, 4, 1, 5], k = 2
 * Output: 2
 * Explanation: There are two 2-diff pairs in the array, (1, 3) and (3, 5).
 * Although we have two 1s in the input, we should only return the number of unique pairs.
 * Example 2:
 * Input:[1, 2, 3, 4, 5], k = 1
 * Output: 4
 * Explanation: There are four 1-diff pairs in the array, (1, 2), (2, 3), (3, 4) and (4, 5).
 * Example 3:
 * Input: [1, 3, 1, 5, 4], k = 0
 * Output: 1
 * Explanation: There is one 0-diff pair in the array, (1, 1).
 * Note:
 * The pairs (i, j) and (j, i) count as the same pair.
 * The length of the array won't exceed 10,000.
 * All the integers in the given input belong to the range: [-1e7, 1e7].
 * Subscribe to see which companies asked this question.
 * Created by yuanhao on 2017/5/2.
 */
public class KdiffPairsinanArray532 {

    public int findPairs(int[] nums, int k) {
        int count = 0;
        Arrays.sort(nums); // 数组排序
        for (int i = 0; i < nums.length - 1; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) { // 如果两个元素相同，则跳过本次循环进入下一个循环判断
                continue;
            } else {
                int value = nums[i] + k;
                for (int j = i + 1; j < nums.length; j++) { // 判断是否存在相同的和，存在一次就可以退出所有循环了，因为后面的肯定都是重复的
                    if (value == nums[j]) {
                        count++;
//                        System.out.println(nums[i] + " " + nums[j]);
                        break;
                    }
                }
            }
        }
        return count;
    }

    public int findPairs2(int[] nums, int k) {
        int count = 0;
        Arrays.sort(nums); // 数组排序
        int left = 0;
        int right = 1;
        while (left < nums.length - 1 && right < nums.length && left < right) {
            if (left > 0 && nums[left] == nums[left - 1]) {
                left++;
                if (left == right) {
                    right++;
                }
                continue;
            }
            if (nums[right] - nums[left] < k) {
                right++;
            } else if (nums[right] - nums[left] == k) {
                count++;
                left++;
                right++;
            } else {
                left++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        KdiffPairsinanArray532 kdiffPairsinanArray532 = new KdiffPairsinanArray532();
        int[] nums = {3, 1, 4, 1, 5};
        int k = 2;
        System.out.println(kdiffPairsinanArray532.findPairs(nums, k));
        System.out.println(kdiffPairsinanArray532.findPairs2(nums, k));
        int[] nums1 = {1, 2, 3, 4, 5};
        int k1 = 1;
        System.out.println(kdiffPairsinanArray532.findPairs(nums1, k1));
        System.out.println(kdiffPairsinanArray532.findPairs2(nums1, k1));
        int[] nums2 = {1, 3, 1, 5, 4};
        int k2 = 0;
        System.out.println(kdiffPairsinanArray532.findPairs(nums2, k2));
        System.out.println(kdiffPairsinanArray532.findPairs2(nums2, k2));
        int[] nums3 = {1, 1, 1, 1, 1};
        int k3 = 0;
        System.out.println(kdiffPairsinanArray532.findPairs(nums3, k3));
        System.out.println(kdiffPairsinanArray532.findPairs2(nums3, k3));
        int[] nums4 = {1, 1, 1, 2, 2};
        int k4 = 0;
        System.out.println(kdiffPairsinanArray532.findPairs(nums4, k4));
        System.out.println(kdiffPairsinanArray532.findPairs2(nums4, k4));
        int[] nums5 = {6, 7, 3, 6, 4, 6, 3, 5, 6, 9};
        int k5 = 4;
        System.out.println(kdiffPairsinanArray532.findPairs(nums5, k5));
        System.out.println(kdiffPairsinanArray532.findPairs2(nums5, k5));
    }
}
