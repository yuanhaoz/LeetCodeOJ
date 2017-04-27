package easy;

/**  
 * 26. Remove Duplicates from Sorted Array   Add to List QuestionEditorial Solution  My Submissions
Total Accepted: 184235
Total Submissions: 523424
Difficulty: Easy
Contributors: Admin
Given a sorted array(已排序的数组), remove the duplicates in place such that each element appear only 
once and return the new length.

Do not allocate extra space for another array, you must do this in place with constant memory.

For example,
Given input array nums = [1,1,2],

Your function should return length = 2, with the first two elements of nums being 1 and 2 respectively. 
It doesn't matter what you leave beyond the new length.  
 *  
 *  要点：利用有序数组的特点
 *  1. 两个指针
 *  2. 将不同的元素往前移动，后面的元素不用管
 *  
 * @author 郑元浩 
 * @date 2016年12月27日
 */

public class RemoveDuplicatesfromSortedArray26 {

	public static void main(String[] args) {
		int[] nums = {};
//		int[] nums = {4};
//		int[] nums = {4, 5};
//		int[] nums = {1, 1};
//		int[] nums = {1, 1, 1};
//		int[] nums = {1, 1, 6};
//		int[] nums = {1, 1, 1, 1, 2, 2, 2, 2, 3, 5, 6};
//		int[] nums = {1, 1, 1, 2};
//		int[] nums = {1, 1, 2, 3, 4, 5};
		removeDuplicates(nums);
//		removeDuplicates2(nums);
	}
	
	public static int removeDuplicates(int[] nums) {
		if(nums.length == 0){
			return 0;
		}
		int i = 0;
		for (int j = 1; j < nums.length; j++) {
			if (nums[j] != nums[i]) {
				i++;
				nums[i] = nums[j];
			}
		}
		for (int j = 0; j < nums.length; j++) {
			System.out.print(nums[j] + " ");
		}
		System.out.println();
		System.out.println(i+1);
		return i + 1;
    }
	
	public static int removeDuplicates2(int[] nums) {
		
		int tag = nums.length - 1;
		int temp;
		for (int i = 0; i < nums.length - 1; i++) {
//			System.out.println("第" + i + "个元素");
			for (int j = i + 1; j <= tag; j++) {
				if (nums[j] == nums[i]) {
					while (nums[j] == nums[tag] && tag > j) {
						tag--;
					}
					temp = nums[tag];
					nums[tag] = nums[j];
					nums[j] = temp;
					tag--;
				}
			}
		}
		System.out.println(tag+1);
		for (int m = 0; m < nums.length; m++) {
			System.out.print(nums[m] + " ");
		}
		return tag + 1;
		
    }

}
