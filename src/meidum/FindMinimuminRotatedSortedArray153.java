package meidum;

/** 
 * 
 * 153. Find Minimum in Rotated Sorted Array   Add to List QuestionEditorial Solution  My Submissions
Total Accepted: 125510
Total Submissions: 326092
Difficulty: Medium
Contributors: Admin
Suppose a sorted array is rotated at some pivot unknown to you beforehand.

(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

Find the minimum element.

You may assume no duplicate exists in the array.
 * 
 * @author 郑元浩
 * @date 2016年12月28日  上午9:16:58  
 */
public class FindMinimuminRotatedSortedArray153 {

	public static void main(String[] args) {
		int[] nums = {0,1,2,3,4,5,6};
		findMin(nums);
		int[] nums2 = {4,5,6,0,1,2,3};
		findMin(nums2);
	}
	
	public static int findMin(int[] nums){
		int start = 0;
		int end = nums.length - 1;
		int middle;
		while (start < end) {
			/**
			 * 每次循环首先判断头元素是否小于尾元素，如果是，说明这段数字都是排序好的
			 */
			if (nums[start] < nums[end]) {
				return nums[start];
			}
			/**
			 * 二分搜索
			 */
			middle = (start + end) / 2;
			if (nums[start] <= nums[middle]) {
				start = middle + 1;
			} else {
				end = middle;
			}
		}
		System.out.println(nums[start]);
		return nums[start];
		
	}
	
	public static int findMin2(int[] nums) {
        int min = 99999999;
		for (int i = 0; i < nums.length; i++) {
			if (min > nums[i]) {
				min = nums[i];
			}
		}
		System.out.println("min is : " + min);
		return min;
    }

	public static int findMin3(int[] nums) {
		if (nums.length == 0) {
			return 0;
		}
	    int i = 0;
	    while (i < nums.length - 1 && nums[i] < nums[i + 1]) {
	    	i++;
	    }
	    if (i == nums.length - 1) {
			return nums[0];
		}
		System.out.println("min is : " + nums[i + 1]);
		return nums[i + 1];
	}

}
