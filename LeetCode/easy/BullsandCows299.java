package easy;

import java.util.ArrayList;
import java.util.List;

/**  
 * 299. Bulls and Cows   Add to List QuestionEditorial Solution  My Submissions
Total Accepted: 51282
Total Submissions: 153900
Difficulty: Easy
Contributors: Admin

You are playing the following Bulls and Cows game with your friend: 
You write down a number and ask your friend to guess what the number is. 
Each time your friend makes a guess, you provide a hint that indicates how many digits in 
said guess match your secret number exactly in both digit and position (called "bulls") and 
how many digits match the secret number but locate in the wrong position (called "cows"). 
Your friend will use successive guesses and hints to eventually derive the secret number.

For example:

Secret number:  "1807"
Friend's guess: "7810"
Hint: 1 bull and 3 cows. (The bull is 8, the cows are 0, 1 and 7.)

Write a function to return a hint according to the secret number and friend's guess, 
use A to indicate the bulls and B to indicate the cows. 
In the above example, your function should return "1A3B".

Please note that both secret number and friend's guess may contain duplicate digits, for example:

Secret number:  "1123"
Friend's guess: "0111"
In this case, the 1st 1 in friend's guess is a bull, the 2nd or 3rd 1 is a cow, and your function should return "1A1B".
You may assume that the secret number and your friend's guess only contain digits, and their lengths are always equal.   
 *  
 * @author 郑元浩 
 * @date 2017年1月17日 上午10:01:50 
 */
public class BullsandCows299 {

	public static void main(String[] args) {
		System.out.println(getHint("1807", "7810"));
		System.out.println(getHint("1123", "0111"));
		System.out.println(getHint("1122", "2211"));
		System.out.println(getHint("1123", "4213"));
		System.out.println(getHint("11222", "22011"));
	}
	
	/**
	 * 两次遍历secret字符串，第一次比较每个位置上的值，得到相同元素的个数。第二次比较猜对的数字但是出现位置不同的数。
	 * @param secret
	 * @param guess
	 * @return
	 */
	public static String getHint(String secret, String guess) {
		int n = secret.length();
		int a = 0, b = 0;
		List<Character> secretList = new ArrayList<Character>();
		List<Character> guessList = new ArrayList<Character>();
        for (int i = 0; i < n; i++) { // 第一次比较每个位置上的值，得到猜元素的个数
			if (secret.charAt(i) == guess.charAt(i)) {
				a++;
			} else {
				secretList.add(secret.charAt(i));
				guessList.add(guess.charAt(i));
			}
		}
        for (int i = 0; i < secretList.size(); i++) { // 第二次遍历secretList，得到猜对的数字但是位置不同的数
			if (guessList.contains(secretList.get(i))) {
				b++;
				guessList.remove(secretList.get(i));
			}
		}
        return a+"A"+b+"B";
    }

}
