package app5;

import java.util.Arrays;

/**  
 * 面试题30：最小的k个数
 * 题目：输入n个整数，找出其中最小的k个数。例如，输入4/5/1/6/2/7/3/8这8个数，则最小的4个数字是1/2/3/4。
 * 
 * 思路：
 * 1. 这道题最简单的思路莫过于把输入的n个整数排序，排序之后位于最前面的k个数就是最小的k个数。这种思路的时间复杂度是O(nlogn)
 * 2. O(n)的算法，只有当我们可以修改输入的数组时可用
 * 从上一题中我们可以得到启发，我们同样可以基于Partition函数来解决这个问题。如果基于数组的第k个数字来调整，
 * 使得比第k个数字小的所有数字都位于数组的左边，比第k个数字大的所有数字都位于数组的右边。这样调整之后，位于数组中左边的k个数字就是最小的k个数字。
 * 3. O(nlogk)的算法，特别适用处理海量数据
 * 我们可以先创建一个大小为k的数据容器来存储最小的k个数字，接下来我们每次从输入的n个整数中读入一个数。
 * 如果容器中已有数字少于k个，则直接把这次读入的整数放入容器中；如果容器中已有k个数字了，也就是容器已满，
 * 此时我们不能再插入新的数字了而只能替换已有的数字。找出这已有的k个数中的最大值，然后拿这次待插入的整数和最大值进行比较。
 * 如果待插入的值比当前已有的最小值小，则用这个数替换当前已有的最大值；如果待插入的值比当前已有的最大值还大，
 * 那么这个数不可能是最小的k个整数之一，于是我们可以抛弃这个整数。
 * 因此当容器满了之后，我们要做3件事；一是在k个整数中找到最大数；二是有可能在这个容器中删除最大数；三是有可能要插入一个新的数字。
 * 如果用一个二叉树来实现这个容器，那么我们能在O(logk）时间内实现这三步操作。因此对于n个输入的数字而言，总的时间效率是O(nlogk).
 * 我们可以选择用不同的二叉树来实现这个数据容器。由于每次都需要找到k个整数中的最大数字，我们很容易想到用最大堆。
 * 在最大堆中，根节点的值总是大于它的子树中的任意结点的值。于是我们每次可以在O(1）得到已有的k个数字中的最大值，但需要O(logk)时间完成删除及插入操作。
 * 
 * 解法比较：
 * 基于函数Partition的第一种解法的平均时间复杂度是O(n)，比第二种思路要快，但同时它也有明显的限制，比如会修改输入的数组。
 * 第二种解法虽然要慢一点，但它有两个明显的优点。一是没有修改输入的数据。二是该算法适合海量数据的输入（包括百度在内的多家公司非常喜欢与海量数据相关的问题）。
 * 假如题目是要求从海量的数据中找出最小的k个数字，由于内存的大小是有限的，有可能不能把这些海量数据一次性全部加载入内存。
 * 这个时候，我们可以辅助存储空间（比如磁盘）中每次读入一个数字，根据GetLeastNumbers的方式判断是不是需要放入容器LeastNumbers即可。
 * 这种思路只要求内存能够容纳leastNumbers即可。因此它适合的情形就是n很大并且k较小的问题。
 *  
 * @author 郑元浩 
 * @date 2017年3月28日 下午9:18:19 
 */
public class T30_GetLeastNumbers {

	public static void main(String[] args) {
		int[] arr = {4, 5, 1, 6, 2, 7, 3, 8};
		System.out.println(Arrays.toString(getLeastNumbers(arr, 4)));
		System.out.println(Arrays.toString(getLeastNumbers2(arr, 4)));
	}
	
	/**
	 * 快速排序的partition函数
	 * @param arr 待排序数组
	 * @param left 左指针
	 * @param right 右指针
	 * @return
	 */
	public static int partition(int[] arr, int left, int right) {
		int result = arr[left];
		if (left > right) {
			return -1;
		}
		while (left < right) {
			while (left < right && arr[right] >= result) {
				right--;
			}
			arr[left] = arr[right];
			while (left < right && arr[left] < result) {
				left++;
			}
			arr[right] = arr[left];
		}
		arr[left] = result;
		return left;
	}
	
	/**
	 * 2. O(n)的算法，只有当我们可以修改输入的数组时可用
	 * 从上一题中我们可以得到启发，我们同样可以基于Partition函数来解决这个问题。如果基于数组的第k个数字来调整，
	 * 使得比第k个数字小的所有数字都位于数组的左边，比第k个数字大的所有数字都位于数组的右边。
	 * 这样调整之后，位于数组中左边的k个数字就是最小的k个数字。
	 * @param input
	 * @param k
	 * @return
	 */
	public static int[] getLeastNumbers(int[] input, int k) {
		if (input.length == 0 || k <= 0 || k > input.length) {
			return null;
		}
		int[] output = new int[k];
		int start = 0;
		int end = input.length - 1;
		int index = partition(input, start, end);
		while (index != k - 1) {
			if (index > k - 1) {
				end = index - 1;
				index = partition(input, start, end);
			} else {
				start = index + 1;
				index = partition(input, start, end);
			}
		}
		for (int i = 0; i < k; i++) {
			output[i] = input[i];
		}
		return output;
	}
	
	/**
	 * 新建大顶堆
	 * @param arr
	 * @param lastIndex
	 */
	public static void buildMaxHeap(int[] arr, int lastIndex) {
		for (int i = (lastIndex - 1) / 2; i >= 0; i--) {
			int k = i;
			while (2 * k + 1 <= lastIndex) {
				int biggerIndex = 2 * k + 1;
				if (biggerIndex < lastIndex) {
					if (arr[biggerIndex] < arr[biggerIndex + 1]) {
						biggerIndex++;
					}
				}
				if (arr[k] < arr[biggerIndex]) {
					swap(arr, k, biggerIndex);
					k = biggerIndex;
				} else {
					break;
				}
			}
		}
	}
	
	public static void swap(int[] arr, int i, int j){
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}
	
	public static void heapSort(int[] arr) {
		for (int i = 0; i < arr.length - 1; i++) {
			buildMaxHeap(arr, arr.length - i - 1);
			swap(arr, 0, arr.length - i - 1);
		}
	}
	
	/**
	 * 3. O(nlogk)的算法，特别适用处理海量数据
	 * @param arr
	 * @param k
	 * @return
	 */
	public static int[] getLeastNumbers2(int[] arr, int k) {
		if (arr.length == 0 || k <= 0 || k > arr.length) {
			return null;
		}
		// 根据输入数组前k个数遍历最大堆
		int[] kArray = Arrays.copyOfRange(arr, 0, k);
		heapSort(kArray);
		for (int i = k; i < arr.length; i++) { // 从k+1个数开始与根节点比较
			if (arr[i] < kArray[k - 1]) { // 小于，取代根节点，重建最大堆
				kArray[k - 1] = arr[i];
				heapSort(kArray);
			}
		}
		return kArray;
	}

}
