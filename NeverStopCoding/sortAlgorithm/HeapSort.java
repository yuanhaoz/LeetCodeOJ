package sortAlgorithm;

import java.util.Arrays;

/**  
 * 堆排序是借助堆来实现的选择排序，思想同简单的选择排序，以下以大顶堆为例。注意：如果想升序排序就使用大顶堆，反之使用小顶堆。原因是堆顶元素需要交换到序列尾部。

　　首先，实现堆排序需要解决两个问题：

　　1. 如何由一个无序序列键成一个堆？

　　2. 如何在输出堆顶元素之后，调整剩余元素成为一个新的堆？

　　第一个问题，可以直接使用线性数组来表示一个堆，由初始的无序序列建成一个堆就需要自底向上从第一个非叶元素开始挨个调整成一个堆。

　　第二个问题，怎么调整成堆？首先是将堆顶元素和最后一个元素交换。然后比较当前堆顶元素的左右孩子节点，因为除了当前的堆顶元素，左右孩子堆均满足条件，
        这时需要选择当前堆顶元素与左右孩子节点的较大者（大顶堆）交换，直至叶子节点。我们称这个自堆顶自叶子的调整成为筛选。

　　从一个无序序列建堆的过程就是一个反复筛选的过程。若将此序列看成是一个完全二叉树，则最后一个非终端节点是n/2取底个元素，由此筛选即可。举个栗子：

   49,38,65,97,76,13,27,49序列的堆排序建初始堆和调整的过程如下：   
   
   
       堆排序算法的实现，以大顶堆为例。
 *  
 * @author 郑元浩 
 * @date 2017年2月18日 下午2:45:42 
 */
public class HeapSort {

	public static void main(String[] args) {
		int[] arr = {5, 3, 4, 8, 2};
		heapSort(arr);
		System.out.println(Arrays.toString(arr));
	}
	
	/**
	 * 堆筛选，除了start之外，start-end均满足大顶堆的定义。
	 * 调整之后start-end称为一个大顶堆
	 * @param arr 待调整数组
	 * @param start 起始指针
	 * @param end 结束指针
	 */
	public static void heapAdjust(int[] arr, int start, int end) {
		int temp = arr[start];
		
		for (int i = 2 * start + 1; i < end; i *= 2) {
			// 左右孩子的节点分别为2*i+1,2*i+2
			// 选择出左右孩子较小的下标
			if (i < end && arr[i] < arr[i + 1]) {
				i++;
			}
			if (temp >= arr[i]) {
				break; // 已经为大顶堆，=保持稳定性。
			}
			arr[start] = arr[i]; // 将子节点上移
			start = i; // 下一轮筛选
		}
		arr[start] = temp; // 插入正确的位置
	}
	
	public static void heapSort(int[] arr){
		if (arr == null || arr.length == 0) {
			return ;
		}
		
		// 建立大顶堆
		for (int i = arr.length / 2; i >= 0; i--) {
			heapAdjust(arr, i, arr.length - 1);
		}
		
		for (int i = arr.length - 1; i >= 0; i--) {
			Swap.swap(arr, 0, i);
			heapAdjust(arr, 0, i - 1);
		}
	}

}
