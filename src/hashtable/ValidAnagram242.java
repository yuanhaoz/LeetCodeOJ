package hashtable;

import java.util.Arrays;

/**
 * 242. Valid Anagram
Given two strings s and t, write a function to determine if t is an anagram of s.

For example,
s = "anagram", t = "nagaram", return true.
s = "rat", t = "car", return false.

Note:
You may assume the string contains only lowercase alphabets.

Follow up:
What if the inputs contain unicode characters? How would you adapt your solution to such case?
 * @author 郑元浩
 * @date 2017年7月14日 上午9:47:08
 *
 */
public class ValidAnagram242 {

	public static void main(String[] args) {
		System.out.println(isAnagram("anagram", "nagaram"));
		System.out.println(isAnagram("rat", "car"));
	}
	
	public static boolean isAnagram(String s, String t) {
        char[] sArray = s.toCharArray();
        Arrays.sort(sArray);
        String s1 = String.valueOf(sArray);
        char[] tArray = t.toCharArray();
        Arrays.sort(tArray);
        String s2 = String.valueOf(tArray);
        if (s1.equals(s2)) {
			return true;
		}
		return false;
    }

}
