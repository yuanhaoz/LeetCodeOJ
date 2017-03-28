package app3;

import bean.ListNode;

/**  
 * 面试题15：链表中倒数第K个结点
 * 题目：输入一个链表，输出该链表中倒数第K个结点。为了符合大多数人的习惯，本题从1开始计数，即链表的尾节点是倒数第一个结点。
 * 例如一个链表有6个结点，从头结点开始它们的值依次是1/2/3/4/5/6。这个链表的倒数第3个结点是值为4的结点。
 * 
 * 思路：
 * 1. 首先得到链表长度n，然后倒数第k个结点就是从头结点开始往后走n-k+1步就可以了。需要遍历链表两次，第一次统计链表节点个数，第二次找到倒数第k个结点。
 * 2. 两个指针，第一个指针指向头结点，第二个指针从头指针开始遍历往前走k-1步。然后两个指针同时移动，当第二个指针指向尾节点时，第一个指针就是倒数第k个结点。
 * 
 * 注意：（关键之处，代码的鲁棒性）
 * 1. 链表头结点为空，返回空
 * 2. k为0，返回空
 * 3. k大于链表长度，返回空
 * 
 * 举一反三：当我们用一个指针遍历链表不能解决问题的时候，可以尝试用两个指针来遍历链表。可以让其中一个指针遍历的速度快一些（比如一次在链表上走两步），
 * 或者让它先在链表上走若干步。
 *  
 * @author 郑元浩 
 * @date 2017年3月24日 上午11:28:10 
 */
public class T15_FindKthToTail {

	public static void main(String[] args) {
		ListNode l1 = new ListNode(1);
		ListNode l2 = new ListNode(2);
		ListNode l3 = new ListNode(3);
		ListNode l4 = new ListNode(4);
//		ListNode l5 = null;
		l1.next = l2;
		l2.next = l3;
		l3.next = l4;
		System.out.println(findKthToTail(l1, 1));
		System.out.println(findKthToTail(l1, 1).val);
	}
	
	/**
	 * 输入一个键表，输出该链表中倒数第k 个结点．为了符合大多数人的习惯，
     * 本题从1开始计数，即链表的尾结点是倒数第1个结点．例如一个链表有6个结点，
     * 从头结点开始它们的值依次是1、2、3、4、5 6。这个链表的倒数第3个结点是值为4的结点．
	 * @param head 链表的头结点
	 * @param k  倒数第k个结点
	 * @return 倒数第k个结点
	 */
	public static ListNode findKthToTail(ListNode head, int k) {
		// 判断链表为空或者k小于1
		if (head == null || k < 1) {
			return null;
		}
		ListNode first = head;
		ListNode second = head;
		// 设置second为k-1个元素
		while (--k != 0) {
			// 判断k是不是大于链表长度
			if (second.next != null) {
				second = second.next;
			} else {
				return null; // k大于链表长度，返回null
			}
		}
		// 移动两个指针，找到倒数第k个元素
		while (second.next != null) {
			first = first.next;
			second = second.next;
		}
		return first;
	}

}
