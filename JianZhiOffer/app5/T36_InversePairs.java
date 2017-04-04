package app5;

/**  
 * 面试题36：数组中的逆序对
 * 题目：在数组中的两个数字如果前面一个数字大于后面的数字，则这两个数字组成一对逆序对。输入一个数组，求出这个数组中的逆序对的总数。
 * 
 * 思路：
 * 1. 顺序扫描整个数组，没扫描到一个数字的时候，逐个比较该数字和它后面的数字的大小。如果后面的数字比它小，则这两个数字就组成了一个逆序对。假设数组中含有n个数字。
 *    由于每个数字要和O(n)个数字作比较，因此这个算法的时间复杂度是O(n^2)。
 * 2. 先把数组分隔成子数组，先统计出子数组内部的逆序对的数目，然后再统计出两个相邻子数组之间的逆序对的数目。在统计逆序对的过程中，还需要对数组进行排序。如果对排序
 *    算法很熟悉，不难发现这个排序过程实际上就是归并排序。时间复杂对是O(nlogn)，空间复杂度是O(n)，空间换时间的算法。
 *  
 * @author 郑元浩 
 * @date 2017年3月31日 上午11:04:47 
 */
public class T36_InversePairs {

	public static void main(String[] args) {
		int[] data = {7, 5, 6, 4};
		System.out.println(inversePairs(data));
	}
	
	public static int inversePairs(int[] data) {
		if (data == null || data.length == 0) {
			return 0;
		}
		int[] copy = new int[data.length];
		for (int i = 0; i < copy.length; i++) {
			copy[i] = data[i];
		}
		int count = inversePairs(data, copy, 0, data.length - 1);
		return count;
	}
	
	public static int inversePairs(int[] data, int[] copy, int start, int end) {
		if (start == end) {
			copy[start] = data[start];
			return 0;
		}
		int mid = (end - start) / 2;
		int left = inversePairs(copy, data, start, start + mid);
		int right = inversePairs(copy, data, start + mid + 1, end);
		// i初始化为前半段最后一个数字的下标
		int i = start + mid;
		// j初始化为后半段最后一个数字的下标
		int j = end;
		int indexCopy = end;
		int count = 0;
		// 开始从后往前比较两个子数组，比较结束后，copy是归并排序其中的一次结果，其中一部分子数组是有序的。
		while (i >= start && j >= start + mid + 1) {
			if (data[i] > data[j]) { // 当前面一个数组中的数字比后面一个大的时候，则该数字和后面一个数组中当前下标及其之前的所有元素构成逆序列
				copy[indexCopy--] = data[i--]; // 新数组保存前面一个数组中大的数字
				count += j - start - mid; // 加上当前的逆序列的数目
			} else {
				copy[indexCopy--] = data[j--];
			}
		}
		// 归并排序处理剩余的前半段数组
		for ( ;i >= start; --i) {
			copy[indexCopy--] = data[j];
		}
		// 归并排序处理剩余的后半段数组
		for (; j >= start + mid + 1; --j) {
			copy[indexCopy--] = data[j];
		}
		return left + right + count;
	}

}
