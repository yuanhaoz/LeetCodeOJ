package bishi;

import java.util.Scanner;

/**  
 *  
 * @author 郑元浩 
 * @date 2017年3月7日 下午7:25:51 
 */
public class Test1 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int x = in.nextInt(); // 3        每天支付房屋租金
		int f = in.nextInt(); // 5        目前已有水果数量
		int d = in.nextInt(); // 100  目前已有金钱
		int p = in.nextInt(); // 10     水果售价
		
		// 时间复杂度高
//		int day = 0; // 生存天数
//		while (d > 0) { // 还有钱
//			day++; // 多生活一天
//			d -= x;
//			if (f > 0) {
//				f--;
//			} else {
//				d -= p;
//			}
////			System.out.println("第"+day+"天，剩余"+d+"元");
//		}
//		System.out.println(day - 1);
		
		// 全部通过
		// 在f天内花完
		if (d - x * f <= 0) {
			System.out.println(d / x);
		} else { // 在f天之外花完
			d = d - x * f;
			System.out.println(d / (x + p) + f);
		}
		
	}
	
}
