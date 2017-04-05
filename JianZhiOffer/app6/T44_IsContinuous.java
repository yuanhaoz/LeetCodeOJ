package app6;

import java.util.Arrays;

/**  
 * 面试题44：扑克牌的顺子
 * 题目：从扑克牌中随机抽5张牌，判断是不是一个顺子，即这5张牌是不是连续的。2-10位数字本身，A为1，J为11，
 * Q为12，K为13，而大、小王可以看成任意数字。
 * 
 * 思路：
 * 最直观的方法是把数组排序。值得注意的是，由于0是可以当成任意数字，我们可以用0去补满数组中的空缺。如果排序之后的数组
 * 不是连续的，即相邻的两个数字相隔若干个数字，但只要我们有足够的0可以补满这两个数字的空缺，这个数组实际上还是连续的。
 * 举个例子，数组排序之后为{0,1,3,4,5}，在1和3之间空缺了一个2，刚好我们有一个0，也就是我们可以把它当成2去填补这个空缺。
 * 于是我们需要做3件事情：首先把数组排序，再统计数组中0的个数，最后统计排序之后的数组中相邻数字之间的空缺总数。如果空缺的总数
 * 小于或者等于0的个数，那么这个数组就是连续的；反之则不连续。
 * 最后注意一点：如果数组中的非0数字重复出现，则该数组不是连续的。换成扑克牌的描述方式就是如果一副牌里含有对子，则不可能是顺子。
 * 
 * 测试用例：
 * 1. 功能测试：抽出的牌中有一个或者多个大、小王，抽出的牌中没有大、小王，抽出的牌中有对子。
 * 
 * @author 郑元浩 
 * @date 2017年4月5日 上午10:12:53 
 */
public class T44_IsContinuous {

	public static void main(String[] args) {
		int[] numbers1 = {1, 3, 2, 5, 4};
        System.out.println("true: " + isContinuous(numbers1));
        int[] numbers2 = {1, 3, 2, 6, 4};
        System.out.println("false: " + isContinuous(numbers2));
        int[] numbers3 = {0, 3, 2, 6, 4};
        System.out.println("true: " + isContinuous(numbers3));
        int[] numbers4 = {0, 3, 1, 6, 4};
        System.out.println("false: " + isContinuous(numbers4));
        int[] numbers5 = {1, 3, 0, 5, 0};
        System.out.println("true: " + isContinuous(numbers5));
        int[] numbers6 = {1, 3, 0, 7, 0};
        System.out.println("false: " + isContinuous(numbers6));
        int[] numbers7 = {1, 0, 0, 5, 0};
        System.out.println("true: " + isContinuous(numbers7));
        int[] numbers8 = {1, 0, 0, 7, 0};
        System.out.println("false: " + isContinuous(numbers8));
        int[] numbers9 = {3, 0, 0, 0, 0};
        System.out.println("true: " + isContinuous(numbers9));
        int[] numbers10 = {0, 0, 0, 0, 0};
        System.out.println("true: " + isContinuous(numbers10));
        int[] numbers11 = {1, 0, 0, 1, 0};
        System.out.println("false: " + isContinuous(numbers11));
	}
	
	public static boolean isContinuous(int[] numbers) {
		if (numbers == null || numbers.length != 5) {
			return false;
		}
		int zeroCount = 0; // 统计0的个数
		int poorCount = 0; // 数组中需要补0的个数（大王或小王）
		Arrays.sort(numbers); // 对数组从小到大排序
		for (int i = 0; i < numbers.length; i++) {
			if (numbers[i] == 0) {
				zeroCount++;
			}
			if (i < numbers.length - 1 && numbers[i] != 0) {
				if (numbers[i + 1] == numbers[i]) {
					return false;
				}
				poorCount += numbers[i + 1] - numbers[i] - 1; // 计算需要补0的数目
//				System.out.println(i + ",after:" + numbers[i + 1] + ",before:" + numbers[i] + ",poorCount:" + poorCount);
			}
		}
		return zeroCount >= poorCount;
	}

}
