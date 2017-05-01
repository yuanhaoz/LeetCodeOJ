package app1_2;
/**  
 * 
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 * 输入一个非递减排序的数组的一个旋转，输出旋转数组的最小元素。
 * 例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。
 * NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
 * 
 * 
 * 这道题最直观的解法并不难，从头到尾遍历数组一次，我们就能找出最小的元素。这种思路的时间复杂度显然是O(n)。
 * 但是这个思路并没有利用输入的旋转数组的特性，肯定达不到面试官的要求。
 * 我们注意到旋转之后的数组实际上可以划分为两个排序的子数组，而且前面的子数组的元素都大于或者等于后面子数组的元素。
 * 我们还注意到最小的元素刚好是这两个子数组的分界线。在排序的数组中我们可以利用二分查找法实现O(logn)的查找。
 * 本题给出的数组在一定程度上是排序的，因此我们可以试着用二分查找法的思路来寻找这个最小的元素。
 * 
 * 和二分法一样，我们用两个指针分别指向数组的第一个元素和最后一个元素。按照题目中旋转的规则，第一个元素应该是大于或等于最后一个元素的（不完全对，有特例，即不旋转数组）
 * 接着我们可以找到数组中间的元素。如果该中间元素位于前面的递增子数组，那么它应该大于等于第一个指针指向的元素。
 * 此时数组中最小的元素应该位于该中间元素的后面。我们可以把第一个指针指向该中间元素，这样可以缩小寻找的范围。
 * 移动之后的第一个指针仍然位于前面的递增子数组之中。
 * 
 * 同样，如果中间元素位于后面的递增子数组，那么它应该小于或者等于第二个指针指向的元素。此时数组中最小的元素
 * 应该位于该中间元素的前面。我们可以把第二个指针指向该中间元素，这样也可以缩小寻找的范围。移动之后的第二个指针
 * 仍然位于后面的递增子数组中。
 * 
 * 本题考点：考查对二分查找的理解。本题变换了二分查找的条件，输入的数组不是排序的，而是排序数组的一个旋转。这要求我们对二分查找的过程有深刻的理解。
 * 考查沟通学习能力。对于新的概念：数组的旋转。我们要在很短的时间内学习理解这个新概念。可以主动和面试官沟通，多问几个问题把概念弄清楚。
 * 考查思维的全面性。排序数组本身是数组旋转的一个特例。另外，我们要考虑到数组中有相同的数字的特例。如果不能很好的处理这些特例，就很难写出让面试官满意的完美代码。
 *  
 * @author 郑元浩 
 * @date 2017年3月12日 下午8:07:51 
 */
public class T8_MinNumberInRotateArray {

	/**
	 * 把一个数组最开始的若干个元素搬到数组的末尾， 我们称之数组的旋转。
     * 输入一个递增排序的数组的一个旋转，输出旋转数组的最小元素。
     * 例如数组{3, 4, 5, 1, 2｝为｛l ,2, 3, 4, 5}的一个旋转，该数组的最小值为
	 * @param array 旋转数组
	 * @return 数组的最小值
	 */
	public static int minNumberInRotateArray(int [] array) {
		// 判断输入是否合法
	    if (array == null || array.length == 0) {
	    	return 0;
		}
	    int i = 0; // 开始处理的第一个位置
	    int j = array.length - 1; // 开始处理的最后一个元素
	    
	    // 设置初始值，防止是一个有序的数组，此时直接输出mid第一个元素即可
	    int mid = i;
	    
	    // 确保i在前一个排序好的部分，j在排序好的后一个部分
	    while (array[i] >= array[j]) {
			// 当处理范围只有两个数据时，返回后一个结果
	    	// 因为array[i] >= array[j]总是成立的，后一个结果对应的是最小值
	    	if (j - i == 1) {
				return array[j];
			}
			// 取中间位置，使用二分法
			mid = i + (j - i) / 2;
			// 如果三个数都相等，则需要进行顺序处理，从头到尾找到最小值（对于[1,0,1,1,1]和[1,1,1,0,1]两种情况无法处理）
	    	if (array[i] == array[mid] && array[mid] == array[j]) {
				return minArray(array, i, j);
			}
	    	// 如果中间位置对应的值在前一个排好序的部分，将i设置为新的处理位置
			if (array[mid] >= array[i]) {
				i = mid;
			}
			// 如果中间位置对应的值在后一个排好序的部分，将j设置为新的处理位置
			if (array[mid] <= array[j]) {
				j = mid;
			}
		}
	    // 返回最终的处理结果
	    return array[mid];
    }

