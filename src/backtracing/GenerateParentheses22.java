package backtracing;

import java.util.ArrayList;
import java.util.List;

/**
 * 22. Generate Parentheses
 * 
Given n pairs of parentheses, write a function to generate all 
combinations of well-formed parentheses.

For example, given n = 3, a solution set is:

[
  "((()))",
  "(()())",
  "(())()",
  "()(())",
  "()()()"
]
 * @author 郑元浩
 * @date 2017年7月16日 下午7:38:20
 *
 */
public class GenerateParentheses22 {

	public static void main(String[] args) {
		List<String> list = generateParenthesis(3);
		System.out.println(list.size());
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i).toString());
		}
	}
	
	public static List<String> generateParenthesis(int n) {
		List<String> list = new ArrayList<String>();
		pathGenerate(list, "", 0, 0, n);
		return list;
    }
	
	public static void pathGenerate(List<String> list, String temp, int left, int right, int n) {
		if (temp.length() == 2 * n) {
			list.add(temp);
			return ;
		}
		
		if (left < n) {
			pathGenerate(list, temp + "(", left + 1, right, n);
		}
		
		if (right < left) {
			pathGenerate(list, temp + ")", left, right + 1, n);
		}
	}

}
