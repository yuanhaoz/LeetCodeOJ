package app3;

import bean.ListNode;

/**  
 * 面试题16：反转链表
 * 题目：定义一个函数，输入一个链表的头结点，反转该链表并输出反转后链表的头结点。
 * 
 * 思路：
 * 1. 设置一个新的头结点，每次先保存当前处理节点的下一个结点信息，然后让当前节点指向新的头结点，然后让新的头结点为当前节点，最后使得当前节点为保存的下一个结点。
 * 
 * 注意：（关键之处，代码的鲁棒性）
 * 1. 链表为空和只有一个元素的情况
 *  
 * @author 郑元浩 
 * @date 2017年3月24日 下午2:29:59 
 */
public class T16_ReverseList {
	
	/**
	 * 定义一个函数，输入一个链表的头结点，反转该链表并输出反转后链表的头结点。
	 * @param head 链表的头结点
	 * @return 反转后的链表的头结点
	 */
	public static ListNode reverseList(ListNode head){
		// 链表为空或者链表只有一个元素
		if (head == null || head.next == null) {
			return head;
		}
		
		ListNode current = head;
		ListNode reverseHead = null; // 反转链表的表头元素
		ListNode next = null;
		
		while (current != null) {
			// 保存下一个需要处理的节点信息
			next = current.next;
			// 当前节点指向头结点，然后更新头结点的指针为当前节点
			current.next = reverseHead;
			reverseHead = current;
			// 当前节点设置为下一个元素
			current = next;
		}
		return reverseHead;
	}

	public static void main(String[] args) {
		ListNode l1 = new ListNode(1);
		ListNode l2 = new ListNode(2);
		ListNode l3 = new ListNode(3);
		ListNode l4 = new ListNode(4);
//		ListNode l5 = null;
		l1.next = l2;
		l2.next = l3;
		l3.next = l4;
		ListNode.printList(reverseList(l1));
	}

}
