package app6;


/**  
 * 面试题38：数字在排序数组中出现的次数
 * 题目：统计一个数字在排序数组中出现的次数。例如输入排序数组{1,2,3,3,3,3,4,5}和数字3，由于3在这个数组中出现了4次，因此输出4。
 * 
 * 思路：
 * 1. 既然输入的数组是有序的，那么我们很自然地就能想到用二分查找算法。在题目给出的例子中，我们可以先用二分查找算法找到一个3。由于3可能出现多次，因此我们
 * 找到的3的左右两边可能都有3，于是我们在找到的3的左右两边顺序扫描，分别找到第一个3和最后一个3。因为要查找的数字在长度为n的数组中有可能出现O(n)次，所以
 * 顺序扫描的时间复杂度是O(n)。因此这种算法的效率和直接从头到尾顺序扫描整个数组统计3的个数是一样的。
 * 2. 利用二分查找算法直接找到第一个k及最后一个k。二分查找算法总是先拿数组中间的数字和k比较。如果中间的数字比k大，那么k只有可能出现在数组的前半段，下一轮
 * 我们只在数组的前半段查找就可以了。如果中间的数字比k小，那么k只有可能出现在数组的后半段，下一轮我们只在数组的后半段查找就可以了。如果中间的数字和k相等呢？
 * 之前的场景只要直接返回就代表二分查找已经找到该元素了，我们先判断是不是第一个k。如果位于中间数字的前面一个数字不是k，此时中间的数字刚好就是第一个k。如果
 * 中间的数字的前面一个数字也是k，也就是说第一个k肯定在数组的前半段，下一轮我们仍然需要在数组的前半段查找，递归调用即可。查找最后一个元素的过程类似。
 * 时间复杂度是O(logn)。
 * 
 * @author 郑元浩 
 * @date 2017年4月1日 下午2:14:58 
 */
public class T38_GetNumberOfK {
	
	/**
	 * 找排序数组中k第一次出现的位置
	 * @param arr
	 * @param k
	 * @param start
	 * @param end
	 * @return
	 */
	public static int getLeft(int[] arr, int k, int start, int end) {
		if (start > end) {
			return -1;
		}
		int mid = (start + end) / 2;
		if (arr[mid] == k) {
			if ((mid > 0 && arr[mid - 1] != k) || mid == 0) {
				return mid;
			} else {
				end = mid - 1;
			}
		} else if (arr[mid] > k) {
			end = mid - 1;
		} else {
			start = mid + 1;
		}
		return getLeft(arr, k, start, end);
	}
	
	/**
	 * 找排序数组中k最后一次出现的位置
	 * @param arr
	 * @param k
	 * @param start
	 * @param end
	 * @return
	 */
	public static int getRight(int[] arr, int k, int start, int end) {
		if (start > end) {
			return -1;
		}
		int mid = (start + end) / 2;
		if (arr[mid] == k) {
			if ((mid < arr.length - 1 && arr[mid + 1] != k) || mid == arr.length - 1) {
				return mid;
			} else {
				start = mid + 1;
			}
		} else if (arr[mid] > k) {
			end = mid - 1;
		} else {
			start = mid + 1;
		}
		return getRight(arr, k, start, end);
	}
	
	public static int getNumberOfK(int arr[], int k) {
		if (arr == null || arr.length == 0) {
			return 0;
		}
		int number = 0;
		int left = getLeft(arr, k, 0, arr.length - 1);
		int right = getRight(arr, k, 0, arr.length - 1);
		if (left > -1 && right > -1) {
			number = right - left + 1;
		}
		return number;
	}

	public static void main(String[] args) {
		// 查找的数字出现在数组的中间
        int[] data1 = {1, 2, 3, 3, 3, 3, 4, 5};
        System.out.println(getNumberOfK(data1, 3)); // 4

        // 查找的数组出现在数组的开头
        int[] data2 = {3, 3, 3, 3, 4, 5};
        System.out.println(getNumberOfK(data2, 3)); // 4

        // 查找的数组出现在数组的结尾
        int[] data3 = {1, 2, 3, 3, 3, 3};
        System.out.println(getNumberOfK(data3, 3)); // 4

        // 查找的数字不存在
        int[] data4 = {1, 3, 3, 3, 3, 4, 5};
        System.out.println(getNumberOfK(data4, 2)); // 0

        // 查找的数字比第一个数字还小，不存在
        int[] data5 = {1, 3, 3, 3, 3, 4, 5};
        System.out.println(getNumberOfK(data5, 0)); // 0

        // 查找的数字比最后一个数字还大，不存在
        int[] data6 = {1, 3, 3, 3, 3, 4, 5};
        System.out.println(getNumberOfK(data6, 0)); // 0

        // 数组中的数字从头到尾都是查找的数字
        int[] data7 = {3, 3, 3, 3};
        System.out.println(getNumberOfK(data7, 3)); // 4

        // 数组中的数字从头到尾只有一个重复的数字，不是查找的数字
        int[] data8 = {3, 3, 3, 3};
        System.out.println(getNumberOfK(data8, 4)); // 0

        // 数组中只有一个数字，是查找的数字
        int[] data9 = {3};
        System.out.println(getNumberOfK(data9, 3)); // 1

        // 数组中只有一个数字，不是查找的数字
        int[] data10 = {3};
        System.out.println(getNumberOfK(data10, 4)); // 0
	}

}
