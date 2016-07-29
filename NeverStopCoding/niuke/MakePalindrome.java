package niuke;

import java.util.Scanner;

/**
 * 给定一个字符串s，你可以从中删除一些字符，使得剩下的串是一个回文串。如何删除才能使得回文串最长呢？
 * 输出需要删除的字符个数
 * 输入描述: 输入数据有多组，每组包含一个字符串s，且保证:1<=s.length<=1000.
 * 输出描述: 对于每组数据，输出一个整数，代表最少需要删除的字符个数。
 * @author yuanhao
 * 实现思想：首先保存s字符串，之后再保存其rs相反的字符串。
 * 对其求最大子序列，若果不清楚最长公共子序列请点击括号内的链接（最长公共子序列），则结果就是回文串。
 */

public class MakePalindrome {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		
		while(in.hasNext()){
			String s = in.nextLine();
			System.out.println(getResult(s));
		}

	}
	
	public static int getResult(String s){
		int len = s.length();
		String res = new StringBuffer(s).reverse().toString();
		int[][] data = new int[len + 1][len + 1];
		
		for(int i = 0; i < len + 1; i++){
			data[i][0] = data[0][i] = 0;
		}
		
		for(int i = 1; i < len + 1; i++){
			for(int j = 1; j < len + 1; j++){
				if(s.charAt(i - 1) == res.charAt(j - 1)){
					data[i][j] = data[i - 1][j - 1] + 1;				
				} else if(data[i - 1][j] >= data[i][j - 1]){
					data[i][j] = data[i - 1][j];
				} else {
					data[i][j] = data[i][j - 1];
				}
			}
		}
		return len - data[len][len];
	}

}
