package sortAlgorithm;

import java.util.Arrays;

/**  
 * 插入排序:
 * 
 * 不是通过交换位置而是通过比较找到合适的位置插入元素来达到排序的目的的。
 * 相信大家都有过打扑克牌的经历，特别是牌数较大的。在分牌时可能要整理自己的牌，牌多的时候怎么整理呢？
 * 就是拿到一张牌，找到一个合适的位置插入。这个原理其实和插入排序是一样的。
 * 举个例子，对5,3,8,6,4这个无序序列进行简单插入排序，首先假设第一个数的位置时正确的，想一下在拿到第一张牌的时候，没必要整理。
 * 然后3要插到5前面，把5后移一位，变成3,5,8,6,4.想一下整理牌的时候应该也是这样吧。
 * 然后8不用动，6插在8前面，8后移一位，4插在5前面，从5开始都向后移一位。注意在插入一个数的时候要保证这个数前面的数已经有序。
 * 
 * 简单插入排序的时间复杂度也是O(n^2)。   
 *  
 * @author 郑元浩 
 * @date 2017年2月17日 下午4:24:26 
 */
public class InsertSort {

	public static void main(String[] args) {
		int[] arr = {5, 3, 4, 8, 6};
		insertSort(arr);
		System.out.println(Arrays.toString(arr));
	}
	
	public static void insertSort(int[] arr){
		if (arr == null || arr.length == 0) {
			return ;
		}
		
		for (int i = 1; i < arr.length; i++) { // 假设第一个数位置是正确的；要往后移，必须要假设第一个。
			
			int j = i;
			int target = arr[i]; // 待插入的
			
			// 后移
			while (j > 0 && target < arr[j - 1]) {
				arr[j] = arr[j - 1]; // 大于需要插入的数的元素都需要往后移动一位
				j--;
			}
			
			// 插入
			arr[j] = target;
		}
	}
	
}
