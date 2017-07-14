package medium.string;

/**
 *  
6. ZigZag Conversion
The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of 
rows like this: (you may want to display this pattern in a fixed font for better legibility)

P   A   H   N
A P L S I I G
Y   I   R
And then read line by line: "PAHNAPLSIIGYIR"
Write the code that will take a string and make this conversion given a number of rows:

string convert(string text, int nRows);
convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR".
 * @author 郑元浩
 * @date 2017年7月12日 上午9:54:28
 *
 */
public class ZigZagConversion6 {

	public static void main(String[] args) {
		String s = "PAYPALISHIRING";
		int numRows = 3;
		convert(s, numRows);
	}
	
	/**
	 * 保存一个大小为n的可变字符串数组，循环一遍字符串即可把这个数组中的值全部填上
	 * @param s
	 * @param numRows
	 * @return
	 */
	public static String convert(String s, int numRows) {
		int len = s.length();
		// 设置返回结果的可变字符串数组，并初始化
		StringBuffer[] sb = new StringBuffer[numRows];
		for (int i = 0; i < sb.length; i++) {
			sb[i] = new StringBuffer();
		}
		// 从字符串第一个元素开始遍历字符串，并且在遍历的同时按照Z字型规律将字符串的值依次填写到对应的StringBuffer数组中
		int i = 0; // 循环字符串s
		while (i < len) {
			for (int index = 0; index < numRows && i < len; index++) { // 奇数列从上往下向数组中依次填值
				sb[index].append(s.charAt(i++));
			}
			for (int index = numRows - 2; index > 0  && i < len; index--) {  // 奇数列从下往上向数组中依次填值，Z字型规则
				sb[index].append(s.charAt(i++));
			}
		}
		// 合并所有字符
		for (int j = 1; j < sb.length; j++) {
			sb[0] = sb[0].append(sb[j]);
		}
		System.out.println(sb[0].toString());
		return sb[0].toString();
    }

}
