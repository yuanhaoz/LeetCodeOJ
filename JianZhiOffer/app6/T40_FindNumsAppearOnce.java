package app6;
/**  
 * 面试题40： 数组中只出现一次的数字
 * 题目：一个整型数组里除了两个数字之外，其余的数字都出现了两次。请写程序找出这两个只出现一次的数字。要求时间复杂度是O(n)，空间复杂度是O(1)
 * 
 * 思路：
 * 1.0 这是一个比较难得题目。提示是：先考虑这个数组中只有一个数字只出现一次，其他的都出现了两次，怎么找出这个数字？
 * 1.1 想到异或：任何一个数字异或自己都等于0.也就是说如果我们从头到尾异或数组中的每一个数字，那么最终的结果刚好是那个只出现一次的数字，因为那些成对
 * 出现两次的数字全部在异或中抵消了。
 * 1.2 我们试着把原数组分成两个数组，使得每个子数组只包含一个出现一次的数字，而其他数字都成对出现两次。如果能够这样拆分两个数组，我们就可以按照前面的
 * 办法分别找出两个只出现一次的数字了。
 * 1.3 从头到尾异或数组中的每一个数字，最终得到的结果就是两个只出现一次的数字的异或结果。因为其他数字都出现了两次，在异或中全部抵消了。
 * 由于这两个数字肯定是不一样的，那么异或的结果肯定不为0，也就是说在这个结果数字的二进制表示中至少就有一位为1。
 * 我们在结果数字中找到第一个为1的位的位置，记为第n位。现在我们以第n位是不是1为标准把原来数组分成逻辑上的两个子数组，第一个子数组中每个数字的第n位
 * 都是1，而第二个子数组中每个数字的第n位都是0。由于我们分组的标准是数字中的某一位是1还是0，那么出现了两次的数字肯定就被分配到同一个子数组。
 * 因为两个相同的数字的任意一位都是相同的，我们不可能把两个相同的数字分配到两个子数组中去，于是我们已经把原数组分成了两个子数组，每个子数组都包含
 * 一个只出现一次的数字，而其他数字都出现了两次。我们已经知道如何在数组中找出唯一一个只出现一次的数字，因此到此为止所有的问题都已经解决了。 
 * 
 * 本题考点：
 * 1. 考查知识迁移能力。只有一个数字出现一次这个简单的问题，很多应聘者都能想到解决办法。能不能把解决简单问题的思路迁移到复杂问题上，是应聘者
 * 能否通过这轮面试的关键。
 * 2. 考查对二进制和位运算的理解。（一般常用的是异或^运算）
 *  
 * @author 郑元浩 
 * @date 2017年4月2日 上午10:46:56 
 */
public class T40_FindNumsAppearOnce {
	
	/**
	 * 一个整型数组里除了两个数字之外，其余的数字都出现了两次。请写程序找出这两个只出现一次的数字。要求时间复杂度是O(n)，空间复杂度是O(1)
	 * 思路：异或
	 * @param arr
	 */
	public static int[] findNumsAppearOne(int[] arr) {
		int[] result = {0, 0};
		if (arr == null || arr.length < 2) {
			System.out.println("数组为空。。。");
			return result;
		}
		// 得到整个数组异或的结果，该值其实就是两个不同数的异或结果
		int xorResult = 0;
		for (int i = 0; i < arr.length; i++) {
			xorResult ^= arr[i];
		}
		// 得到异或结果第一位为1的下标，并且循环遍历数组判断哪些该位为1，哪些为0。
		// 最终两个数字分别就是这两堆数组异或的结果。
		int index = findFirstOne(xorResult);
		for (int i = 0; i < arr.length; i++) {
			if (isDigitOne(arr[i], index)) {
				result[0] ^= arr[i];
			} else {
				result[1] ^= arr[i];
			}
		}
		System.out.println("这两个不同的数是：" + result[0] + "," + result[1]);
		return result;
	}
	
	/**
	 * 找到最终异或结果中第一个1出现的位置
	 * @param number
	 */
	public static int findFirstOne(int number) {
		int index = 0;
		while ((number & 0x01) == 0 && index < 32) {
			number >>>= 1;
			index++;
		}
		return index;
	}
	
	/**
	 * 判断数字第index位置是不是1
	 * @param number
	 * @param index
	 */
	public static boolean isDigitOne(int number, int index) {
		number = number >> index;
		if ((number & 0x01) == 1) {
			return true;
		} else {
			return false;
		}
	}

	public static void main(String[] args) {
		System.out.println(findFirstOne(3));
		System.out.println(isDigitOne(3,0));
		int[] arr = {2,4,3,6,3,2,5,5};
		findNumsAppearOne(arr);
		
		int[] data2 = {4, 6};
        findNumsAppearOne(data2);

        int[] data3 = {4, 6, 1, 1, 1, 1};
        findNumsAppearOne(data3);
        
        int[] a = {0,1};
        findNumsAppearOne(a);
        
        int[] a1 = {0};
        findNumsAppearOne(a1);
	}

}
