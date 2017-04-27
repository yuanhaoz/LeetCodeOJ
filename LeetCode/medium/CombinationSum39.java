package medium;

import utils.Log;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
	
	public static List<List<Integer>> combinationSum(int[] candidates, int target) {
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		Arrays.sort(candidates);
		backtrack(list, new ArrayList<Integer>(), candidates, target, 0);
		return list;
    }
	
	public static void backtrack(List<List<Integer>> list, List<Integer> tempList, int[] candidates, int remain, int start){
		if (remain < 0) {
			return;
		} else if (remain == 0) {
			list.add(new ArrayList<Integer>(tempList));
		} else {
			for (int i = start; i < candidates.length; i++) {
				tempList.add(candidates[i]);
				backtrack(list, tempList, candidates, remain - candidates[i], i);
				tempList.remove(tempList.size() - 1);
			}
		}
	}

}
