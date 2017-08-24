package app5;
/**  
 * 面试题32：从1到n整数中1出现的次数
 * 题目：输入一个整数n，求从1到n这n个整数的十进制表示中1出现的次数。例如输入12，从1到12这些整数中包含1的数字有1,10,11和12，1一共出现了5次。   
 * 
 * 思路：
 * 1. 不考虑时间效率的解法，靠它先拿offer有点难
 * 如果在面试的时候碰到这个问题，应聘者大多数能想到最直观的方法，也就是累加1到n中每个整数1出现的次数。我们可以每次通过对10求余数
 * 再判断整数的个位数字是不是1。如果这个数字大于10，除以10之后再判断个位数字是不是1。
 * 
 * @author 郑元浩 
 * @date 2017年3月29日 上午9:09:40 
 */
public class T32_NumberOf1Between1AndN {

	public static void main(String[] args) {
		System.out.println(numberOf1Between1AndN(12));
		System.out.println(numberOf1Between1AndN2(12));
	}
	
	/**
	 * 我们可以每次通过对10求余数
	 * 再判断整数的个位数字是不是1。如果这个数字大于10，除以10之后再判断个位数字是不是1。
	 * @param n
	 * @return
	 */
	public static int numberOf1Between1AndN(int n) {
		if (n < 0) {
			return 0;
		}
		int count = 0; // 1的个数
		for (int i = 1; i <= n; i++) {
			int k = i;
			while (k != 0) { // 每次对10取余数
				int yu = k % 10;
				if (yu == 1) {
					count++;
				}
				k = k / 10; // 除以10
			}
		}
		return count;
	}
	
	public static int numberOf1Between1AndN2(int n) {
		if (n <= 0) {
			return 0;
		}
		
		String value = n + "";
		int[] numbers = new int[value.length()];
		for (int i = 0; i < numbers.length; i++) {
			numbers[i] = value.charAt(i) - '0';
		}
		return numberOf1(numbers, 0);
	}
	
	 /**
     * 求0-numbers表的数字中的1的个数
     *
     * @param numbers 数字，如{1, 2, 3, 4, 5}表示数字12345
     * @param curIdx  当前处理的位置
     * @return 1的个数
     */
	public static int numberOf1(int[] numbers, int curIndex) {
		if (numbers == null || curIndex >= numbers.length || curIndex < 0) {
			return 0;
		}
		// 待处理的第一个数字
		int first = numbers[curIndex];
		// 要处理的数字的位数
		int length = numbers.length - curIndex;
		// 如果只有一位且这一位是0返回0
		if (length == 1 && first == 0) {
			return 0;
		}
		// 如果只有一位且这一位不是0返回1
		if (length == 1 && first > 0) {
			return 1;
		}
		// 假设numbers是21345
		// numFirstDigit是数字10000-19999的第一位中的数目
		int numFirstDigit = 0;
		// 如果最高位不是1，如21345，在[1346，21345]中，最高位1出现的只在[10000, 19999]中，出现的次数是10^4
		if (first > 1) {
			numFirstDigit = powerBase10(length - 1);
		}
		// 如果最高位是1，如12345，在[2346,12345]中，最高位1出现的只在[10000,12345]中，总计2345+1个
		else if (first == 1) {
			numFirstDigit = atoi(numbers, curIndex + 1) + 1;
		}
		// numOtherDigits，是[1346,21345]中，除了第一位之外（不看21345中的第一位2）的数位中的1的数目，排列组合 
		int numOtherDigits = first * (length - 1) * powerBase10(length - 2);
		// numRecursive是1-1234中1的数目
		int numRecursive = numberOf1(numbers, curIndex + 1);
		
		return numFirstDigit + numOtherDigits + numRecursive;
	}
	
	/**
     * 将数字数组转换成数值，如{1, 2, 3, 4, 5}，i = 2，结果是345
     * @param numbers 数组
     * @param i 开始黑气的位置
     * @return 转换结果
     */
	public static int atoi(int[] numbers, int i) {
		int result = 0;
		for (int j = i; j < numbers.length; j++) {
			result = result * 10 + numbers[j];
		}
		return result;
	}
	
	/**
     * 求10的n次方，假定n不为负数
     * @param n 幂，非负数
     * @return 10的n次方
     */
	public static int powerBase10(int n) {
		int result = 1;
		for (int i = 0; i < n; i++) {
			result *= 10;
		}
		return result;
	}

}
