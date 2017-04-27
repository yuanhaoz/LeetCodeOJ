package medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**  
 * 442. Find All Duplicates in an Array   Add to List QuestionEditorial Solution  My Submissions
Total Accepted: 9037
Total Submissions: 19229
Difficulty: Medium
Contributors: shen5630
Given an array of integers, 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and others appear once.

Find all the elements that appear twice in this array.

Could you do it without extra space and in O(n) runtime?

Example:
Input:
[4,3,2,7,8,2,3,1]

Output:
[2,3]
Subscribe to see which companies asked this question   
 *  
 * @author 郑元浩 
 * @date 2017年1月2日 下午9:03:36 
 */
public class FindAllDuplicatesinanArray442 {

	public static void main(String[] args) {
//		int[] nums = {4,3,2,7,8,2,3,1};
		int[] nums = {1,1};
		findDuplicates(nums);
	}
	
	/**
	 * 时间复杂度O(n)，有用到额外的空间
	 * @param nums
	 * @return
	 */
	public static List<Integer> findDuplicates2(int[] nums) {
		List<Integer> list = new ArrayList<Integer>();
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < nums.length; i++) {
			if (!map.keySet().contains(nums[i])) {
				map.put(nums[i], i);
			} else {
				list.add(nums[i]);
			}
		}
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
        return list;
    }
	
	// when find a number i, flip the number at position i-1 to negative. 
    // if the number at position i-1 is already negative, i is the number that occurs twice.
	// 该数组的数值大小都在[1, n]之间，有些元素出现两次，有些出现一次。
	// 思想是：对于数组每个元素值-1对应的下标值取反，如果该值小于0，说明再次修改该元素，存在重复元素
    public static List<Integer> findDuplicates(int[] nums) {
    	List<Integer> newList = new ArrayList<Integer>();     // creating a new List
        for(int i=0;i<nums.length;i++){  
           int index =Math.abs(nums[i]);             // Taking the absolute value to find index
           if(nums[index-1] >0){ 
                    nums[index-1] = - nums[index-1];
            }else{
                   // If it is not greater than 0 (i.e) negative then the number is a duplicate
                    newList.add(Math.abs(nums[i])); 
            }
        }
        return newList;
    }

}
