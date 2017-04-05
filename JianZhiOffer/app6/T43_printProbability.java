package app6;
/**  
 * 面试题43：n个骰子的点数
 * 题目：把n个骰子仍在地上，所有骰子朝上一面的点数之和为s。输入n，打印出s的所有可能的值出现的概率。
 * 
 * 思路：骰子一共有6个面，每个面上的点数在1-6。所以n个骰子的点数和的最小值为n，最大值为6n。另外根据排列组合的知识，
 * 我们还知道n个骰子的所有点数的排列数为6^n。要解决这个问题，我们需要先统计出每一个点数出现的次数，然后把每一个点数
 * 出现的次数除以6^n，就能求出每个点数出现的概率。
 * 
 * 1.基于递归求骰子点数，时间效率不够高
 * 考虑如何统计出每一个点数出现的次数。要想求出n个骰子的点数和，可以先把n个骰子分成两堆：第一堆只有一个，另一个有n-1个。
 * 单独的那一个有可能出现1到6的点数。我们需要计算从1到6的每一种点数和剩下的n-1个骰子来计算点数和。接下来把剩下的n-1个骰子
 * 还是分成两堆，第一堆只有一个，第二堆有n-2个。我们把上一轮那个单独骰子的点数和这一轮单独骰子的点数相加，再和剩下的n-2个骰子
 * 来计算点数和。分析到这里，我们不难发现这是一种递归的思路，递归结束的条件就是最后只剩下一个骰子。
 * 
 * 2.基于循环求骰子点数，时间性能好
 * 我们可以考虑用两个数组来存储骰子点数的每一个总数出现的次数。在一次循环中，第一个数组中的第n个数字表示骰子和为n出现的次数。
 * 在下一个循环中，我们加上一个新的骰子，此时和为n的骰子出现的次数应该等于上一次循环中骰子点数和为n-1、n-2、n-3、n-4、n-5、n-6
 * 的次数的总和，所以我们把另外一个数组的第n个数字设为前一个数组对应的第n-1、n-2、n-3、n-4、n-5与n-6之和。
 *  
 * @author 郑元浩 
 * @date 2017年4月5日 上午9:16:44 
 */
public class T43_printProbability {

	public static void main(String[] args) {
        test01();
        test02();
    }

    private static void test01() {
        printProbability(2, 4);
    }

    private static void test02() {
        printProbability2(2, 4);
    }
	
	/**
	 * 基于递归求解
	 * @param number 骰子个数（n）
	 * @param max 骰子的最大值（6）
	 */
	public static void printProbability(int number, int max) {
		if (number < 1 || max < 1) {
			return ;
		}
		int maxSum = number * max; // 点数和最大的数，即为6n
		int[] probabilities = new int[maxSum - number + 1]; // 大小为6n-n+1的数组用于存放点数和的可能情况
		probability(number, probabilities, max); // 递归调用
		// 计算总共出现的可能情况
		double total = 1;
		for (int i = 0; i < number; i++) {
			total *= max;
		}
		// 打印出每种和出现的概率
		for (int i = number; i <= maxSum; i++) {
			double ratio = probabilities[i - number] / total;
			System.out.printf("%-8.4f", ratio);
		}
		System.out.println();
	}
	
	/**
	 * 
	 * @param number 骰子个数
	 * @param probabilities 不同骰子出现次数的计数数组
	 * @param max 骰子的最大值
	 */
	public static void probability(int number, int[] probabilities, int max) {
		for (int i = 1; i <= max; i++) {
			probability(number, number, i, probabilities, max);
		}
	}
	
	/**
	 * 
	 * @param original 总的骰子数（n，数值基本不变）
	 * @param current 当前处理的是第几个（每次循环减1）
	 * @param sum 已经前面的骰子数和
	 * @param probabilities 不同骰子数出现次数的计数数组
	 * @param max 骰子的最大值
	 */
	public static void probability(int original, int current, int sum, int[] probabilities, int max) {
		if (current == 1) {
			probabilities[sum - original]++;
		} else {
			for (int i = 1; i <= max; i++) {
				probability(original, current - 1, i + sum, probabilities, max);
			}
		}
	}
	
	/**
	 * 基于循环求解
	 * @param number 骰子个数
	 * @param max 骰子的最大值
	 */
	public static void printProbability2(int number, int max) {
		if (number < 1 || max < 1) {
			return ;
		}
		
		int[][] probabilities = new int[2][max * number + 1]; // 初始数组大小为2*（6n+1）
		// 数据初始化
		for (int i = 0; i < max * number + 1; i++) {
			probabilities[0][i] = 0;
			probabilities[1][i] = 0;
		}
		// 标记当前要使用的是第0个数组还是第1个数组
		int flag = 0;
		// 抛出一个骰子时出现的各种情况
		for (int i = 0; i <= max; i++) {
			probabilities[flag][i] = 1;
		}
		// 抛出其它骰子
		for (int k = 2; k <= number; k++) {
			// 如果抛出了k个骰子，那么和为[0, k-1]出现的次数为0
			for (int i = 0; i < k; i++) {
				probabilities[1 - flag][i] = 0; // 设置第二个数组
			}
			// 抛出k个骰子，所有和的可能
			for (int i = k; i <= max * k; i++) {
				probabilities[1 - flag][i] = 0;
				
				// 每个骰子的出现的所有可能的点数
				for (int j = 1; j <= i && j <= max; j++) {
					// 统计出和为i的点数出现的次数
					probabilities[1 - flag][i] += probabilities[flag][i - j];
				}
			}
			flag = 1 - flag;
		}
		
		// 计算总共出现的可能情况
		double total = 1;
		for (int i = 0; i < number; i++) {
			total *= max;
		}
		// 打印出每种和出现的概率
		int maxSum = number * max;
		for (int i = number; i <= maxSum; i++) {
			double ratio = probabilities[flag][i] / total;
			System.out.printf("%-8.4f", ratio);
		}
		System.out.println();
	}

}
