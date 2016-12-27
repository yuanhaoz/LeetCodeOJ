package easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/**  
 * 229. Majority Element II   Add to List QuestionEditorial Solution  My Submissions
Total Accepted: 44601
Total Submissions: 161371
Difficulty: Medium
Contributors: Admin
Given an integer array of size n, find all elements that appear more than ⌊ n/3 ⌋ times.
 The algorithm should run in linear time and in O(1) space.   
 *  
 * @author 郑元浩 
 * 
 * @date 2016年12月30日 上午9:33:21 
 */
public class MajorityElementII229 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static List<Integer> majorityElement(int[] nums) {
		List<Integer> list = new ArrayList<Integer>();
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
			if (map.keySet().contains(nums[i])) {
				int a = map.get(nums[i]);
				a++;
				map.put(nums[i], a);
			} else {
				map.put(nums[i], 1);
			}
		}
        for (Entry<Integer,Integer> entry : map.entrySet()) {
        	int time = entry.getValue();
        	if (time > nums.length/3) {
        		list.add(entry.getKey());
			}
        }
        return list;
    }

}
