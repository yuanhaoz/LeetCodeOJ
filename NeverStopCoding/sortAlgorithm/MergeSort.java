package sortAlgorithm;

import java.util.Arrays;

/**  
 * 　归并排序是另一种不同的排序方法，因为归并排序使用了递归分治的思想，所以理解起来比较容易。
 * 其基本思想是，先递归划分子问题，然后合并结果。把待排序列看成由两个有序的子序列，然后合并两个子序列，然后把子序列看成由两个有序序列。。。。。
 * 倒着来看，其实就是先两两合并，然后四四合并。。。最终形成有序序列。
 * 
 * 空间复杂度为O(n)，时间复杂度为O(nlogn)。
 *  
 * @author 郑元浩 
 * @date 2017年2月18日 下午3:13:01 
 */
public class MergeSort {

	public static void main(String[] args) {
		int[] arr = {5, 3, 4, 8, 2};
		mergeSort(arr);
		System.out.println(Arrays.toString(arr));
	}
	
	public static void mergeSort(int[] arr){
		mSort(arr, 0, arr.length - 1);
	}
	
	/**
	 * 
	 * @param arr
	 * @param left
	 * @param right
	 */
	public static void mSort(int[] arr, int left, int right) {
		if (left >= right) {
			return ;
		}
		int mid = (left + right) / 2;
		
		mSort(arr, left, mid); // 递归排序左边
		mSort(arr, mid + 1, right); // 递归排序右边
		merge(arr, left, mid, right); // 合并
	}
	
	public static void merge(int[] arr, int left, int mid, int right) {
		// [left, mid] [mid+1, right]
		int[] temp = new int[right - left + 1]; // 中间数组
		
		int i = left;
		int j = mid + 1;
		int k = 0;
		while (i <= mid && j <= right) {
			if (arr[i] <= arr[j]) {
				temp[k++] = arr[i++];
			} else {
				temp[k++] = arr[j++];
			}
		}
		
		while (i <= mid) {
			temp[k++] = arr[i++];
		}
		
		while (j <= right) {
			temp[k++] = arr[j++];
		}
		
		for (int p = 0; p < temp.length; p++) {
			arr[left + p] = temp[p];
		}
	}

}
