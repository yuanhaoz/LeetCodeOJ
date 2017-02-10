package medium;
/** 
 * 154. Find Minimum in Rotated Sorted Array II   Add to List QuestionEditorial Solution  My Submissions
Total Accepted: 67193
Total Submissions: 186301
Difficulty: Hard
Contributors: Admin
Follow up for "Find Minimum in Rotated Sorted Array":
What if duplicates are allowed?

Would this affect the run-time complexity? How and why?
Suppose a sorted array is rotated at some pivot unknown to you beforehand.

(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

Find the minimum element.

The array may contain duplicates.
 * 
 * @author 郑元浩
 * @date 2016年12月28日  上午10:07:21 
 */
public class FindMinimuminRotatedSortedArrayII154 {

	public static void main(String[] args) {
//		int[] nums = {0,1,2,3,4,4,5,6};
//		findMin(nums);
//		findMin2(nums);
//		findMin3(nums);
		
//		int[] nums2 = {4,5,6,0,1,2,3};
//		findMin(nums2);
//		findMin2(nums2);
//		findMin3(nums2);
		
//		int[] nums2 = {1};
//		findMin(nums2);
//		findMin2(nums2);
//		findMin3(nums2);
		
//		int[] nums2 = {1,1,1};
//		findMin(nums2);
//		findMin2(nums2);
//		findMin3(nums2);
		
//		int[] nums2 = {1,2,2,2,2,0};
//		findMin(nums2);
//		findMin2(nums2);
//		findMin3(nums2);
		
//		int[] nums2 = {3, 1};
//		findMin(nums2);
//		findMin2(nums2);
//		findMin3(nums2);
		
		int[] nums2 = {1, 3, 3};
		findMin(nums2);
		findMin2(nums2);
		findMin3(nums2);
		
//		int[] nums2 = {3, 3, 1};
//		findMin(nums2);
//		findMin2(nums2);
//		findMin3(nums2);
		
//		int[] nums2 = {1, 2, 1};
//		findMin(nums2);
//		findMin2(nums2);
//		findMin3(nums2);
		
//		int[] nums2 = {3, 3, 3, 1};
//		findMin(nums2);
//		findMin2(nums2);
//		findMin3(nums2);
		
//		int[] nums2 = {3, 3, 3, 3, 1};
//		findMin(nums2);
//		findMin2(nums2);
//		findMin3(nums2);
		
//		int[] nums2 = {3, 1, 1};
//		findMin(nums2);
//		findMin2(nums2);
//		findMin3(nums2);
		
//		int[] nums2 = {10,1,10,10,10,10};
//		findMin(nums2);
//		findMin2(nums2);
//		findMin3(nums2);
		
//		int[] nums2 = {3,0,1,2,3,3,3,3};
//		findMin(nums2);
//		findMin2(nums2);
//		findMin3(nums2);
	}
	
	
	public static int findMin(int[] nums){
		int start = 0;
		int end = nums.length - 1;
		int middle = 0;
		while (start < end) {
			/**
			 * 二分搜索
			 */
			middle = (end + start) / 2;
			if (nums[end] < nums[middle]) {
				start = middle + 1;
			} else if (nums[end] > nums[middle]) {
				end = middle;
			} else { // 当nums[start]和nums[middle]相同时，尾下标减1即可（最后元素连续相同，移动end指针向前）
				if (nums[start] == nums[middle]) {
					start++;
					end--;
				} else {
					end = middle;
				}
			}
		}
		
		System.out.println(nums[end]);
		return nums[end];
		
	}
	
	public static int findMin4(int[] nums){
		int start = 0;
		int end = nums.length - 1;
		int middle = 0;
		
		/**
		 * 前几个元素一直连续相同时，start一直往前移动到最后一个这种元素
		 */
		if (nums.length > 2 ) {
			while (nums[start] == nums[start + 1] && start < end - 1) {
				start++;
			}
		}
		
		while (start < end) {
			/**
			 * 每次循环首先判断头元素是否小于尾元素，如果是，说明这段数字都是排序好的
			 */
			if (nums[start] < nums[end]) {
				System.out.println(nums[start]);
				return nums[start];
			}
			/**
			 * 只有两个元素时，返回小的那个
			 */
			if (end - start == 1) {
				System.out.println(Math.min(nums[start], nums[end]));
				return Math.min(nums[start], nums[end]);
			}
			
			/**
			 * 二分搜索
			 */
			middle = start + (end - start) / 2;
			if (nums[start] < nums[middle]) {
				start = middle + 1;
			} else if (nums[start] > nums[middle]) {
				end = middle;
			} else { // 当nums[start]和nums[middle]相同时，尾下标减1即可（最后元素连续相同，移动end指针向前）
				end--;
			}
			
			/**
			 * 前几个元素一直连续相同时，移动start指针向前
			 */
			if (end - start > 1) { // 至少有三个元素时，进行比较移动
				while (nums[start] == nums[start + 1] && start < end - 1) {
					start++;
				}
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
			System.out.println("min is : " + 0);
			return 0;
		}
	    int i = 0;
	    while (i < nums.length - 1 && nums[i] <= nums[i + 1]) {
	    	i++;
	    }
	    if (i == nums.length - 1) {
	    	System.out.println("min is : " + nums[0]);
			return nums[0];
		}
		System.out.println("min is : " + nums[i + 1]);
		return nums[i + 1];
	}

}
