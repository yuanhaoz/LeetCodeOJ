package medium;

import java.util.ArrayList;
import java.util.List;

/**
 * 228. Summary Ranges Add to List
 * DescriptionHintsSubmissionsSolutions
 * Total Accepted: 74675
 * Total Submissions: 257932
 * Difficulty: Medium
 * Contributor: LeetCode
 * <p>
 * Given a sorted integer array without duplicates, return the summary of its ranges.
 * <p>
 * For example, given [0,1,2,4,5,7], return ["0->2","4->5","7"].
 * <p>
 * Credits:
 * Special thanks to @jianchao.li.fighter for adding this problem and creating all test cases.
 * <p>
 * Subscribe to see which companies asked this question.
 * Created by yuanhao on 2017/5/2.
 */
public class SummaryRanges228 {

    /**
     * 返回排序数组中的连续区间的总结
     * 两个指针
     *
     * @param nums
     * @return
     */
    public List<String> summaryRanges(int[] nums) {
        List<String> list = new ArrayList<>();
        int l = 0; // 两个指针
        int r = 0;
        while (l < nums.length - 1 && r < nums.length && l <= r) { // 循环条件
            if (r < nums.length - 1 && nums[r + 1] - nums[r] == 1) { // 连续的话第二个指针后移
                r++;
            } else { // 否则不连续，先添加list，再重新设置两个指针
                if (l == r) { // 只有一个元素
                    list.add(nums[l] + "");
                } else { // 有多个元素
                    list.add(nums[l] + "->" + nums[r]);
                }
                l = r + 1;
                r = r + 1; // 重新设置两个指针
            }
        }
        if (r < nums.length) { // 针对最后一个元素不连续的情况
            list.add(nums[r] + "");
        }
//        System.out.println("r:" + r);
        return list;
    }

    public static void main(String[] args) {
        SummaryRanges228 summaryRanges228 = new SummaryRanges228();
        int[] nums = {0, 1, 2, 4, 5, 7};
        System.out.println(summaryRanges228.summaryRanges(nums));
        int[] nums1 = {0, 1, 2, 4, 5, 6};
        System.out.println(summaryRanges228.summaryRanges(nums1));
    }

}
