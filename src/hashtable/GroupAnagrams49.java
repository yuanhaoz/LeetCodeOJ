package hashtable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 49. Group Anagrams
Given an array of strings, group anagrams together.

For example, given: ["eat", "tea", "tan", "ate", "nat", "bat"], 
Return:

[
  ["ate", "eat","tea"],
  ["nat","tan"],
  ["bat"]
]
Note: All inputs will be in lower-case.
 * @author 郑元浩
 * @date 2017年7月13日 上午9:49:14
 *
 */
public class GroupAnagrams49 {

	public static void main(String[] args) {
		String[] strs = {"eat","tea","tan","ate","nat","bat"};
		groupAnagrams(strs);
	}
	
	/**
	 * 使用 Hashmap 实现，键是排序好的字符串原型，值是其变种的集合list
	 * @param strs
	 * @return
	 */
	public static List<List<String>> groupAnagrams(String[] strs) {
		if (strs == null || strs.length == 0) return new ArrayList<List<String>>();
        Map<String, List<String>> map = new HashMap<String, List<String>>(); // 排序好的字符串原型，和其变种的键值对的映射集合
        for (int i = 0; i < strs.length; i++) {
        	// 得到排序字符串原型
			char[] charArr = strs[i].toCharArray();
			Arrays.sort(charArr);
			String keyString = String.valueOf(charArr);
			// 将其添加到对应的map映射中
			if (!map.containsKey(keyString)) {
				map.put(keyString, new ArrayList<String>());
			}
			map.get(keyString).add(strs[i]);
		}
        System.out.println(new ArrayList<List<String>>(map.values()));
        return new ArrayList<List<String>>(map.values());
    }

}
