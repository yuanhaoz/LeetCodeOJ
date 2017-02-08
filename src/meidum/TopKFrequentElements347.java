package meidum;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**  
 * 347. Top K Frequent Elements   Add to List QuestionEditorial Solution  My Submissions
Total Accepted: 46554
Total Submissions: 100797
Difficulty: Medium
Contributors: Admin
Given a non-empty array of integers, return the k most frequent elements.

For example,
Given [1,1,1,2,2,3] and k = 2, return [1,2].

Note: 
You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
Your algorithm's time complexity must be better than O(n log n), where n is the array's size.   
 *  
 * @author 郑元浩 
 * @date 2017年1月18日 上午10:33:13 
 */
public class TopKFrequentElements347 {

	public static void main(String[] args) {
		int[] nums = {1,1,1,2,2,3};
		int k = 2;
		topKFrequent(nums, k);
	}
	
	public static List<Integer> topKFrequent(int[] nums, int k) {
		// 先保存数字及其出现次数的对应关系到map中
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for(int num : nums){
			if (map.containsKey(num)) {
				map.put(num, map.get(num) + 1);
			} else {
				map.put(num, 1);
			}
		}
		// 设置一个list的数组，第i行表示出现第几次
		@SuppressWarnings("unchecked")
		List<Integer>[] bucket = new List[nums.length + 1]; // 创建一个list类型的数组，数组长度为s长度+1，数组中的每一个元素是一个list
		for(int key : map.keySet()){
			int frequency = map.get(key);
			if (bucket[frequency] == null) {
				bucket[frequency] = new ArrayList<Integer>();
			}
			bucket[frequency].add(key);
		}
		// 从后往前遍历数组，后面的元素出现的次数较多，可以拼接为待返回的数据
		List<Integer> list = new ArrayList<Integer>();
		for (int i = bucket.length - 1; i >= 0; i--) {
			if (bucket[i] != null) {
				for(Integer num : bucket[i]){
					if(k > 0){
						list.add(num);
						k--;
					}
				}
			}
		}
//		// 打印信息
//		for (int i = 0; i < list.size(); i++) {
//			System.out.print(list.get(i) + " ");
//		}
		return list;
    }

}
