package app4;

import java.util.Stack;

/**  
 * 面试题21：包含min函数的栈
 * 题目：定义栈的数据结构，请在该类型中实现一个能够得到栈的最小元素的min函数。
 * 在该栈中，调用min, push, pop的时间复杂度都是O(1)。 
 * 
 * 思路：
 * 1. 一种思路是在栈里添加一个成员变量存放最小的元素。每次压入一个新元素进栈的时候，如果该元素比当前最小的元素还小，那就更新最小元素。但是有一个问题是
 * 如果当前最小的元素被弹出栈了，如何得到下一个最小的元素呢？仅仅添加一个成员变量存放最小元素是不够的，也就是说当最小元素被弹出栈的时候，我们希望能够得
 * 到次小元素。因此，考虑使用把每次的最小元素保存起来放到另外一个辅助栈里。
 *  
 * @author 郑元浩 
 * @date 2017年3月26日 上午10:17:51 
 */

/**
 * 按照剑指offer上面实现的栈，比较简单，离完美还有一定差距
 */
class MinStackSimple{
	Stack<Integer> dataStack; // 保存该栈的数据
	Stack<Integer> minStack; // 保存该栈的最小值
	
	/**
	 * 入栈：
	 * 数据栈直接保存元素
	 * 最小值栈存入最小元素
	 * @param value
	 */
	public void push(Integer value){
		dataStack.push(value); // 数据栈压入数据
		// 压入最小值
		if (minStack.isEmpty() || minStack.peek() > value) {
			minStack.push(value);
		} else {
			minStack.push(minStack.peek());
		}
	}
	
	/**
	 * 出栈：
	 * 同时弹出两个栈中的元素
	 * 如果栈为空则打印信息
	 */
	public void pop(){
		if (!dataStack.isEmpty() && !minStack.isEmpty()) {
			dataStack.pop();
			minStack.pop();
		} else {
			System.out.println("栈为空。。。");
		}
		
	}
	
	/**
	 * 得到当前栈的最小元素，如果栈为空则返回0
	 * @return 当前栈的最小元素
	 */
	public int min(){
		if (!minStack.isEmpty()) {
			return minStack.peek();
		} else {
			return 0;
		}
	}
}


public class T21_MinStack {
	
	/**
	 * 定义栈的数据结构，请在该类型中实现一个能够得到校的最小元素的min函数。
     * 在该栈中，调用pop、push 及min的时间复杂度都是0(1)
	 *
	 * @param <T> 泛型参数
	 */
	public static class StackWithMin<T extends Comparable<T>> {
		// 数据栈，用于存放插入的数据
		private Stack<T> dataStack;
		// 最小数位置栈，存放数据栈中最小的数的位置
		private Stack<Integer> minStack;
		
		// 构造函数
		public StackWithMin() {
			this.dataStack = new Stack<>();
			this.minStack = new Stack<>();
		}
		
		/**
		 * 出栈方法
		 * @return 栈顶元素
		 */
		public T pop(){
			// 如果栈已经为空，再出栈抛出异常
			if (dataStack.isEmpty()) {
				throw new RuntimeException("The stack is already empty");
			}
			
			// 如果有数据，最小数位置栈和数据栈必定有相同的元素个数，两个栈同时出栈
			minStack.pop();
			return dataStack.pop();
		}
		
		/**
		 * 元素入栈
		 * @param t 入栈的元素
		 */
		public void push(T t) {
			// 如果入栈的元素为空就抛出异常
			if (t == null) {
				throw new RuntimeException("Element can be null");
			}
			// 如果数据栈是空的，只要将元素入栈，同时更新最小栈中的数据
			if (dataStack.isEmpty()) {
				dataStack.push(t);
				minStack.push(0);
			} else {
				T e = dataStack.get(minStack.peek()); // 获取最小元素
				dataStack.push(t); // 入数据栈
				if (t.compareTo(e) < 0) { // 将最小值入最小栈
					minStack.push(dataStack.size() - 1);
				} else {
					minStack.push(minStack.peek());
				}
			}
		}
		
		/**
		 * 获取数据栈的最小元素
		 * @return 栈中的最小元素
		 */
		public T min() {
			// 如果最小数公位置栈已经为空，则抛出异常
			if (minStack.isEmpty()) {
				throw new RuntimeException("No element in stack.");
			}
			// 获取数据栈中的最小元素，并且返回结果
			return dataStack.get(minStack.peek());
		}
		
		
		public static void main(String[] args) {
			StackWithMin<Integer> stack = new StackWithMin<>();
			stack.push(3);
			System.out.println(stack.min() == 3);
			stack.push(4);
			System.out.println(stack.min() == 3);
			stack.push(2);
			System.out.println(stack.min() == 2);
			stack.push(3);
			System.out.println(stack.min() == 2);
			stack.pop();
			System.out.println(stack.min() == 2);
			stack.pop();
			System.out.println(stack.min() == 3);
			stack.push(0);
			System.out.println(stack.min() == 0);
		}
		
	}
	
}

