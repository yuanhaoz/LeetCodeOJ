package easy;
/**  
 * 66. Plus One   Add to List QuestionEditorial Solution  My Submissions
Total Accepted: 141962
Total Submissions: 385901
Difficulty: Easy
Contributors: Admin
Given a non-negative number represented as an array of digits, plus one to the number.

The digits are stored such that the most significant digit is at the head of the list.

Subscribe to see which companies asked this question   
 *  
 * @author 郑元浩 
 * @date 2017年1月1日 下午12:27:34 
 */
public class PlusOne66 {

	public static void main(String[] args) {
//		int[] digits = {1, 2, 3};
//		int[] digits = {1, 2, 9};
//		int[] digits = {1, 9, 9};
//		int[] digits = {9, 9, 9};
//		int[] digits = {0, 9, 9};
		int[] digits = {0, 5, 9};
		int[] result = plusOne(digits);
		for (int i = 0; i < result.length; i++) {
			System.out.print(result[i] + " ");
		}
	}
	
	public static int[] plusOne(int[] digits) {
		int len = digits.length;
		int end = digits.length - 1;
		while (end >= 0 && digits[end] == 9 ) {
			end--;
		}
		if (end >= 0) { // digits不全为9
//			if (end == digits.length - 1) { // 不存在9
//				digits[end]++;
//			} else { // 存在一些9
//				for (int i = end + 1; i < digits.length; i++) {
//					digits[i] = 0;
//				}
//				digits[end]++;
//			}
			if (end != digits.length - 1) {
				for (int i = end + 1; i < digits.length; i++) {
					digits[i] = 0;
				}
			}
			digits[end]++;
			return digits;
		} else { // digits全部为9
			int[] result = new int[len + 1];
			result[0] = 1;
			return result;
		}
	}

}
