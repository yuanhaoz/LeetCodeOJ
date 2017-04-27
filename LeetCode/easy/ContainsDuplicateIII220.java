package easy;

/**  
 * 220. Contains Duplicate III   Add to List QuestionEditorial Solution  My Submissions
Total Accepted: 44208
Total Submissions: 226287
Difficulty: Medium
Contributors: Admin

Given an array of integers, find out whether there are two distinct indices i and j in the array such that 
the difference between nums[i] and nums[j] is at most t and the difference between i and j is at most k. 
 *  
 * @author 郑元浩 
 * @date 2016年12月28日 下午8:20:09 
 */
public class ContainsDuplicateIII220 {

	public static void main(String[] args) {
//		int[] nums = {0,10,20,30,40,50,100};
//		int[] nums = {0,1,2,3,4,5,6};
//		int[] nums = {-1, -1};
//		int[] nums = {-1, -1, -1};
//		int[] nums = {4, 2};
//		int[] nums = {-5, 2147483647};
		int[] nums = {2147483647, -5};
		System.out.println(containsNearbyAlmostDuplicate2(nums, 10000, 0));
	}
	
	/**
	 * 不再使用HashMap，而是先根据条件两个数的下标不大于k判断两个数的范围
	 * 然后比较两个数的差是不是不大于t
	 * @param nums
	 * @param k
	 * @param t
	 * @return
	 */
	public static boolean containsNearbyAlmostDuplicate2(int[] nums, int k, int t) {
        boolean flag = false;
        for (int i = 0; i < nums.length - 1; i++) {
        	int end = i + k + 1;
        	if (i + k + 1 > nums.length) {
				end = nums.length;
			}
        	for (int j = i + 1; j < end; j++) {
        		System.out.println(Math.abs(nums[j] - nums[i]));
        		int dis = Math.max(nums[i], nums[j]) - t;
				if (Math.min(nums[i], nums[j]) >= dis) {
					return true;
				}
			}
		}
        return flag;
    }

}
