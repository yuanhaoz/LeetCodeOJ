package app3;

import java.util.Arrays;

/**  
 * 面试题14：调整数组顺序使奇数位于偶数前面
 * 题目：输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有奇数位于数组的前半部分，所有偶数位于数组的后半部分。
 * 
 * 思路：
 * 1.如果不考虑时间复杂度，最简单的思路应该是从头扫描这个数组，没碰到一个偶数时，拿出这个数字，并把位于这个数字后面的所有数字往前挪动一位。挪完之后在数组的末尾
 * 	  有一个空位，这时把该偶数放到这个空位。由于没碰到一个偶数就需要移动O(n)个数字，因此总的时间复杂度是O(n^2)。
 * 2.维护两个指针，第一个指针初始化时指向数组的第一个数字，它只向后移动；第二个指针初始化时指向数组的最后一个元素，它只向前移动。在两个指针相遇之前，
 *   第一个指针总是位于第二个指针的前面。如果一个指针指向的数字是偶数，并且第二个指针指向的数字是奇数，我们就交换这两个数字。然后这两个指针继续指向下一个奇数或偶数。
 *    
 *  
 * @author 郑元浩 
 * @date 2017年3月24日 上午10:58:05 
 */
public class T14_ReorderOddEven {

	/**
	 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，
     * 使得所有奇数位于数组的前半部分，所有偶数位予数组的后半部分。
	 * @param arr
	 */
	public static void reorderOddEven(int[] arr) {
		// 对于输入的数组为空，或者长度小于2的直接返回
		if (arr.length == 0 || arr.length == 1) {
			return ;
		}
		int length = arr.length;
		int first = 0; // 指向偶数
		int second = length - 1; // 指向奇数
		// 第一个指针应该小于第二个指针
		while (first < second) {
			while (first < second && (arr[first] & 0x01) != 0) {
				first++;
			}
			while (first < second && (arr[second] & 0x01) == 0) {
				second--;
			}
			System.out.println(first + " " + second);
			if (first < second) { // 交换数字
				int temp = arr[first];
				arr[first] = arr[second];
				arr[second] = temp;
			}
		}
	}

	public static void reorderOddEven2(int[] arr) {
		// 对于输入的数组为空，或者长度小于2的直接返回
		if (arr.length == 0 || arr.length == 1) {
			return ;
		}

		int left = 0;
		int right = arr.length - 1;
		while (left < right) {
			while (left< right && judge(arr[left])) {
				left++;
			}
			while (left< right && !judge(arr[right])) {
				right--;
			}
			if (left < right) { // 判断移动之后left小于right才进行交换
				int tmp = arr[left];
				arr[left] = arr[right];
				arr[right] = tmp;
			}
		}
	}

	/**
	 * 判断一个数是否是奇数
	 * 通用函数：可以用来替换判断条件，例如把数组中负数排在非负数前面，把能被3整除的数排在不能被3整除的数前面
	 * @param number
	 * @return true表示为奇数
	 */
	public static boolean judge(int number) {
		return (number & 1) == 1;
	}
	
	public static void main(String[] args) {
		int[] arr = {};
		reorderOddEven2(arr);
		System.out.println(Arrays.toString(arr));
		int[] arr1 = {1};
		reorderOddEven2(arr1);
		System.out.println(Arrays.toString(arr1));
		int[] arr2 = {1,2};
		reorderOddEven2(arr2);
		System.out.println(Arrays.toString(arr2));
		int[] arr3 = {1,3,5,2,4,6};
		reorderOddEven2(arr3);
		System.out.println(Arrays.toString(arr3));		
		int[] arr4 = {2,4,6,1,3,5};
		reorderOddEven2(arr4);
		System.out.println(Arrays.toString(arr4));
		int[] arr5 = {1,2,3,4,5,6};
		reorderOddEven2(arr5);
		System.out.println(Arrays.toString(arr5));	
	}

}
