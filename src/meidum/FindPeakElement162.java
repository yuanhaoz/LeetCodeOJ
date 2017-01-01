package meidum;
/**  
 * 162. Find Peak Element   Add to List QuestionEditorial Solution  My Submissions
Total Accepted: 94295
Total Submissions: 264108
Difficulty: Medium
Contributors: Admin
A peak element is an element that is greater than its neighbors.

Given an input array where num[i] ≠ num[i+1], find a peak element and return its index.

The array may contain multiple peaks, in that case return the index to any one of the peaks is fine.

You may imagine that num[-1] = num[n] = -∞.

For example, in array [1, 2, 3, 1], 3 is a peak element and your function should return the index number 2.

click to show spoilers.

Credits:
Special thanks to @ts for adding this problem and creating all test cases.

Subscribe to see which companies asked this question   
 *  
 * @author 郑元浩 
 * @date 2017年1月2日 下午6:09:06 
 */
public class FindPeakElement162 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int[] nums = {1};
		int[] nums = {1, 2, 3, 1};
		System.out.println(findPeakElement(nums));
		System.out.println(findPeakElement2(nums));
	}
	
	/**
	 * 线性查找：复杂度为O(N)
	 * 循环判断
	 * @param nums
	 * @return
	 */
	public static int findPeakElement(int[] nums) {
		int max = 0;
		if (nums.length == 1) {
			return 0;
		} else if (nums[0] > nums[1]) {
			return 0;
		} else if (nums[nums.length - 1] > nums[nums.length - 2]) {
			return nums.length - 1;
		} else {
			for (int i = 1; i < nums.length - 1; i++) {
				if (nums[i] > nums[i + 1] && nums[i] > nums[i - 1]) {
					max = i;
					break;
				}
			}
			return max;
		}
    }
	
	
	
	
	/**
	 * 二分查找：复杂度为log(N)
	 * This problem is similar to Local Minimum. And according to the given condition, num[i] != num[i+1], 
	 * there must exist a O(logN) solution. So we use binary search for this problem.

		If num[i-1] < num[i] > num[i+1], then num[i] is peak
		If num[i-1] < num[i] < num[i+1], then num[i+1...n-1] must contains a peak
		If num[i-1] > num[i] > num[i+1], then num[0...i-1] must contains a peak
		If num[i-1] > num[i] < num[i+1], then both sides have peak
		(n is num.length)
	 * @param num
	 * @return
	 */
	public static int findPeakElement2(int[] num) {    
	    return helper(num,0,num.length-1);
	}

	public static int helper(int[] num,int start,int end){
	    if(start == end){
	        return start;
	    }else if(start+1 == end){
	        if(num[start] > num[end]) return start;
	        return end;
	    }else{
	        
	        int m = (start+end)/2;
	        
	        if(num[m] > num[m-1] && num[m] > num[m+1]){

	            return m;

	        }else if(num[m-1] > num[m] && num[m] > num[m+1]){

	            return helper(num,start,m-1);

	        }else{

	            return helper(num,m+1,end);

	        }
	        
	    }
	}

}
