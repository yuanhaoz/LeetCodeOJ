package easy;
/** 
 * 414. Third Maximum Number   Add to List QuestionEditorial Solution  My Submissions
Total Accepted: 14480
Total Submissions: 54199
Difficulty: Easy
Contributors: ZengRed , 1337c0d3r
Given a non-empty array of integers, return the third maximum number in this array. 
If it does not exist, return the maximum number. The time complexity must be in O(n).

Example 1:
Input: [3, 2, 1]

Output: 1

Explanation: The third maximum is 1.
Example 2:
Input: [1, 2]

Output: 2

Explanation: The third maximum does not exist, so the maximum (2) is returned instead.
Example 3:
Input: [2, 2, 3, 1]

Output: 1

Explanation: Note that the third maximum here means the third maximum distinct number.
Both numbers with value 2 are both considered as second maximum.
 * 
 * @author 郑元浩
 * @date 2016年12月29日  上午9:03:53 
 */
public class ThirdMaximumNumber414 {

	public static void main(String[] args) {
//		int[] nums = {3, 2, 1, 4, 5, 6, 7, 8, 9};
//		System.out.println(thirdMax(nums));
//		int[] nums = {1, 1, 1};
//		System.out.println(thirdMax(nums));
//		int[] nums = {3, 1, 1};
//		System.out.println(thirdMax(nums));
//		int[] nums = {3, 2, 1};
//		System.out.println(thirdMax(nums));
//		int[] nums = {3, 2};
//		System.out.println(thirdMax(nums));
//		int[] nums = {3};
//		System.out.println(thirdMax(nums));
//		int[] nums = {2, 2, 3, 1};
//		System.out.println(thirdMax(nums));
//		int[] nums = {2, 2, 3, 2, 12};
//		System.out.println(thirdMax(nums));
		
		int[] nums = {1,2,-2147483648};
		System.out.println(thirdMax(nums));
		System.out.println(Integer.MIN_VALUE);
		System.out.println(Integer.MIN_VALUE + 1);
		System.out.println(Integer.MIN_VALUE - 1);
	}
	
	public static int thirdMax(int[] nums) {
		if (nums.length == 1) { // 长度为1，直接返回该元素
			return nums[0];
		} else if (nums.length == 2) { // 长度为2，返回其中比较大的元素
			return Math.max(nums[0], nums[1]);
		} else {
			int flag = 0;
			for (int i = 0; i < 3; i++) { // 对整个数组进行排序得到前三大的元素
				for (int j = i + 1; j < nums.length; j++) {
					if (nums[i] < nums[j]) { // 将最大的元素放在第一个位置并交换位置
						int temp = nums[i];
						nums[i] = nums[j];
						nums[j] = temp;
					} else if (nums[i] == nums[j]) {
						// 两个元素如果相同，则将后面那个相同的元素值设为最小值，并设置标志位的值为1，表示这个最小值是由于存在相同元素产生的
						nums[j] = Integer.MIN_VALUE;
						flag = 1;
					}
				}
			}
			if (nums[2] == Integer.MIN_VALUE && flag == 1) {
				return nums[0];
			} else {
				return nums[2];
			}
		}
		
    }
	

}
