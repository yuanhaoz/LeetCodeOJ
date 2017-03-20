package app1_2;

import java.util.ArrayList;
import java.util.Stack;

import app1_2.bean.ListNode;

/**  
 * 面试题5：从尾到头打印链表
 * 题目：输入一个链表的头结点，从尾到头反过来打印出每个节点的信息。
 * 一般会要求不能改变链表结构。
 * 接下里我们想到解决这个问题肯定要遍历链表。遍历的顺序是从头到尾的顺序，可输出的顺序却是从尾到头。也就是说第一个遍历到的节点最后一个输出，
 * 而最后一个遍历到的节点第一个输出。这就是典型的“后进先出”，我们可以用栈来实现这种顺序。每经过一个节点的时候，就把该节点放到一个栈中。
 * 当遍历完整个链表后，再从栈顶开始逐个输出节点的值，此时输出的节点的顺序已经反转过来了。（如test1方法）
 * 
 * 既然想到了用栈来实现这个函数，而递归在本质上就是一个栈结构，于是很自然地又想到了用递归来实现。要实现反过来输出链表，我们每访问到一个节点的时候，
 * 先递归输出它后面的节点，再输出该节点自身，这样链表的输出结果就反过来了。（如printListFromTailTohead方法）
 * 
 * 上面的基于递归的代码看起来很简洁，但有个问题：当链表非常长的时候，就会导致函数调用的层级很深，从而有可能导致函数调用栈溢出。显示用栈基于
 * 循环实现的代码的鲁棒性要好一些。
 * 
 * 测试用例：
 * 功能测试（输入的链表有多个节点，输入的链表只有一个节点）。
 * 特殊输入测试（输入的链表头结点指针为Null）。
 * 
 * 本题考点：
 * 	考查对单链表的理解和编程能力。
 * 	考查对循环、递归和栈3个相互关联的概念的理解。
 *  
 * @author 郑元浩 
 * @date 2017年3月8日 下午9:48:13 
 */
public class T5_PrintListFromListToHead {

	public static void main(String[] args) {
		ListNode p1 = new ListNode(1);
		ListNode p2 = new ListNode(4);
		ListNode p3 = new ListNode(2);
		ListNode p4 = new ListNode(3);
		p1.next = p2;
		p2.next = p3;
		p3.next = p4;
		
		test1(p1);
//		ListNode p5 = new ListNode(1);
		printListFromTailTohead(p1);
	}
	
	public static void test1(ListNode listNode){
		Stack<Integer> stack = new Stack<Integer>();
		ListNode head = listNode;
		while(head != null){
			stack.push(head.val);
			head = head.next;
		}
		while (stack.size() != 0){
			System.out.println(stack.pop());
		}
	}
	
	public static ArrayList<Integer> printListFromTailTohead(ListNode listNode){
		ArrayList<Integer> list = new ArrayList<Integer>();
		ListNode head = listNode;
		if (head != null) {
			if (head.next != null) {
				printListFromTailTohead(head.next);
			}
			list.add(head.val);
			System.out.println(head.val);
		}
		return list;
	}

}
