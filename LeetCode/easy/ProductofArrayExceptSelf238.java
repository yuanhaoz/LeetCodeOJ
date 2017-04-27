package easy;
/**  
 * 238. Product of Array Except Self
Description  Submission  Solutions  Add to List
Total Accepted: 82109
Total Submissions: 173056
Difficulty: Medium
Contributors: Admin

Given an array of n integers where n > 1, nums, return an array output such that output[i] is 
equal to the product of all the elements of nums except nums[i].

Solve it without division and in O(n).

For example, given [1,2,3,4], return [24,12,8,6].

Follow up:
Could you solve it with constant space complexity? (Note: The output array does not count as 
extra space for the purpose of space complexity analysis.)

Subscribe to see which companies asked this question.   
 *  
 * @author 郑元浩 
 * @date 2017年2月10日 下午3:15:56 
 */
public class ProductofArrayExceptSelf238 {

	/**
	 * 这道题给定我们一个数组，让我们返回一个新数组，对于每一个位置上的数是其他位置上数的乘积，并且限定了时间复杂度O(n)，并且不让我们用除法。
	 * 如果让用除法的话，那这道题就应该属于Easy，因为可以先遍历一遍数组求出所有数字之积，然后除以对应位置的上的数字。
	 * 但是这道题禁止我们使用除法，那么我们只能另辟蹊径。
	 * 
	 * 我们想，对于某一个数字，如果我们知道其前面所有数字的乘积，同时也知道后面所有的数乘积，那么二者相乘就是我们要的结果，
	 * 所以我们只要分别创建出这两个数组即可，分别从数组的两个方向遍历就可以分别创建出乘积累积数组。
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {1,2,3,4};
		productExceptSelf3(nums);
	}
	
	public static int[] productExceptSelf3(int[] nums) {
		int n = nums.length;
		int[] lArr = new int[n];
		int[] rArr = new int[n];
		lArr[0] = 1;
		rArr[n - 1] = 1;
		for (int i = 1; i < n; i++) {
			lArr[i] = lArr[i - 1] * nums[i - 1];
		}
		for (int i = n - 2; i >= 0; i--) {
			rArr[i] = rArr[i + 1] * nums[i + 1];
		}
		for (int i = 0; i < lArr.length; i++) {
			lArr[i] = lArr[i] * rArr[i];
		}
		return lArr;
	}
	
	/**
	 * 
	 * 我们可以对上面的方法进行空间上的优化，由于最终的结果都是要乘到结果res中，所以我们可以不用单独的数组来保存乘积，
	 * 而是直接累积到res中，我们先从前面遍历一遍，将乘积的累积存入res中，然后从后面开始遍历，用到一个临时变量right，
	 * 初始化为1，然后每次不断累积，最终得到正确结果，参见代码如下：
	 * 
	 * Thank @lycjava3 for this smart solution. To understand it easily, let me explain it with an example.

Given numbers [2, 3, 4, 5], regarding the third number 4, the product of array except 4 is 2*3*5 
which consists of two parts: left 2*3 and right 5. The product is left*right. We can get lefts and rights:

Numbers:     2    3    4     5
Lefts:            2  2*3 2*3*4
Rights:  3*4*5  4*5    5      
Let’s fill the empty with 1:

Numbers:     2    3    4     5
Lefts:       1    2  2*3 2*3*4
Rights:  3*4*5  4*5    5     1
We can calculate lefts and rights in 2 loops. The time complexity is O(n).

We store lefts in result array. If we allocate a new array for rights. The space complexity is O(n). 
To make it O(1), we just need to store it in a variable which is right in @lycjava3’s code.
	 * @param nums
	 * @return
	 */
	public static int[] productExceptSelf(int[] nums) {
		int n = nums.length;
		int[] result = new int[n];
		result[0] = 1;
        for (int i = 1; i < n; i++) {
        	result[i] = result[i - 1] * nums[i - 1];
		}
        int right = 1;
        for (int i = n - 1; i >= 0; i--) {
			result[i] *= right;
			right *= nums[i];
		}
        return result;
	}
	
	/**
	 * 使用除法，时间复杂度为O(n)
	 * @param nums
	 * @return
	 */
	public static int[] productExceptSelf2(int[] nums) {
		int all = 1;
        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
			all = all * nums[i];
		}
        for (int i = 0; i < result.length; i++) {
			result[i] = all/nums[i];
			System.out.println(result[i]);
		}
        return result;
    }

}
