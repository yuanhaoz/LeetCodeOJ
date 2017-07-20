package backtracing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import utils.Log;

/**  
 * 39. Combination Sum
Description  Submission  Solutions  Add to List
Total Accepted: 138120
Total Submissions: 381552
Difficulty: Medium
Contributors: Admin
Given a set of candidate numbers (C) (without duplicates) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.

The same repeated number may be chosen from C unlimited number of times.

Note:
All numbers (including target) will be positive integers.
The solution set must not contain duplicate combinations.
For example, given candidate set [2, 3, 6, 7] and target 7, 
A solution set is: 
[
  [7],
  [2, 2, 3]
]   
 *  
 * @author 郑元浩 
 * @date 2017年2月10日 下午4:02:50 
 */
public class CombinationSum39 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {2, 3, 6, 7};
		int target = 7;
		List<List<Integer>> list = combinationSum(nums, target);
		Log.logTwoList(list);
	}
	
	/**
	 * 回溯法解决：考虑所有情况
	 * @param candidates
	 * @param target
	 * @return
	 */
	public static List<List<Integer>> combinationSum(int[] candidates, int target) {
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		Arrays.sort(candidates); // 对数组排序
		backtrack(list, new ArrayList<Integer>(), candidates, target, 0);
		return list;
    }
	
	/**
	 * 数组每个元素可以使用多次，因此回溯的时候应该考虑本元素
	 * @param list 返回的结果，包含所有情况
	 * @param tempList 暂存中间结果，如果总和小于目标值则继续添加，等于就添加该list，大于就退出该次回溯，从链表头删除最后一个节点
	 * @param candidates 原数组
	 * @param remain 剩余的数，每遍历一个数就用target减去它
	 * @param start 遍历到数组元素的第几个元素
	 */
	public static void backtrack(List<List<Integer>> list, List<Integer> tempList, int[] candidates, int remain, int start){
		if (remain < 0) { // 大于就退出循环
			return;
		} else if (remain == 0) { // 等于说明满足条件添加本次条件
			list.add(new ArrayList<Integer>(tempList));
		} else { // 否则进行回溯
			for (int i = start; i < candidates.length; i++) { // 从start元素开始，每次回溯更新
				tempList.add(candidates[i]); // 添加该元素
				backtrack(list, tempList, candidates, remain - candidates[i], i); // 回溯，更新剩余的数  和  数组的起始位置
				tempList.remove(tempList.size() - 1); // 去除数组的最后一个元素
			}
		}
	}

}
