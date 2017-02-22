package sortAlgorithm;

import java.util.Arrays;

/**  
 * 希尔排序是插入排序的一种高效率的实现，也叫缩小增量排序。简单的插入排序中，如果待排序列是正序时，时间复杂度是O(n)，如果序列是基本有序的，使用直接插入排序效率就非常高。
 * 希尔排序就利用了这个特点。基本思想是：先将整个待排记录序列分割成为若干子序列分别进行直接插入排序，待整个序列中的记录基本有序时再对全体记录进行一次直接插入排序。
 * 
 * 从上述排序过程可见，希尔排序的特点是，子序列的构成不是简单的逐段分割，而是将某个相隔某个增量的记录组成一个子序列。
 * 如上面的例子，第一趟排序时的增量为5，第二趟排序的增量为3。由于前两趟的插入排序中记录的关键字是和同一子序列中的前一个记录的关键字进行比较，
 * 因此关键字较小的记录就不是一步一步地向前挪动，而是跳跃式地往前移，从而使得进行最后一趟排序时，整个序列已经做到基本有序，
 * 只要作记录的少量比较和移动即可。因此希尔排序的效率要比直接插入排序高。
 * 
 * 希尔排序的分析是复杂的，时间复杂度是所取增量的函数，这涉及一些数学上的难题。但是在大量实验的基础上推出当n在某个范围内时，时间复杂度可以达到O(n^1.3)。
 *  
 * @author 郑元浩 
 * @date 2017年2月18日 下午2:59:48 
 */
public class ShellSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {5, 3, 4, 8, 2};
		shellSort(arr);
		System.out.println(Arrays.toString(arr));
	}
	
	/**
	 * 希尔排序的一趟排序
	 * @param arr 待排数组
	 * @param d 增量
	 */
	public static void shellInsert(int[] arr, int d){
		for (int i = d; i < arr.length; i++) {
			int j = i - d;
			int temp = arr[i]; // 记录要插入的数据
			while (j >= 0 && arr[j] > temp) { // 从后向前，找到比其小的数的位置
				arr[j + d] = arr[j]; // 向后挪动
				j -= d;
			}
			
			if (j != i - d) { // 存在比其小的数
				arr[j + d] = temp;
			}
		}
	}
	
	public static void shellSort(int[] arr){
		if (arr == null || arr.length == 0) {
			return ;
		}
		int d = arr.length / 2;
		while (d >= 1) {
			shellInsert(arr, d);
			d /= 2;
		}
	}

}
