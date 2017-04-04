package app6;
/**  
 * 面试题41：和为s的两个数字 VS 和为s的连续正数序列
 * 题目一：输入一个递增排序的数组和一个数字s，在数组中查找两个数，使得它们的和正好是s。如果有多对数字的和等于s，输出任意一对即可
 * 思路：1.两遍遍历数组判断；2.两个指针分别从两端开始查找
 * 
 * 题目二：输入一个正数s，打印出所有和为s的连续正数序列（至少含有两个数）。例如输入15，由于1+2+3+4+5=4+5+6=7+8=15，所以结果
 * 打印出3个连续序列1-5，4-6，7-8
 * 思路：两个指针初始化为相邻
 * 
 * 本题考点：
 * 考查知识迁移能力。应聘者面对第二个问题的时候，能不能把解决第一个问题的思路应用到新的题目上，是面试官考查知识迁移能力的重要指标。
 *  
 * @author 郑元浩 
 * @date 2017年4月4日 上午9:40:46 
 */
public class T41_FindNumbersWithSum {

	public static void main(String[] args) {
		int[] arr = {1, 2, 4, 7, 11, 15};
		int sum = 15;
		findNumberWithSum(arr, sum);
		System.out.println("------------------------");
		findContinuousSequence(9);
		System.out.println("------------------------");
		findContinuousSequence(15);
	}
	
	public static int[] findNumberWithSum(int[] arr, int sum) {
		if (arr == null || arr.length == 0) {
			return null;
		}
		int[] result = new int[2];
		int left = 0; // 第一个指针指向左边
		int right = arr.length - 1;
		while (left < right) {
			int tempSum = arr[left] + arr[right];
			if (tempSum == sum) {
				result[0] = arr[left];
				result[1] = arr[right];
				break;
			} else if (tempSum > sum) {
				right--;
			} else {
				left++;
			}
		}
		System.out.println(result[0] + " " + result[1]);
		return result;
	}
	
	public static void findContinuousSequence(int sum) {
		if (sum < 3) {
			return ;
		}
		int start = 1;
		int end = 2;
		int tempSum = start + end;
		int mid = (1 + sum) / 2;
		while (start < end && end <= mid) {
			if (tempSum == sum) {
				for (int i = start; i <= end; i++) {
					System.out.print(i + " ");
				}
				System.out.println();
				end++;
				tempSum += end;
			} else if (tempSum < sum) {
				end++;
				tempSum += end;
			} else {
				tempSum -= start;
				start++;
			}
		}
	}

}
