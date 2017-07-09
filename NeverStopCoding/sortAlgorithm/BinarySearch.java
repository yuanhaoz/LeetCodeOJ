package sortAlgorithm;
/**  
 * 二分查找   
 *  
 * @author 郑元浩 
 * @date 2017年4月11日 下午3:56:29 
 */
public class BinarySearch {

	public static void main(String[] args) {
		int[] a = {1,2,3,4,5,6,7,8,9};  
        System.out.println(binarySearch(a, 0, a.length - 1, 2));
        System.out.println(binarySearch(a, 2));
	}
	
	// 非递归
	public static int binarySearch(int[] a, int goal) {
		int high = a.length - 1;
		int low = 0;
		int mid = 0;
		while (low <= high) {
			mid = (high - low) / 2 + low; // (high+low)/2容易溢出
			if (a[mid] == goal) {
				return mid;
			} else if (a[mid] < goal) {
				low = mid + 1;
			} else {
				high = mid - 1;
			}
		}
		return -1;
	}
	
	// 递归
	public static int binarySearch(int[] a, int low, int high, int goal) {
		while (low <= high) {
			int mid = (high - low) / 2 + low;
			if (a[mid] == goal) {
				return mid;
			} else if (a[mid] < goal) {
				return binarySearch(a, mid + 1, high, goal);
			} else {
				return binarySearch(a, low, mid - 1, goal);
			}
		}
		return -1;
	}

}
