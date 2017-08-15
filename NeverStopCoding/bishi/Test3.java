package bishi;

import java.util.Scanner;

/**  
 *  
 * @author 郑元浩 
 * @date 2017年3月7日 下午7:25:51 
 */
public class Test3 {
	
	private static int count = 0;

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt(); // 2  数列长度n
		int k = in.nextInt(); // 2  数列中的每个数都在1到k之间
		// 数列性质：A<=B || A mod B != 0
		int[] arr = new int[n];
		for (int i = 1; i <= k; i++) {
			arr[0] = i;
			love(arr, n, k, 0);
		}
		System.out.println(count%1000000007);
	}
	
	public static void love(int[] arr, int n, int k, int index) {
		if (index == n - 1) {
			count++;
			return ;
		}
		for (int i = 1; i <= k; i++) {
			arr[index + 1] = i;
			if (arr[index] <= arr[index + 1] || arr[index] % arr[index + 1] != 0) {
				love(arr, n, k, index + 1);
			}
		}
	}
	
	public static void love2(int[] arr, int n, int k, int index) {
		if (index == n - 1) {
			int i = 0;
			boolean flag = true;
			while (i < n - 1) {
				if (arr[i] <= arr[i+1] || arr[i] % arr[i+1] != 0) {
					i++;
				} else {
					flag = false;
					break;
				}
			}
			if (flag) {
				count++;
			}
			return ;
		}
		for (int i = 1; i <= k; i++) {
			arr[index + 1] = i;
			love(arr, n, k, index + 1);
		}
	}
	
}
