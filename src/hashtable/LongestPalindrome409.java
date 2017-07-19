package hashtable;

import java.util.HashMap;
import java.util.Map;

public class LongestPalindrome409 {

	public static void main(String[] args) {
		System.out.println(longestPalindrome("abccccdd"));
		System.out.println(longestPalindrome("abcccdd"));
		System.out.println(longestPalindrome("abcd"));
		System.out.println(longestPalindrome("abccd"));
		System.out.println(longestPalindrome(""));
	}
	
	public static int longestPalindrome(String s) {
		int result = 0;
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        for (int i = 0; i < s.length(); i++) {
			if (!map.containsKey(s.charAt(i))) {
				map.put(s.charAt(i), 1);
			} else {
				map.put(s.charAt(i), map.get(s.charAt(i)) + 1);
			}
		}
        boolean flag = false; // 标志位，表示是否存在单一的元素可以作为中间的元素
        for (Character character : map.keySet()) {
        	int count = map.get(character);
        	if (count > 1 && count % 2 == 0) { // 相同元素的个数为偶数直接相加
				result += count;
			} else if (count > 1 && count % 2 == 1) { // 相同元素的个数为奇数减少1相加，并且修改标志位
				result += count - 1;
				flag = true;
			} else { // 说明存在单个元素，则修改标志位
				flag = true;
			}
		}
        if (flag) { // 奇数个相同的或者不存在相同的元素
			result++;
		}
        return result;
    }

}
