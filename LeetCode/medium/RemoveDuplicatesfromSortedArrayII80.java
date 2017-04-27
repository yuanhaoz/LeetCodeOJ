package medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**  
 * 80. Remove Duplicates from Sorted Array II   Add to List QuestionEditorial Solution  My Submissions
Total Accepted: 100182
Total Submissions: 287673
Difficulty: Medium
Contributors: Admin
Follow up for "Remove Duplicates":
What if duplicates are allowed at most twice?

For example,
Given sorted array nums = [1,1,1,2,2,3],

Your function should return length = 5, with the first five elements of nums being 1, 1, 2, 2 and 3. 
It doesn't matter what you leave beyond the new length.   
 *  
 * @author 郑元浩 
 * @date 2017年1月4日 上午11:19:48 
 */
public class RemoveDuplicatesfromSortedArrayII80 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	/**
	 * 方法弊端：数组是已经排序好的（省去很多判断比较）
	 * 1. Hashmap存储元素及其出现次数
	 * 2. 当出现次数大于2时，不需要该元素
	 * 3. 不使用list
	 * @param nums
	 * @return
	 */
	public static int removeDuplicates(int[] nums) {
		int result = 0;
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < nums.length; i++) {
			if (!map.containsKey(nums[i])) { // 第一次出现该元素，保存
				nums[result++] = nums[i];
				map.put(nums[i], 1);
			} else if (map.containsKey(nums[i]) && map.get(nums[i]) < 2) { // 出现次数小于3，保存
				map.put(nums[i], map.get(nums[i]) + 1);
				nums[result++] = nums[i];
			}
		}
		return result;
	}
	
	
	/**
	 * 
	 * @param nums
	 * @return
	 */
	public static int removeDuplicates2(int[] nums) {
		int result = 0;
		List<Integer> list = new ArrayList<Integer>();
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < nums.length; i++) {
			if (!map.containsKey(nums[i])) { // 第一次出现该元素，保存
				list.add(nums[i]);
				map.put(nums[i], 1);
			} else if (map.containsKey(nums[i]) && map.get(nums[i]) < 2) { // 出现次数小于3，保存
				map.put(nums[i], map.get(nums[i]) + 1);
				list.add(nums[i]);
			}
		}
		result = list.size();
		for (int i = 0; i < list.size(); i++) {
			nums[i] = list.get(i);
		}
		return result;
	}
	
	/**
	 * 利用数组排序号的特点
	 * @param nums
	 * @return
	 */
	public static int removeDuplicates_Better(int[] nums) {
	    int i = 0; // 新数组元素下标
	    for (int n : nums){ // 遍历数组的每一个元素
	    	if (i < 2 || n > nums[i-2]){ // 前两个元素直接复制，之后的元素判断当前遍历的元素值是否比新数组前两位值大（利用数组排序的特点）
	    		nums[i++] = n;
	    	}
	    }
	    return i;
	}

}
