package easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**  
 * 350. Intersection of Two Arrays II   Add to List QuestionEditorial Solution  My Submissions
Total Accepted: 47366
Total Submissions: 108625
Difficulty: Easy
Contributors: Admin

Given two arrays, write a function to compute their intersection.

Example:
Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2, 2].

Note:
Each element in the result should appear as many times as it shows in both arrays.
The result can be in any order.
Follow up:
What if the given array is already sorted? How would you optimize your algorithm?
What if nums1's size is small compared to nums2's size? Which algorithm is better?
What if elements of nums2 are stored on disk, and the memory is limited such that you cannot load all elements 
into the memory at once?   
 *  
 * @author 郑元浩 
 * @date 2017年1月4日 上午10:20:53 
 */
public class IntersectionofTwoArraysII350 {

	public static void main(String[] args) {
		int[] nums1 = {1,2,2,1};
		int[] nums2 = {2,2};
//		int[] nums1 = {1, 2, 3};
//		int[] nums2 = {1, 1};
		intersect(nums1, nums2);
	}
	
	/**
	 * 1. 数组排序
	 * 2. 两个指针
	 * 3. 比较相同元素个数，取数量少的交集
	 * @param nums1
	 * @param nums2
	 * @return
	 */
	public static int[] intersect(int[] nums1, int[] nums2) {
		List<Integer> list = new ArrayList<Integer>();
		
		Arrays.sort(nums1); // 对数组排序
		Arrays.sort(nums2);
		int left1 = 0;
		int left2 = 0;
		while (left1 < nums1.length && left2 < nums2.length) {
			if (nums1[left1] == nums2[left2]) { // 相同的元素
				list.add(nums1[left1]);
				int count1 = 0;
				int count2 = 0;
				while (left1 + 1 < nums1.length && nums1[left1] == nums1[left1 + 1]) { // 判断num1该元素的个数
					left1++;
					count1++;
				}
				while (left2 + 1 < nums2.length && nums2[left2] == nums2[left2 + 1]) { // 判断num2该元素的个数
					left2++;
					count2++;
				}
				count2 = Math.min(count1, count2);
				while (count2-- > 0) { // 结果返回相同元素的交集
					list.add(nums1[left1]);
				}
				left1++;
				left2++;
			} else if (nums1[left1] < nums2[left2]) { // 不同移动相应的下标指针
				left1++;
			} else if (nums1[left1] > nums2[left2]) {
				left2++;
			}
		}
		
        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
        	result[i] = list.get(i);
        }
        for (int j = 0; j < result.length; j++) {
        	System.out.println(result[j]);
        }
        return result;
	}
	
	/**
	 * 1. HashMap存储，键值为对应元素出现的次数
	 * 2. 匹配到相同的元素且键值大于0，保存元素，设置键值-1
	 * @param nums1
	 * @param nums2
	 * @return
	 */
	public static int[] intersect2(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        ArrayList<Integer> result = new ArrayList<Integer>();
        for(int i = 0; i < nums1.length; i++)
        {
            if(map.containsKey(nums1[i])) map.put(nums1[i], map.get(nums1[i])+1);
            else map.put(nums1[i], 1);
        }
    
        for(int i = 0; i < nums2.length; i++)
        {
            if(map.containsKey(nums2[i]) && map.get(nums2[i]) > 0)
            {
                result.add(nums2[i]);
                map.put(nums2[i], map.get(nums2[i])-1);
            }
        }
    
       int[] r = new int[result.size()];
       for(int i = 0; i < result.size(); i++)
       {
           r[i] = result.get(i);
       }
    
       return r;
    }

}
