package meidum;
/**  
 * 75. Sort Colors   Add to List QuestionEditorial Solution  My Submissions
Total Accepted: 134918
Total Submissions: 368312
Difficulty: Medium
Contributors: Admin
Given an array with n objects colored red, white or blue, sort them so that objects of the same color are adjacent, with the colors in the order red, white and blue.

Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.

Note:
You are not suppose to use the library's sort function for this problem.

click to show follow up.

Subscribe to see which companies asked this question   
 *  
 * @author 郑元浩 
 * @date 2017年1月5日 上午8:35:28 
 */
public class SortColors75 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {1, 2, 0, 0, 2, 1};
		sortColors(nums);
	}
	
	public static void sortColors(int[] nums) {
		int a = 0, b = 0;
        for (int i = 0; i < nums.length; i++) {
			if (nums[i] == 0) {
				a++;
			} else if (nums[i] == 1) {
				b++;
			}
		}
        for (int i = 0; i < a; i++) {
			nums[i] = 0;
		}
        for (int i = a; i < a + b; i++) {
			nums[i] = 1;
		}
        for (int i = a + b; i < nums.length; i++) {
			nums[i] = 2;
		}
        for (int i = 0; i < nums.length; i++) {
			System.out.print(nums[i] + " ");
		}
    }

}
