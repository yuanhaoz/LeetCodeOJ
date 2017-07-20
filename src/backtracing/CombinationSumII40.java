package backtracing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import utils.Log;

/**
 * 40. Combination Sum II
Given a collection of candidate numbers (C) and a target number (T), 
find all unique combinations in C where the candidate numbers sums to T.

Each number in C may only be used once in the combination.

Note:
All numbers (including target) will be positive integers.
The solution set must not contain duplicate combinations.
For example, given candidate set [10, 1, 2, 7, 6, 1, 5] and target 8, 
A solution set is: 
[
  [1, 7],
  [1, 2, 5],
  [2, 6],
  [1, 1, 6]
]
 * @author 郑元浩
 * @date 2017年7月20日 上午10:03:58
 *
 */
public class CombinationSumII40 {

	public static void main(String[] args) {
		int[] nums = {2};
		int target = 2;
		List<List<Integer>> list = combinationSum2(nums, target);
		Log.logTwoList(list);
	}
	
	/**
	 * 回溯法解决：考虑所有情况
	 * @param candidates
	 * @param target
	 * @return
	 */
	public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		if (candidates.length == 1) {
			if (target == candidates[0]) {
				ArrayList<Integer> tempList = new ArrayList<Integer>();
				tempList.add(target);
				list.add(tempList);
				return list;
			}
		}
        Arrays.sort(candidates);
        combinationSum2(list, new ArrayList<Integer>(), candidates, target, 0);
		return list;
    }
	
	/**
	 * 每个数只能使用一次，因此每次只能从下一个元素开始。
	 * 考虑返回的结果不包含重复的链表
	 * @param list 返回的结果，包含所有情况
	 * @param tempList 暂存中间结果，如果总和小于目标值则继续添加，等于就添加该list，大于就退出该次回溯，从链表头删除最后一个节点
	 * @param candidates 原数组
	 * @param remain 剩余的数，每遍历一个数就用target减去它
	 * @param start 遍历到数组元素的第几个元素
	 */
	public static void combinationSum2(List<List<Integer>> list, List<Integer> tempList, 
			int[] candidates, int remain, int start) {
		if (remain < 0) { // 大于就退出循环
			return;
		} else if (remain == 0) { // 等于说明满足条件添加本次条件
			list.add(new ArrayList<Integer>(tempList));
		} else { // 否则进行回溯
			for (int i = start; i < candidates.length; i++) { // 从start元素开始，每次回溯更新
				if (i > start && candidates[i] == candidates[i - 1]) { // 去除重复元素
					continue;
				}
				tempList.add(candidates[i]); // 添加该元素
				combinationSum2(list, tempList, candidates, remain - candidates[i], i + 1); // 回溯，更新剩余的数  和  数组的起始位置
				tempList.remove(tempList.size() - 1); // 去除数组的最后一个元素
			}
		}
	}
	
}
