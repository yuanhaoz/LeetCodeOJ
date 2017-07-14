package easy.String;

import java.util.Stack;

/**
 *  
Add to List
20. Valid Parentheses
Given a string containing just the characters '(', ')', '{', '}', '[' and ']', 
determine if the input string is valid.

The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
 * @author 郑元浩
 * @date 2017年7月14日 上午9:54:50
 *
 */
public class ValidParentheses20 {

	public static void main(String[] args) {
		System.out.println(isValid("()"));
		System.out.println(isValid("()[]{}"));
		System.out.println(isValid("(["));
		System.out.println(isValid("([)]"));
		System.out.println(isValid("}("));
		System.out.println(isValid("[(({})}]"));
	}
	
	/**
	 * 利用栈来解决：如果是左符号则每次入栈，如果是右符号则每次出栈并且判断出栈元素和该右符号元素是否配对
	 * @param s
	 * @return
	 */
	public static boolean isValid(String s) {
		if (s == null || s.length() == 0 || s.length() % 2 == 1) {
			return false;
		}
		Stack<Character> stack = new Stack<Character>();
		for (int i = 0; i < s.length(); i++) {
			char temp = s.charAt(i);
			if (temp == '(' || temp == '[' || temp == '{') { // 左符号则每次入栈
				stack.push(s.charAt(i));
			} else {
				if (!stack.isEmpty()) { // 判断栈是否为空
					char popChar = stack.pop(); // 右符号则每次出栈
					if ((temp == ')' && popChar != '(') 
						|| (temp == ']' && popChar != '[') 
						|| (temp == '}' && popChar != '{')) { // 判断是否配对
						return false;
					}
				} else {  // 栈为空则表示右符号元素打头了
					return false;
				}
				
			}
		}
		if (!stack.isEmpty()) {
			return false;
		}
		return true;
	}

}
