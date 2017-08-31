package dynamicProgramming;

/**
 * 303. Range Sum Query - Immutable
DescriptionHintsSubmissionsDiscussSolution
Discuss Pick One
Given an integer array nums, find the sum of the elements between indices i and j (i ≤ j), inclusive.

Example:
Given nums = [-2, 0, 3, -5, 2, -1]

sumRange(0, 2) -> 1
sumRange(2, 5) -> -1
sumRange(0, 5) -> -3
Note:
You may assume that the array does not change.
There are many calls to sumRange function.
 * @author 郑元浩
 * @date 2017年8月30日 下午5:28:58
 *
 */
public class RangeSumQuery303 {

	int[] nums;
	
	/**
	 * 构造函数：更新数组元素中每个位置上的值为前面所有元素的和
	 * @param nums
	 */
	public RangeSumQuery303(int[] nums) {
        for (int i = 1; i < nums.length; i++) { // 动态规划的思想
			nums[i] += nums[i - 1];
		}
        this.nums = nums;
    }
    
	/**
	 * 求数组在i到j之间的元素和
	 * @param i
	 * @param j
	 * @return
	 */
    public int sumRange(int i, int j) {
        if (i > 0) {
			return nums[j] - nums[i - 1];
		} else {
			return nums[j];
		}
    }
	
}
