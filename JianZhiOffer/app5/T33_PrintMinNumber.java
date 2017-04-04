package app5;

import java.util.Comparator;

/**  
 * 面试题33：把数组排成最小的数
 * 题目：输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
 * 例如输入数组{3,32,321}，则打印出这3个数字能排成的最小数字321323。
 * 
 * 思路：
 * 本题希望我们能找到一个排序规则，数组根据这个规则排序之后能排成一个最小的数字。要确定排序规则，就要比较两个数字。
 * 两个数字m和n能拼接成数字mn和nm。如果mn<nm，那么我们应该打印出mn，也就是m应该排在n的前面，我们定义此时m小于n;
 * 反之，如果nm<mn，我们定义n小于m。如果mn=nm，m等于n。
 * 
 * 本题考点：
 * 本题有两个难点：第一个难点是想出一种新的比较规则来排序一个数组；第二个难点在于证明这个比较规则是有效的，并且
 * 证明根据这个规则排序之后把数组中所有数字拼接起来得到的数字是最小的。要求很强的数学功底和逻辑思维能力。
 * 考查解决大数问题的能力。应聘者在面试的时候要意识到，把两个int型的整数拼接起来得到的数字可能会超出int型
 * 数字能够表达的范围，从而导致数字溢出。我们可以用字符串表示数字，这样就能简洁地解决大数问题。
 *  
 * @author 郑元浩 
 * @date 2017年3月29日 上午10:29:42 
 */
public class T33_PrintMinNumber {
	
	/**
     * 自定义的排序比较器，实现算法说明的排序原理
     */
	private static class MComparator implements Comparator<String> {

		@Override
		public int compare(String o1, String o2) {
			if (o1 == null || o2 == null) {
				throw new IllegalArgumentException("Arg should not be null");
			}
			String s1 = o1 + o2;
			String s2 = o2 + o1;
			return s1.compareTo(s2);
		}
		
	}
	
	/**
	 * 快速排序算法
	 * 
	 * @param array 待排序数组
	 * @param start 要排序的起始位置
	 * @param end 要排序的结束位置
	 * @param comparator 自定义的比较器
	 */
	public static void quickSort(String[] array, int start, int end, Comparator<String> comparator) {
		if (start < end) {
			String pivot = array[start];
			int left = start;
//			int right = end;
			while (start < end) {
				while (start < end && comparator.compare(array[end], pivot) >= 0) {
					end--;
				}
				array[start] = array[end];
				while (start < end && comparator.compare(array[start], pivot) <= 0) {
					start++;
				}
				array[end] = array[start];
			}
			array[start] = pivot;
			quickSort(array, left, start - 1, comparator);
			quickSort(array, start + 1, end, comparator);
		}
	}
	
	/**
	 * 题目：输入一个正整数数组，把数组里所有数字拼接起来排成一个数，
     * 打印能拼接出的所有数字中最小的一个。
     * @param array 输入的数组
     * @return 输出结果
	 */
	public static String printMinNumber(String[] array) {
		if (array == null || array.length < 1) {
			throw new IllegalArgumentException("Array must contain value");
		}
		MComparator comparator = new MComparator();
		quickSort(array, 0, array.length - 1, comparator);
		
		StringBuilder builder = new StringBuilder(256);
		for (String s : array) {
			builder.append(s);
		}
		return builder.toString();
	}

	public static void main(String[] args) {
		String[] data = {"3", "5", "1", "4", "2"};
        System.out.println(printMinNumber(data));

        String[] data2 = {"3", "32", "321"};
        System.out.println(printMinNumber(data2));

        String[] data3 = {"3", "323", "32123"};
        System.out.println(printMinNumber(data3));

        String[] data4 = {"1", "11", "111"};
        System.out.println(printMinNumber(data4));

        String[] data5 = {"321"};
        System.out.println(printMinNumber(data5));
	}

}
