package app4;
/**  
 * 面试题28：字符串的排列
 * 题目：输入一个字符串，打印出该字符串中字符的所有排序。例如输入字符串abc，则打印出由字符a/b/c所能排列出来的所有字符串abc/acb/bac/bca/cab/cba。   
 * 
 * 思路：
 * 我们把一个字符串看成由两部分组成：第一部分为它的第一个字符，第二部分是后面的所有字符。求整个字符串的排列，可以看成两步：
 * 首先求所有可能出现在第一个位置的字符，即把第一个字符和后面所有的字符交换。首先固定第一个字符，求后面所有字符的排列。这个时候我们仍把
 * 后面的所有字符分成两个部分：后面字符的第一个字符，以及这个字符之后的所有字符。然后把第一个字符逐一和它后面的字符交换。。。
 * 
 * 本题扩展：
 * 1. 如果不是求字符的所有排列，而是求字符的所有组合，那应该怎么办呢？还是输入三个字符a/b/c，则他们的组合有a/b/c/ab/ac/bc/abc。
 * 当交换字符串中的两个字符时，虽然能得到两个不同的排序，但却是同一个组合。比如ab和ba是不同的排列，但只能算一个组合。
 * 答：如果输入n个字符，则这n个字符能构成长度为1的组合、长度为2的组合、...、长度为n的组合。在求n个字符的长度为m(1<=m<=n)的组合的时候，
 * 我们把这n个字符分成两部分：第一个字符和其余的所有字符。如果组合里包含第一个字符，则下一步在剩余的字符里选取m-1个字符；如果组合里不包含第一个字符，
 * 则下一步在剩余的n-1个字符里选取m个字符。也就是说，我们可以把求n个字符组成长度为m的组合问题分解成两个子问题，分别求n-1个字符串中长度为m-1的组合，
 * 以及求n-1个字符的长度为m的组合。这两个子问题都可以用递归的方式解决。
 * 
 * 相关题目：
 * 1. 输入一个含有8个数字的数组，判断有没有可能把这8个数字分别放到正方体的8个顶点上，使得正方体上三组相对的面上的4个顶点的和都相等。
 * 这相当于先得到a1-a8这8个数字的所有排列，然后判断有没有某一种的排列符合题目给定的条件，即a1+a2+a3+a4=a5+a6+a7+a8,
 * a1+a3+a5+a7=a2+a4+a6+a8, a1+a2+a5+a6=a3+a4+a7+a8。
 * 
 * 2. 在8*8的国际象棋上摆放8个皇后，使其不能相互攻击，即任意两个皇后不得处在同一行、同一列或者同一对角线上。请问总共有多少种符合条件的摆法？
 * 由于8个皇后的任意两个不能处在同一行，那么肯定是每一个皇后占据一行。于是我们可以定义一个数组ColumnIndex[8]，数组中第i个数字表示位于
 * 第i行的皇后的列号。先把数组ColumnIndex的8个数字分别用0-7初始化，接下来就是对数组ColumnIndex做全排列。因为我们是用不同的数字初始化
 * 数组，所以任意两个皇后肯定不同列。我们只需要判断每一个排列对应的8个皇后是不是在同一对角线上，也就是说对于数组的两个下标i和j，是不是
 * i-j==ColumnIndex[i]-ColumnIndex[j]或者j-i=ColumnIndex[i]-ColumnIndex[j]。
 * 
 * @author 郑元浩 
 * @date 2017年3月28日 上午10:11:43 
 */
public class T28_Permutation {
	
	/**
	 * 题目：输入一个字符串，打印出该字符事中字符的所有排列。例如输入字符串abc。
     * 则打印出由字符a、b、c 所能排列出来的所有字符串abc、acb、bac、bca、cab和cba。
     *
     * @param chars 待排序的字符数组
	 */
	public static void permutation(char[] chars) {
		// 输入校验
		if (chars == null || chars.length < 1) {
			return ;
		}
		// 进行排列操作
		permutation(chars, 0);
	}
	
	/**
	 * 求字符数组的排列
	 * 
	 * @param chars 待排序的字符串
	 * @param begin 当前处理的位置
	 */
	public static void permutation(char[] chars, int begin) {
		// 如果是最后一个元素了，就输出排列结果
		if (chars.length - 1 == begin) {
			System.out.print(new String(chars) + " ");
		} else {
			char tmp;
			// 对当前还未处理的字符串进行处理，每个字符都可以作为当前处理位置的元素
			for (int i = begin; i < chars.length; i++) {
				// 下面是交换元素的位置
				tmp = chars[begin];
				chars[begin] = chars[i];
				chars[i] = tmp;
				
				// 处理下一个位置
				permutation(chars, begin + 1);
				
				// 恢复元素的位置
				tmp = chars[begin];
				chars[begin] = chars[i];
				chars[i] = tmp;
			}
		}
		
	}

	public static void main(String[] args) {
		char[] c1 = {'a', 'b', 'c'};
		permutation(c1);
		System.out.println();
		
		char[] c2 = {'a', 'b', 'c', 'd'};
		permutation(c2);
	}

}
