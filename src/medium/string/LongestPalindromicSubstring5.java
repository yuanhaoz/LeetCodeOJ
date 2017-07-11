package medium.string;

/**
 * 5. Longest Palindromic Substring
 * Given a string s, find the longest palindromic substring in s. 
 * You may assume that the maximum length of s is 1000.

Example:
Input: "babad"
Output: "bab"
Note: "aba" is also a valid answer.

Example:
Input: "cbbd"
Output: "bb"
 * @author 郑元浩
 * @date 2017年7月10日 上午9:38:03
 *
 */
public class LongestPalindromicSubstring5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LongestPalindromicSubstring5 l = new LongestPalindromicSubstring5();
		String str = "babad";
		System.out.println(l.longestPalindrome(str));
//		String str2 = "cbbd";
//		System.out.println(l.longestPalindrome(str2));
//		String str3 = "c";
//		System.out.println(l.longestPalindrome(str3));
//		String str4 = "abkfd";
//		System.out.println(l.longestPalindrome(str4));
	}
	
	
	
	private int lo = 0, maxLen = Integer.MIN_VALUE;
	
	public String longestPalindrome(String s) {
		int len = s.length();
		if (len < 2) {
			return s;
		}
		for (int i = 0; i < len - 1; i++) {
			extend(s, i, i);
			extend(s, i, i + 1);
		}
		System.out.println(lo + " " + maxLen);
		return s.substring(lo, maxLen + lo);
	}
	
	private void extend(String s, int j, int k) {
		while (j >= 0 && k < s.length() && s.charAt(j) == s.charAt(k)) {
			j--;
			k++;
		}
		if (maxLen < k - j - 1) {
			lo = j + 1;
			maxLen = k - j - 1;
		}
	}
	
	/**
	 * 两遍循环，效率低下
	 * @param s
	 * @return
	 */
	public static String longestPalindrome2(String s) {
		int maxLen = Integer.MIN_VALUE;
		String palindrome = "";
        int len = s.length();
        for (int i = 0; i < len - 1; i++) {
			for (int j = len - 1; j >= i + 1; j--) {
				String str = s.substring(i, j + 1);
				String strReverse = new StringBuffer(str).reverse().toString();
				if (str.equals(strReverse)) {
					if (j - i + 1 > maxLen) {
						maxLen = j - i + 1;
						palindrome = str;
						break;
					}
				}
			}
		}
        if (palindrome.equals("")) {
        	palindrome = s.substring(0, 1);
		}
		return palindrome;
    }

}
