package app1_2;

import java.util.Stack;

/**  
 * 面试题目7：
 * 用两个栈实现一个队列。队列的声明如下，请实现它的两个函数appendTail和deleteHead，
 * 分别完成在队列尾部插入节点和在队列头部删除节点的功能。   
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

}
