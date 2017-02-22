package sortAlgorithm;

import java.util.Arrays;

/**  
 * 交换数组的元素值   
 *  
 * @author 郑元浩 
 * @date 2017年2月17日 下午4:04:45 
 */
public class Swap {

	public static void main(String[] args) {
		int[] arr = {5, 3, 4, 8, 6};
		swap(arr, 0, 1);
		System.out.println(Arrays.toString(arr));
	}
	
	/**
	 *  交换数组特定的两个位置上的值
	 * @param arr
	 * @param i
	 * @param j
	 */
	public static void swap(int[] arr, int i, int j){
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

}
