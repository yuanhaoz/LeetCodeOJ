package twoPointer;

/**
 * 125. Valid Palindrome
Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

For example,
"A man, a plan, a canal: Panama" is a palindrome.
"race a car" is not a palindrome.

Note:
Have you consider that the string might be empty? This is a good question to ask during an interview.

For the purpose of this problem, we define empty string as valid palindrome.
 * @author 郑元浩
 * @date 2017年7月18日 上午10:01:08
 *
 */
public class ValidPalindrome125 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String string = "azAZ";
		for (int i = 0; i < string.length(); i++) {
			System.out.println(string.charAt(i)-'a');
		}
		System.out.println(isPalindrome(string));
		System.out.println(isPalindrome("abba"));
		System.out.println(isPalindrome(""));
		System.out.println(isPalindrome(".,"));
		System.out.println(isPalindrome("aA"));
		System.out.println(isPalindrome("0P"));
	}
	
	/**
	 * 从字符串的两端使用两个指针开始比较，碰到不是数字或者字母的就移动指针，否则前后比较。相同则同时向前或者向后移动，否则返回错误。
	 * @param s
	 * @return
	 */
	public static boolean isPalindrome(String s) {
		String temp = s.toLowerCase();
        if (temp == null || temp.length() == 0 || temp.length() == 1) {
        	return true;
		}
		int left = 0;
		int right = temp.length() - 1;
		while (left <= right) {
			if (!Character.isLetterOrDigit(temp.charAt(left))) {
				left++;
			} else if (!Character.isLetterOrDigit(temp.charAt(right))) {
				right--;
			} else {
				if (temp.charAt(left) != temp.charAt(right)) {
					return false;
				}
				left++;
				right--;
			}
		}
		return true;
    }

}
