package medium;
/**  
 * 35. Search Insert Position   Add to List QuestionEditorial Solution  My Submissions
Total Accepted: 137698
Total Submissions: 353904
Difficulty: Medium
Contributors: Admin

Given a sorted array and a target value, return the index if the target is found. 
If not, return the index where it would be if it were inserted in order.

You may assume no duplicates in the array.

Here are few examples.
[1,3,5,6], 5 → 2
[1,3,5,6], 2 → 1
[1,3,5,6], 7 → 4
[1,3,5,6], 0 → 0   
 *  
 * @author 郑元浩 
 * @date 2017年1月7日 下午2:25:47 
 */
public class SearchInsertPosition35 {

	public static void main(String[] args) {
		int[] nums = {1,3,5,6};
		int target = 8;
		System.out.println(searchInsert(nums, target));
	}
	
	/**
	 * 二分查找
	 * 元素大于最大的元素或者小于最小的元素都往数组的两个边界放
	 * 数的下标为>=该数的下标
	 * @param nums
	 * @param target
	 * @return
	 */
	public static int searchInsert(int[] nums, int target) {
		if (nums.length == 0) {
			return 0;
		}
        if (target <= nums[0]) {
			return 0;
		}
        if (target == nums[nums.length - 1]) {
			return nums.length - 1;
		}
        if (target > nums[nums.length - 1]) {
			return nums.length;
		}
		int l = 0, r = nums.length - 1;
		while (l < r) {
			int m = (l + r) / 2;
			if (nums[m] == target) {
				return m;
			} else if (nums[m] < target) {
				l = m + 1;
			} else {
				r = m;
			}
		}
		return l;
    }

}
