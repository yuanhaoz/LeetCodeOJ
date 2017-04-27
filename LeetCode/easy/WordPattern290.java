package easy;

import java.util.HashMap;
import java.util.HashSet;

/**  
 * 290. Word Pattern   Add to List QuestionEditorial Solution  My Submissions
Total Accepted: 63682
Total Submissions: 198582
Difficulty: Easy
Contributors: Admin
Given a pattern and a string str, find if str follows the same pattern.

Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word in str.

Examples:
pattern = "abba", str = "dog cat cat dog" should return true.
pattern = "abba", str = "dog cat cat fish" should return false.
pattern = "aaaa", str = "dog cat cat dog" should return false.
pattern = "abba", str = "dog dog dog dog" should return false.
Notes:
You may assume pattern contains only lowercase letters, and str contains lowercase letters separated by a single space.   
 *  
 * @author 郑元浩 
 * @date 2017年1月16日 上午10:37:25 
 */
public class WordPattern290 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String pattern = "abba";
		String str = "dog cat cat dog";
		System.out.println(wordPattern(pattern, str));
		
		pattern = "abba";
		str = "dog cat cat fish";
		System.out.println(wordPattern(pattern, str));
		
		pattern = "aaaa";
		str = "dog cat cat dog";
		System.out.println(wordPattern(pattern, str));
		
		pattern = "abba";
		str = "dog dog dog dog";
		System.out.println(wordPattern(pattern, str));
		
		pattern = "aba";
		str = "dog cat dog dog";
		System.out.println(wordPattern(pattern, str));

	}
	
	/**
	 * 
	 * @param pattern
	 * @param str
	 * @return
	 */
	public static boolean wordPattern(String pattern, String str) {
		HashMap<Character, String> map = new HashMap<Character, String>();
		String[] arrayStr = str.split(" ");
		if (arrayStr.length != pattern.length()) {  // 长度必须相同
			return false;
		}
		for (int i = 0; i < arrayStr.length; i++) { // 将两者对应关系存储到map中进行对比
			if (map.keySet().contains(pattern.charAt(i))) {
				if (!map.get(pattern.charAt(i)).equals(arrayStr[i])) { // 判断相同pattern元素对应的值是否相同
					return false;
				}
			} else {
				map.put(pattern.charAt(i), arrayStr[i]);
			}
		}
		HashSet<String> set = new HashSet<String>(); // 判断不同pattern元素对应的值是否不相同
		for (Character ch : map.keySet()) {
			if (!set.add(map.get(ch))) {
				return false;
			}
		}
		return true;
        
    }

}
