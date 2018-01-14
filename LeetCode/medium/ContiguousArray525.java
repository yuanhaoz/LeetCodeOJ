package medium;

import java.util.HashMap;
import java.util.Map;

/**
 * 525. Contiguous Array Add to List
 DescriptionHintsSubmissionsSolutions
 Total Accepted: 6922
 Total Submissions: 19031
 Difficulty: Medium
 Contributors:
 bishwa
 Given a binary array, find the maximum length of a contiguous subarray with equal number of 0 and 1.

 Example 1:
 Input: [0,1]
 Output: 2
 Explanation: [0, 1] is the longest contiguous subarray with equal number of 0 and 1.
 Example 2:
 Input: [0,1,0]
 Output: 2
 Explanation: [0, 1] (or [1, 0]) is a longest contiguous subarray with equal number of 0 and 1.
 * Created by yuanhao on 2017/5/8.
 */
public class ContiguousArray525 {

    /**
     * The idea is to change 0 in the original array to -1. Thus, if we find SUM[i, j] == 0 when we know there are even number of -1 and 1 between index
     * i and j. Also put the sum to index mapping to a HashMap to make search faster.
     * {0,0,1,0,0,0,1,1};
     * @param nums
     * @return
     */
    public static int findMaxLength2(int[] nums) {
        // 将数组中的元素0全部变为-1
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                nums[i] = -1;
            }
        }
        // map集合保存当前位置所有数字之和及第一次出现该数的下标位置
        Map<Integer, Integer> sumToIndex = new HashMap<>();
        sumToIndex.put(0, -1);
        int sum = 0, max = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i]; // 计算前i个数组元素之和
            if (sumToIndex.containsKey(sum)) { // 判断map是否有该元素，存在说明这两个下标之间的元素的0和1的个数相等，更新max的值
                max = Math.max(max, i - sumToIndex.get(sum));
            } else { // 否则，将其加入到map中
                sumToIndex.put(sum, i);
            }
        }
        for (Integer integer : sumToIndex.keySet()) {
            System.out.println(integer + "--->" + sumToIndex.get(integer));
        }
        return max;
    }

    /**
     * 复杂度高
     * @param nums
     * @return
     */
    public static int findMaxLength(int[] nums) {
        int max = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            int count0 = 0;
            int count1 = 0;
            if (nums[i] == 0) { // 第一个数的0、1判断
                count0++;
            } else {
                count1++;
            }
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] == 0) { // 第二个数的0、1判断
                    count0++;
                } else {
                    count1++;
                }
                if (count0 == count1) { // 判断子数组的0和1的个数是否相等，如果相等的话，更新最大子数组的长度
                    max = Math.max(max, j - i + 1);
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums = {0,1};
//        System.out.println(findMaxLength(nums));
        int[] nums1 = {0,1,0};
//        System.out.println(findMaxLength(nums1));
        int[] nums2 = {0,0,1,0,0,0,1,1};
//        System.out.println(findMaxLength(nums2));
        System.out.println(findMaxLength2(nums2));
    }

}
