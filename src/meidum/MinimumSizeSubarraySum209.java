package meidum;
/**  
 * 209. Minimum Size Subarray Sum   Add to List QuestionEditorial Solution  My Submissions
Total Accepted: 64135
Total Submissions: 225564
Difficulty: Medium
Contributors: Admin
Given an array of n positive integers and a positive integer s, 
find the minimal length of a subarray of which the sum ≥ s. If there isn't one, return 0 instead.

For example, given the array [2,3,1,2,4,3] and s = 7,
the subarray [4,3] has the minimal length under the problem constraint.

click to show more practice.

Credits:
Special thanks to @Freezen for adding this problem and creating all test cases.

Subscribe to see which companies asked this question   
 *  
 * @author 郑元浩 
 * @date 2017年1月2日 下午7:25:02 
 */
public class MinimumSizeSubarraySum209 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int nums[] = {1,4,4};
		int s = 4;
//		int nums[] = {};
//		int s = 100;
//		int nums[] = {2,3,1,2,4,3};
//		int s = 7;
//		int nums[] = {1,2,3,4,5};
//		int s = 11;
		System.out.println(minSubArrayLen(s, nums));
	}
	
	/**
	 * 二个指针
	 * @param s
	 * @param nums
	 * @return
	 */
	public static int minSubArrayLen(int s, int[] nums) {
		int n = nums.length, start = 0, sum = 0, minlen = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) { 
            sum += nums[i]; 
            while (sum >= s) {
                minlen = Math.min(minlen, i - start + 1);
                sum -= nums[start++];
            }
        }
        return minlen == Integer.MAX_VALUE ? 0 : minlen;
	}
	
	/**
	 * 线性查找，时间复杂度高，测试不通过
	 * @param s
	 * @param nums
	 * @return
	 */
	public static int minSubArrayLen2(int s, int[] nums) {
        int min = nums.length + 1;
        for (int i = 0; i < nums.length - 1; i++) {
        	if (nums[i] >= s) { // 元素直接为需要相加的元素
				return 1;
			} else {
				int sum = nums[i];
				int j = i + 1;
				while (j < nums.length && sum <= s) {
					sum += nums[j];
					if (sum >= s) {
						min = Math.min(min, j-i+1);
						break;
					}
					j++;
				}
			}
		}
        if (min == nums.length + 1) {
			return 0;
		}
        return min;
    }

}
