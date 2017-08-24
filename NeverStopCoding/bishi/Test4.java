package bishi;

import java.util.Scanner;

/**
 * 今日头条 2018校招 后端方向试卷在线考试
编程题 | 20.0分 1/3
第1题
时间限制：C/C++语言 1000MS；其他语言 3000MS
内存限制：C/C++语言 65536KB；其他语言 589824KB
题目描述：
P为给定的二维平面整数点集。定义 P 中某点x，如果x满足 P 中任意点都不在 x 的右上方区域内（横纵坐标都大于x），则称其为“最大的”。求出所有“最大的”点的集合。（所有点的横坐标和纵坐标都不重复, 坐标轴范围在[0, 1e9) 内）
如下图：实心点为满足条件的点的集合。

请实现代码找到集合 P 中的所有 ”最大“ 点的集合并输出。
输入
第一行输入点集的个数 N， 接下来 N 行，每行两个数字代表点的 X 轴和 Y 轴。
输出
输出“最大的” 点集合， 按照 X 轴从小到大的方式输出，每行两个数字分别代表点的 X 轴和 Y轴。

样例输入
5
1 2
5 3
4 6
7 5
9 0
样例输出
输出结果按照 x 轴排序，如上例输出为：
4 6
7 5
9 0

Hint
对于 50%的数据,  1 <= n <= 10000;
对于 100%的数据, 1 <= n <= 500000;
 * @author 郑元浩
 * @date 2017年8月22日 下午8:06:11
 *
 */
public class Test4 {
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt(); // 点的个数
		int[] x = new int[n]; // 横坐标
		int[] y = new int[n]; // 纵坐标
		for (int i = 0; i < n; i++) {
			x[i] = in.nextInt();
			y[i] = in.nextInt();
		}
		if (n == 1) {
			System.out.println(x[0] + " " + y[0]);
		}
//		int xMax = 0;
//		int yMax = 0;
//		for (int i = 0; i < n; i++) {
//			if (x[i] > xMax) {
//				xMax = x[i];
//			}
//		}
//		for (int i = 0; i < n; i++) {
//			if (y[i] > yMax) {
//				yMax = y[i];
//			}
//		}
//		for (int i = 0; i < n; i++) {
//			if (x[i] == xMax || y[i] == yMax) {
//				System.out.println(x[i] + " " + y[i]);
//			}
//		}
		
		for (int i = 0; i < n; i++) {
			boolean flag = true;
			for (int j = i + 1; j < n; j++) {
				if (i != j) {
					if (x[j] > x[i] && y[j] > y[i]) {
						flag = false;
						break;
					}
				}
			}
			if (flag) {
				System.out.println(x[i] + " " + y[i]);
			}
		}
	}
	
}
