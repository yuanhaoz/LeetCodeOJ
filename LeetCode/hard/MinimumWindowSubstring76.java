package hard;
/**  
 * 76. Minimum Window Substring   Add to List QuestionEditorial Solution  My Submissions
Total Accepted: 84448
Total Submissions: 356362
Difficulty: Hard
Contributors: Admin
Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).

For example,
S = "ADOBECODEBANC"
T = "ABC"
Minimum window is "BANC".

Note:
If there is no such window in S that covers all characters in T, return the empty string "".

If there are multiple such windows, you are guaranteed that there will always be only one unique minimum window in S.   
 *  
 * @author 郑元浩 
 * @date 2017年1月2日 下午8:40:04 
 */
public class MinimumWindowSubstring76 {

	public static void main(String[] args) {
		minWindow("ADOBECODEBANC", "ABC");
	}
	
	public static String minWindow(String s, String t) {
		int start = 0, size = Integer.MAX_VALUE;
		String win = "";
		int a[] = new int[t.length()];
		int b[] = new int[t.length()];
		for (int i = 0; i < a.length; i++) {
			a[i] = 1;
		}
		for (int i = 0; i < s.length(); i++) {
			if (t.contains(s.charAt(i)+"")) {
				win += s.charAt(i);
				a[t.indexOf(s.charAt(i))] = 0;
			}
			while(a == b){
				size = Math.min(size, win.length());
				win = win.substring(start++, win.length());
			}
		}
		return win;
    }
	
	

}
