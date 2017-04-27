package easy;

import java.util.HashMap;
import java.util.Map;

/**  
 * 169. Majority Element   Add to List QuestionEditorial Solution  My Submissions
Total Accepted: 163200
Total Submissions: 365377
Difficulty: Easy
Contributors: Admin

Given an array of size n, find the majority element. 
The majority element is the element that appears more than ⌊ n/2 ⌋ times.

You may assume that the array is non-empty and the majority element always exist in the array.

Credits:
Special thanks to @ts for adding this problem and creating all test cases.

Subscribe to see which companies asked this question   
 *  
 * @author 郑元浩 
 * @date 2016年12月30日 上午9:10:26 
 */
public class MajorityElement169 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {1,2,3,2,2,2};
		System.out.println(majorityElement(nums));
	}
	
	public static int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
			if (map.keySet().contains(nums[i])) {
				int a = map.get(nums[i]);
				a++;
				if (a > nums.length / 2) {
					return nums[i];
				}
				map.put(nums[i], a);
			} else {
				if (nums.length==1) {
					return nums[0];
				}
				map.put(nums[i], 1);
			}
		}
//        for (Entry<Integer,Integer> entry : map.entrySet()) {
//        	int time = entry.getValue();
//        	if (time > nums.length/2) {
//        		return entry.getKey();
//			}
//        }
        return 0;
    }

}
