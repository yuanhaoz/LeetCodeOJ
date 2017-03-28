package app4;

import java.util.Stack;

/**  
 * 面试题22：栈的压入、弹出序列
 * 题目：输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否为该栈的弹出序列。
 * 
 * 思路：
 * 1. 如果下一个弹出的数字刚好是栈顶数字，那么直接弹出。如果下一个弹出的数字不在栈顶，我们把压栈序列中还没有入栈的数字压入辅助栈，直到
 * 把下一个需要弹出的数字压入栈顶为止。如果所有的数字都压入栈了仍然没有找到下一个弹出的数字，那么该序列不可能是一个弹出序列。
 *  
 * @author 郑元浩 
 * @date 2017年3月26日 下午3:56:07 
 */
public class T22_IsPopOrder {

	/**
	 * 输入两个整数序列，第一个序列表示栈的压入顺序，请判断二个序列是否为该栈的弹出顺序。
     * 假设压入栈的所有数字均不相等。例如序列1 、2、3 、4、5 是某栈压栈序列，
     * 序列4、5、3、2、1是该压栈序列对应的一个弹出序列，
     * 但4、3、5、1、2就不可能是该压棋序列的弹出序列。
     * 【与书本的的方法不同】
     *
     * @param push 入栈序列
     * @param pop  出栈序列
     * @return true：出栈序列是入栈序列的一个弹出顺序
	 */
	public static boolean isPopOrder(int[] push, int[] pop){
		// 输入校验，参数不能为空，并且两个数组中必须有数字，并且两个数组中的数字个数相同，否则返回false
		if (push == null || pop == null || pop.length == 0 || push.length == 0 || push.length != pop.length) {
			return false;
		}
		
		// 经过上面的参数校验，两个数组中一定有数据，且数据数目相等
		// 用于存放入栈时的数据
		Stack<Integer> stack = new Stack<Integer>();
		// 用于记录入栈数组或出栈数组的处理位置
		int pushIndex = 0;
		int popIndex = 0;
		// 
		while (popIndex < pop.length) {
			// 判断如果栈顶不是出栈元素则不断入栈，考虑队列一开始是空
			while (pushIndex < push.length && (stack.isEmpty() || stack.peek() != pop[popIndex])) {
				stack.push(push[pushIndex]);
				pushIndex++;
			}
			// 判断栈顶元素是不是当前元素相同（不对的出栈的情况）
			if (stack.peek() == pop[popIndex]) {
				stack.pop();
				popIndex++;
			} else {
				return false; // 否则返回不对
			}
		}
		return true;
	}
	
	/**
	 * 输入两个整数序列，第一个序列表示栈的压入顺序，请判断二个序列是否为该栈的弹出顺序。
     * 【按书本上的思路进行求解，两者相差不大】
     *
     * @param push 入栈序列
     * @param pop  出栈序列
     * @return true：出栈序列是入栈序列的一个弹出顺序
	 */
	public static boolean isPopOrder2(int[] push, int[] pop){
		// 用于记录判断出栈顺序是不是入栈顺序的一个出栈序列，默认是false
		boolean isPossible = false;
		// 当入栈和出栈数组者都不为空，并且都有数据，并且数据个数都相等
		if (push != null && pop != null && push.length > 0 && push.length == pop.length) {
			Stack<Integer> stack = new Stack<Integer>();
			int nextPush = 0;
			int nextPop = 0;
			// 如果出栈元素没有处理完就继续进行处理
			while (nextPop < pop.length) {
				// 如果栈为空或者栈顶的元素与当前处理的出栈元素不相同，一直进行操作
				while (stack.isEmpty() || stack.peek() != pop[nextPop]) {
					// 如果入栈的元素已经全部入栈了，就退出内层循环
					if (nextPush >= push.length) {
						break;
					}
					// 执行到此处说明还有入栈元素可以入栈
					// 即将元素入栈
					stack.push(push[nextPush]);
					// 指向下一个要处理的入栈元素的位置
					nextPush++;
				}
				
				// 执行到此处有两种情况：
				// 第一种：在栈顶上找到了一个与入栈元素相等的元素
				// 第二种：在栈顶上没有找到一个与入栈元素相等的元素，而且输入栈的元素已经全部入栈了
				
				// 对于第二种情况就说弹出栈的顺序是不符合要求的，退出外层循环
				if (stack.peek() != pop[nextPop]) {
					break;
				}
				// 对于第一种情况：需要找到栈的栈顶元素弹出
				stack.pop();
				nextPop++;
			}
			
			// 对于出现的第一种情况其stack.isEmpty()必不为空，原因为分析如下：
            // 所有的入栈元素一定会入栈，但是只有匹配的情况下才会出栈，
            // 匹配的次数最多与入栈元素个数元素相同（两个数组的长度相等），如果有不匹配的元素，
            // 必然会使出栈的次数比入栈的次数少，这样栈中至少会有一个元素
            // 对于第二种情况其stack.isEmpty()一定为空
            // 所以书本上的nextPop == pop.length（pNextPop-pPop==nLength）是多余的
            if (stack.isEmpty()) {
                isPossible = true;
            }
		}
		
		return isPossible;
		
	}
	
	public static void main(String[] args) {
		int[] push = {1, 2, 3, 4, 5};
		int[] pop = {4, 5, 3, 2, 1};
		int[] pop1 = {4, 3, 5, 1, 2};
		System.out.println(isPopOrder(push, pop));
		System.out.println(isPopOrder(push, pop1));
	}

}
