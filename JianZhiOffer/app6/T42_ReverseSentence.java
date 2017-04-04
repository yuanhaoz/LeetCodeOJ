package app6;
/**  
 * 面试题42：翻转单词顺序 VS 左旋转字符串
 * 题目一：输入一个英文句子，翻转句子中单词的顺序，单核单词内字符的顺序不变。为简单起见，标点符号和普通字母一样处理。
 * 例如输入字符串“I am a student.”，则输出“student. a am I”。
 * 思路：先对整个字符串翻转，然后在对每个单词翻转。
 * 
 * 题目二：字符串的左旋转操作是把字符串前面的若干个字符转移到字符串的尾部。请定义一个函数实现字符串左旋转操作的功能。
 * 比如输入字符串“abcdefg”和数字2，该函数将返回左旋转2位后得到的结果“cdefgab”。
 * 思路：先翻转左半部分字符，后翻转右半部分字符，最终翻转整个字符串。
 * 
 * 本题考点：
 * 考查知识迁移能力。当面试的时候遇到第二个问题，而之前我们做过“翻转句子中单词的顺序”这个题目，那么如果能够把多次翻转字符串
 * 的思路迁移过来，就能轻易地解决字符串左旋转的问题。
 * 考查对字符串的编程能力。
 *  
 * @author 郑元浩 
 * @date 2017年4月4日 上午10:11:12
 */
public class T42_ReverseSentence {

	public static void main(String[] args) {
		System.out.println(new String(reverseSentence("I am a student.".toCharArray())));
        System.out.println(new String(reverseSentence("Wonderful".toCharArray())));
        System.out.println(new String(reverseSentence("".toCharArray())));
        System.out.println(new String(reverseSentence("    ".toCharArray())));
        
        System.out.println("-------------------------");
        System.out.println(new String(leftRotateString("abcdefg".toCharArray(), 2)));
        System.out.println(new String(leftRotateString("abcdefg".toCharArray(), 1)));
        System.out.println(new String(leftRotateString("abcdefg".toCharArray(), 6)));
        System.out.println(new String(leftRotateString("abcdefg".toCharArray(), 7)));
        System.out.println(new String(leftRotateString("abcdefg".toCharArray(), 0)));
	}
	
	/**
	 * 交换str从start到end上每个字符，实现字符的反转
	 * @param str
	 * @param start
	 * @param end
	 */
	public static void reverse(char[] str, int start, int end) {
		if (str == null || str.length == 0 || start < 0 || end < 0) {
			return ;
		}
		while (start < end) {
			char temp = str[start];
			str[start] = str[end];
			str[end] = temp;
			start++;
			end--;
		}
	}
	
	/**
	 * 字符串反转
	 * @param str
	 * @return
	 */
	public static char[] reverseSentence(char[] str) {
		if (str == null || str.length == 0) {
			return str;
		}
		reverse(str, 0, str.length - 1); // 第一步翻转整个字符串
		
		int start = 0;
		int end = 0;
		while (start < str.length) {
			if (str[start] == ' ') { // 判断开头元素是不是空格
				start++;
				end++;
			} else if (end == str.length || str[end] == ' ') { // end位置上为空格则反转该子字符，并且重新设置start和end的值
				reverse(str, start, end - 1);
				end++;
				start = end;
			} else { // 否则一直是一个字符，end往前走
				end++;
			}
		}
		return str;
	}
	
	public static char[] leftRotateString(char[] str, int num) {
		if (str == null || str.length == 0 || num < 0) {
			return str;
		}
		
		reverse(str, 0, num - 1);
		reverse(str, num, str.length - 1);
		reverse(str, 0, str.length - 1);
		
		return str;
	}

}
