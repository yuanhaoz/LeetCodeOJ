package medium;

import java.util.ArrayList;
import java.util.List;

/**  
 * 78. Subsets Add to List
Description  Submission  Solutions
Total Accepted: 143184
Total Submissions: 381646
Difficulty: Medium
Contributors: Admin
Given a set of distinct integers, nums, return all possible subsets.

Note: The solution set must not contain duplicate subsets.

For example,
If nums = [1,2,3], a solution is:

[
  [3],
  [1],
  [2],
  [1,2,3],
  [1,3],
  [2,3],
  [1,2],
  []
]   
 *  
 * @author 郑元浩 
 * @date 2017年2月21日 下午9:05:43 
 */
public class Subsets78 {

	public static void main(String[] args) {
		int[] nums = {1, 2, 3, 4};
		List<List<Integer>> list = subsets(nums);
		System.out.println(list);
	}
	
	public static List<List<Integer>> subsets(int[] nums) {
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		List<Integer> init = new ArrayList<Integer>(); // 构造第一个元素
		init.add(nums[0]);
		list.add(init); // 第一个元素
		list.add(new ArrayList<Integer>()); // 空元素
		for (int i = 1; i < nums.length; i++) {
			subsets(nums, list, i);
		}
		return list;
    }
	
	/**
	 * 使用递归的方法，第n个数的所有情况是第n-1个数的每个list基础上，加上当前元素。然后当前元素单独可以构成一个。
	 * 注意对象的引用传递的是对象在堆中的地址，需要重新赋值。
	 * 
	 * @param nums
	 * @param list
	 * @param n
	 * @return
	 */
	public static List<List<Integer>> subsets(int[] nums, List<List<Integer>> list, int n) {
		// 保存原来的list数据
		List<List<Integer>> listCopy = new ArrayList<List<Integer>>(); 
		for (List<Integer> list2 : list) {
			List<Integer> list2Copy = new ArrayList<Integer>();
			for (Integer integer : list2) {
				list2Copy.add(integer);
			}
			listCopy.add(list2Copy);
		}
		// 添加新的元素
		for (List<Integer> list2 : list) {
			list2.add(nums[n]);
		}
		// 加上原来的数据
		list.addAll(listCopy);
		return list;
	}
	

}
