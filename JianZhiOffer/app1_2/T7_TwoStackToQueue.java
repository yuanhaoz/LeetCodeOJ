package app1_2;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**  
 * 面试题目7：
 * 用两个栈实现一个队列。队列的声明如下，请实现它的两个函数appendTail和deleteHead，
 * 分别完成在队列尾部插入节点和在队列头部删除节点的功能。
 *
 * 相关题目：
 * 用两个队列实现一个栈。
 *  
 * @author 郑元浩 
 * @date 2017年3月12日 下午5:08:12 
 */
public class T7_TwoStackToQueue {
	
	// 插入栈，只用于插入的数据
	Stack<Integer> stack1 = new Stack<Integer>();
    // 弹出栈，只用于弹出数据
	Stack<Integer> stack2 = new Stack<Integer>();
    
	// 添加操作，都在队列尾部插入节点
    public void push(int node) {
    	stack1.add(node);
    }
    
    // 删除操作，在队列头部删除节点
    public int pop() {
    	
    	// 先判断弹出栈是否为空，如果为空就将插入栈的所有数据弹出栈
    	// 并且将弹出的数据压入弹出栈中
    	if (stack2.empty()) {
        	while(!stack1.isEmpty()){
        		stack2.push(stack1.pop());
        	}
		}
    	
    	// 如果弹出栈中还没有数据就抛出异常
    	if (stack2.empty()) {
			throw new RuntimeException("No more element.");
		}
    	
    	// 返回弹出栈的栈顶元素，对应的就是队首元素。
    	return stack2.pop();
    }

	public void push2(int node) {
		stack1.push(node);
	}

	public int pop2() {
		if (stack2.isEmpty()) {
			while (!stack1.isEmpty()) {
				int data = stack1.pop();
				stack2.push(data);
			}
		}
		if (stack2.isEmpty()) {
			throw new RuntimeException("队列空，没有元素弹出");
		}
		int result = stack2.pop();
		return result;
	}


	// 队列1
	Queue<Integer> queue1 = new LinkedList<>();
	// 队列2
	Queue<Integer> queue2 = new LinkedList<>();

	// 入队：每次向非空的队列中添加元素
	public void push3(int node) {
		if (!queue1.isEmpty()) {
			queue1.offer(node);
		} else if (!queue2.isEmpty()) {
			queue2.offer(node);
		} else {
			throw new RuntimeException("实现过程出错。。");
		}
	}

	// 出队：每次将除最后一个元素外的所有元素移到另外一个队列
	public int pop3() {
		int result = 0;
		if (!queue1.isEmpty() && queue2.isEmpty()) {
			while (!queue1.isEmpty()) {
				int data = queue1.poll();
				if (queue1.isEmpty()) { // 判断是否为最后一个该出队的元素
					result = data;
				} else {
					queue2.offer(data);
				}
			}
		} else if (queue1.isEmpty() && !queue2.isEmpty()) {
			while (!queue2.isEmpty()) {
				int data = queue2.poll();
				if (queue2.isEmpty()) {
					result = data;
				} else {
					queue1.offer(data);
				}
			}
		}
		return result;
	}

}
