package bishi;

import java.util.Scanner;

/**  
 *  
 * @author 郑元浩 
 * @date 2017年3月7日 下午7:25:51 
 */
public class Test2 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt(); // 4 [1-50] 棋子的个数
		int[] x = new int[n]; // n个棋子的横坐标 [1-10^9]
		int[] y = new int[n]; // n个棋子的纵坐标 [1-10^9]
		for (int i = 0; i < n; i++) {
			x[i] = in.nextInt();
		}
		for (int i = 0; i < n; i++) {
			y[i] = in.nextInt();
		}
		
		// 有一个格子中至少有num个棋子，所需要的最小操作次数
		System.out.print(0 + " ");
		for (int num = 2; num <= n; num++) {
			
		}
		
	}
	
}
