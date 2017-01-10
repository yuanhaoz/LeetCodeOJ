package easy;

import java.util.HashMap;

/** 
 * 136. Single Number   Add to List QuestionEditorial Solution  My Submissions
Total Accepted: 184668
Total Submissions: 349944
Difficulty: Easy
Contributors: Admin
Given an array of integers, every element appears twice except for one. Find that single one.

Note:
Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
 * 
 * @author 郑元浩
 * @date 2017年1月10日  下午11:55:29 
 */
public class SingleNumber136 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {1,2,2,3,3};
//		int[] nums = {};
		System.out.println(singleNumber(nums));
		System.out.println(singleNumber2(nums));
	}
	
	/**
	 * we use bitwise XOR to solve this problem :

		first , we have to know the bitwise XOR in java
		
		0 ^ N = N
		N ^ N = 0
		So..... if N is the single number
		
		N1 ^ N1 ^ N2 ^ N2 ^..............^ Nx ^ Nx ^ N
		
		= (N1^N1) ^ (N2^N2) ^..............^ (Nx^Nx) ^ N
		
		= 0 ^ 0 ^ ..........^ 0 ^ N
		
		= N
		
		异或运算，0和N异或等于N，N与N为0。由于有偶数个相同的元素，因此整个数组最终的异或结果肯定为我们的结果
	 * @param nums
	 * @return
	 */
	public static int singleNumber(int[] nums){
		int ans =0;
	    
	    int len = nums.length;
	    for(int i=0;i!=len;i++)
	        ans ^= nums[i];
	    
	    return ans;

	}
	
	/**
	 * hashmap：低效
	 * @param nums
	 * @return
	 */
	public static int singleNumber2(int[] nums) {
		HashMap<Integer,Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
			if (!map.keySet().contains(nums[i])) {
				map.put(nums[i], 1);
			} else if (map.get(nums[i]) == 1) {
				map.put(nums[i], 2);
			}
		}
        for(Integer a : map.keySet()){
        	int t = map.get(a);
        	if (t == 1) {
				return a;
			}
        }
        return 0;
    }
}
