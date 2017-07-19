package math;

/**
 *  
9. Palindrome Number

Determine whether an integer is a palindrome. Do this without extra space.

click to show spoilers.

Some hints:
Could negative integers be palindromes? (ie, -1)

If you are thinking of converting the integer to string, note the restriction of using extra space.

You could also try reversing an integer. However, if you have solved the problem "Reverse Integer", you know that the reversed integer might overflow. How would you handle such case?

There is a more generic way of solving this problem.
 * @author 郑元浩
 * @date 2017年7月17日 上午10:09:14
 *
 */
public class PalindromeNumber9 {

	public static void main(String[] args) {
		System.out.println(isPalindrome(123));
		System.out.println(isPalindrome(121));
		System.out.println(isPalindrome(-101));
		System.out.println(isPalindrome(100));
		System.out.println(isPalindrome(1212121129));
	}
	
	/**
	 * 计算一半的倒数是否等于另外一半，如果等于说明是回文数，否则不是回文数。
	 * 边界情况：负数不是回文数，最后一位是0的也不是回文数，考虑数组长度是奇数和偶数的情况
	 * @param x
	 * @return
	 */
	public static boolean isPalindrome(int x) {
		// 小于0，最后一位为0都不是回文数
        if (x < 0 || (x != 0 && x % 10 == 0)) {
			return false;
		}
        int result = 0;
        while (x > result) { // 循环条件是原来的是大于正在变大的数
			result = result * 10 + x % 10;
			x = x /10;
		}
        // 比较一半，返回比较结果是否相等
		return (x == result || x == result / 10);
    }

}
