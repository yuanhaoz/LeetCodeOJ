package sortAlgorithm;

import java.util.Arrays;

/**  
 * 如果在面试中有面试官要求你写一个O(n)时间复杂度的排序算法，你千万不要立刻说：这不可能！虽然前面基于比较的排序的下限是O(nlogn)。
 * 但是确实也有线性时间复杂度的排序，只不过有前提条件，就是待排序的数要满足一定的范围的整数，而且计数排序需要比较多的辅助空间。
 * 其基本思想是，用待排序的数作为计数数组的下标，统计每个数字的个数。然后依次输出即可得到有序序列。   
 *  
 * @author 郑元浩 
 * @date 2017年2月18日 下午3:24:16 
 */
public class CountSort {

	public static void main(String[] args) {
		int[] arr = {5, 3, 4, 8, 2};
		countSort(arr);
		System.out.println(Arrays.toString(arr));
	}
	
	public static void countSort(int[] arr){
		if (arr == null || arr.length == 0) {
			return ;
		}
		
		int max = max(arr);
		
		int[] count = new int[max + 1];
		Arrays.fill(count, 0);
		
		for (int i = 0; i < arr.length; i++) {
			count[arr[i]]++;
		}
		
		int k = 0;
		for (int i = 0; i <= max; i++) {
			for (int j = 0; j < count[i]; j++) {
				arr[k++] = i;
			}
		}
	}
	
	public static int max(int[] arr){
		int max = Integer.MIN_VALUE;
		for (int ele : arr) {
			if (ele > max) {
				max = ele;
			}
		}
		return max;
	}

}
