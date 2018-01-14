package hard;

import java.util.Arrays;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 4. Median of Two Sorted Arrays Add to List
 DescriptionHintsSubmissionsSolutions
 Total Accepted: 160467
 Total Submissions: 753379
 Difficulty: Hard
 Contributor: LeetCode

 There are two sorted arrays nums1 and nums2 of size m and n respectively.

 Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).

 Example 1:
 nums1 = [1, 3]
 nums2 = [2]

 The median is 2.0
 Example 2:
 nums1 = [1, 2]
 nums2 = [3, 4]

 The median is (2 + 3)/2 = 2.5
 * Created by yuanhao on 2017/5/8.
 */
public class MedianofTwoSortedArrays4 {

    public static void main(String[] args) {
        int[] nums1 = {1, 3};
        int[] nums2 = {2};
        System.out.println(findMedianSortedArrays(nums1, nums2));
    }

    /**
     * 求两个排序数组的中位数，时间复杂度应该是 O(log(m+n))
     * @param nums1
     * @param nums2
     * @return
     */
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length == 0) {
            return median(nums2);
        }
        if (nums2.length == 0) {
            return median(nums1);
        }
        int[] nums = new int[nums1.length + nums2.length];
        int i = 0;
        int j = 0;
        int k = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] < nums2[j]) {
                nums[k++] = nums1[i++];
            } else {
                nums[k++] = nums2[j++];
            }
        }
        if (i < nums1.length) {
            while (i < nums1.length) {
                nums[k++] = nums1[i++];
            }
        }
        if (j < nums2.length) {
            while (j < nums2.length) {
                nums[k++] = nums2[j++];
            }
        }
        Arrays.toString(nums);
        for (int l = 0; l < nums.length; l++) {
            System.out.print(nums[l] + " ");
        }
        System.out.println();
        return median(nums);
    }

    /**
     * 求数组的中位数
     * @param num
     * @return
     */
    public static double median(int[] num) {
        int length = num.length;
        if ((length & 1) == 1) {
            return num[length/2];
        } else {
            return (double)(num[length/2] + num[length/2 - 1])/2.0;
        }
    }

}
