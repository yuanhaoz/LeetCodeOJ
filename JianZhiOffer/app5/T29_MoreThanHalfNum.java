package app5;
/**  
 * 面试题29：数组中出现次数超过一半的数字
 * 题目：数组中 有一个数字出现的次数超过数组长度的一半，请找出这个数字。例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。
 * 由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。  
 * 
 * 思路：
 * 1. 解法1：基于Partition函数的O(n)算法
 * 数组中有一个数字出现的次数超过了数组长度的一半。如果把这个数组排序，那么排序之后位于数组中间的数字一定就是那个出现次数
 * 超过数组长度一半的数字。也就是说，这个数字就是中位数，即长度为n的数组中第n/2大的数字。
 * 
 * 2. 解法2：根据数组特点找出O(n)的算法
 * 数组中有一个数字出现的次数超过数组长度的一半，也就是说它出现的次数比其他所有数字出现次数的和还要多。
 * 因此我们可以考虑在遍历数组的时候保存两个值：一个是数组中的一个数字，一个是次数。当我们遍历到下一个数字的时候，
 * 如果下一个数字和我们之前保存的数字相同，则次数加1；如果下一个数字和我们之前保存的数字不同，则次数减1。
 * 如果次数为0，我们需要保存下一个数字，并把次数设为1.由于我们要找的数字出现的次数比其他所有数字出现的次数之和还要多，
 * 那么要找的数字肯定是最后一次把次数设为1时对应的数字。
 *  
 * @author 郑元浩 
 * @date 2017年3月28日 上午10:58:51 
 */
public class T29_MoreThanHalfNum {

	/**
	 * 题目：数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字
	 * 
	 * @param numbers 输入数组
	 * @return 找到的数字
	 */
	public static int moreThanHalfNum(int[] numbers){
		// 输入校验
		if (numbers == null || numbers.length < 1) {
			throw new IllegalArgumentException("array length must large than 0");
		}
		// 用于记录出现次数大于数组一半的数
		int result = numbers[0];
		// 与当前记录的数不同的 数的个数
		int count = 1;
		// 从第二个数开始向后找
		for (int i = 1; i < numbers.length; i++) {
			// 如果计数为0，重新记录一个数，假设它是出现次数大于数组一半的
			if (count == 0) {
				result = numbers[i];
				count = 1;
			} else if (result == numbers[i]) { // 如果记录的值与统计值相等，计数值增加
				count++;
			} else { // 如果不相同就减少，相互抵消
				count--;
			}
		}
		
		// 最后的result可能是出现次数大于数组一半长度的值，统计result的出现次数
		count = 0;
		for (int i : numbers) {
			if (result == i) {
				count++;
			}
		}
		// 如果出现次数大于数组的一半就返回对应的值
		if (count > numbers.length / 2) {
			return result;
		} else { // 否则输出异常
			throw new IllegalArgumentException("invalid input");
		}
	}
	
	public static void main(String[] args) {
		// 存在出现次数超过数组长度一半的数字
        int numbers[] = {1, 2, 3, 2, 2, 2, 5, 4, 2};
        System.out.println(moreThanHalfNum(numbers));

        // 出现次数超过数组长度一半的数字都出现在数组的前半部分
        int numbers2[] = {2, 2, 2, 2, 2, 1, 3, 4, 5};
        System.out.println(moreThanHalfNum(numbers2));

        // 出现次数超过数组长度一半的数字都出现在数组的后半部分
        int numbers3[] = {1, 3, 4, 5, 2, 2, 2, 2, 2};
        System.out.println(moreThanHalfNum(numbers3));

        // 只有一个数
        int numbers4[] = {1};
        System.out.println(moreThanHalfNum(numbers4));

        // 输入空指针
        moreThanHalfNum(null);
        // 不存在出现次数超过数组长度一半的数字
        int numbers5[] = {1, 2, 3, 2, 4, 2, 5, 2, 3};
        moreThanHalfNum(numbers5);

	}
}