	/**
	 * 找到数组中的最小值
	 * @param array 数组
	 * @param start 数组的起始位置
	 * @param end 数组的结束位置
	 * @return 找到的最小的数
	 */
	public static int minArray(int[] array, int start, int end){
		int min = array[start];
		for (int i = start + 1; i <= end; i++) {
			if (min > array[i]) {
				min = array[i];
			}
		}
		return min;
	}
	
	/**
	 * 测试用例：
	 * 功能测试（输入的数组是升序排序的数组的一个旋转，数组中有重复数字或者没有重复数字）。
	 * 边界值测试（输入的数组是一个升序排序的数组、只包含一个数字的数组）。
	 * 特殊输入测试（输入NULL指针）。
	 * @param args
	 */
	public static void main(String[] args) {
		// 典型输入，单调升序的数组的一个旋转
		int [] array = {3, 4, 5, 1, 2};
		System.out.println(minNumberInRotateArray(array));
		System.out.println(minNumberInRotateArray2(array));
		System.out.println("-------------------------------------");

		// 有重复数字，并且重复的数字刚好是最小的数字
		int [] array1 = {3, 4, 5, 1, 1, 2};
		System.out.println(minNumberInRotateArray(array1));
		System.out.println(minNumberInRotateArray2(array1));
		System.out.println("-------------------------------------");

		// 有重复的数字，但重复的数字不是第一个数字和最后一个数字
		int [] array2 = {3, 4, 5, 1, 2, 2};
		System.out.println(minNumberInRotateArray(array2));
		System.out.println(minNumberInRotateArray2(array2));
		System.out.println("-------------------------------------");

		// 有重复的数字，并且重复的数字刚好是第一个数字和最后一个数字
		int [] array3 = {1, 0, 1, 1, 1};
		System.out.println(minNumberInRotateArray(array3));
		System.out.println(minNumberInRotateArray2(array3));
		System.out.println("-------------------------------------");

		// 单调升序数组，旋转0个元素，也就是单调升序数组本身
		int [] array4 = {1, 2, 3, 4, 5};
		System.out.println(minNumberInRotateArray(array4));
		System.out.println(minNumberInRotateArray2(array4));
		System.out.println("-------------------------------------");

		// 数组中只有一个数字
		int [] array5 = {2};
		System.out.println(minNumberInRotateArray(array5));
		System.out.println(minNumberInRotateArray2(array5));
		System.out.println("-------------------------------------");

		// 数组中的数字都相同
		int [] array6 = {1,1,1,1,1,1,1,1};
		System.out.println(minNumberInRotateArray(array6));
		System.out.println(minNumberInRotateArray2(array6));
		System.out.println("-------------------------------------");
	}

	public static int minNumberInRotateArray2(int[] array) {
		if (array == null || array.length == 0) {
			throw new RuntimeException("输入数组不符合要求");
		}
		int left = 0;
		int right = array.length - 1;
		int mid = left; // 设置初始值，防止是一个有序的数组，此时直接输出mid第一个元素即可
		while (left < right && right - left > 1) {
			if (array[mid] == array[left] && array[mid] == array[right]) {
				return minArray(array, left, right);
			}
			if (array[mid] >= array[left]) {
				left = mid;
			}
			if (array[mid] <= array[right]) {
				right = mid;
			}
			mid = left + (right - left) / 2;
		}
		return array[right];
	}
	
}
