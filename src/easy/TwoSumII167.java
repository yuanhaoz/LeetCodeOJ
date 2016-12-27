package easy;


/**  
 * 167. Two Sum II - Input array is sorted   Add to List QuestionEditorial Solution  My Submissions
Total Accepted: 43730
Total Submissions: 91118
Difficulty: Medium
Contributors: Admin
Given an array of integers that is already sorted in ascending order, find two numbers such that they add up to a specific target number.

The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2. 
Please note that your returned answers (both index1 and index2) are not zero-based.

You may assume that each input would have exactly one solutsmsion.

Input: numbers={2, 7, 11, 15}, target=9
Output: index1=1, index2=2

Subscribe to see which companies asked this question   
 *  
 * @author 郑元浩 
 * @date 2016年12月30日 下午10:27:12 
 */
public class TwoSumII167 {

	public static void main(String[] args) {
//		int[] numbers = {2, 7, 11, 15};
//		twoSum(numbers, 9);
//		int[] numbers = {0,0, 11, 15};
//		twoSum(numbers, 0);
		int[] numbers = {-3,3,4,90};
		twoSum(numbers, 0);
	}
	
	public static int[] twoSum(int[] numbers, int target) {
		int[] res = new int[2];
		int start = 0, end = numbers.length - 1;
		while (numbers[start] + numbers[end] != target) {
			if (numbers[start] + numbers[end] < target) {
				start++;
			}
			if (numbers[start] + numbers[end] > target) {
				end--;
			}
		}
		res[0] = start + 1;
		res[1] = end + 1;
		System.out.println(res[0] + "--->" + res[1]);
		return res;
    }
	
	public static int[] twoSum2(int[] numbers, int target) {
		int[] res = new int[2];
		for (int i = 0; i < numbers.length - 1; i++) {
			if (numbers[i] <= target) { // 只判断比target小的数字
				for (int j = i + 1; j < numbers.length; j++) {
					if (numbers[j] <= target) {
						if (numbers[i] + numbers[j] == target) {
							res[0] = i + 1;
							res[1] = j + 1;
						}
					} else {
						break;
					}
				}
			} else {
				break;
			}
		}
		System.out.println(res[0]);
		System.out.println(res[1]);
		return res;
    }

}
