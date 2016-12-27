package easy;

import java.util.LinkedList;
import java.util.Queue;

/**  
 * 189. Rotate Array   Add to List QuestionEditorial Solution  My Submissions
Total Accepted: 104606
Total Submissions: 447276
Difficulty: Easy
Contributors: Admin
Rotate an array of n elements to the right by k steps.

For example, with n = 7 and k = 3, the array [1,2,3,4,5,6,7] is rotated to [5,6,7,1,2,3,4].

Note:
Try to come up as many solutions as you can, there are at least 3 different ways to solve this problem.   
 *  
 * @author 郑元浩 
 * @date 2016年12月30日 下午3:56:12 
 */
public class RotateArray189 {

	public static void main(String[] args) {
		int[] nums = {1,2,3,4,5,6,7};
		rotate(nums, 3);
//		int[] nums1 = {-1};
//		rotate(nums1, 2);
//		int[] nums1 = {-1,3};
//		rotate(nums1, 3);
	}
	
	public static void rotate(int[] nums, int k) {
		Queue<Integer> temp = new LinkedList<Integer>();
		for (int i = nums.length - 1; i >= 0; i--) {
			temp.add(nums[i]);
		}
		while (k > 0) {
			int max = temp.poll();
			System.out.println(max);
			temp.add(max);
			k--;
		}
		for (int i = nums.length - 1; i >= 0; i--) {
			nums[i] = temp.poll();
		}
//		for (int i = 0; i < nums.length; i++) {
//			System.out.print(nums[i] + " ");
//		}
	}
	
	
	public static void rotate2(int[] nums, int k) {
		while (k > 0) {
			int last = nums[nums.length - 1];
			for (int i = nums.length - 1; i > 0; i--) {
				nums[i] = nums[i - 1];
			}
			nums[0] = last;
			k--;
		}
		for (int i = 0; i < nums.length; i++) {
			System.out.print(nums[i] + " ");
		}
	}
	
	public void rotate3(int[] nums, int k) {
        int[] a = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            a[(i + k) % nums.length] = nums[i];
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] = a[i];
        }
    }
	
	public void rotate4(int[] nums, int k) {
        k %= nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }
    public void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

}
