package app3;

import bean.ListNode;

/**  
 * 面试题17：合并两个排序的链表
 * 题目：输入两个递增排序的链表，合并这两个链表并使新链表中的节点仍然是按照递增排序的。   
 * 
 * 思路：
 * 1. 从头开始判断两个链表的元素，每次取出其中较小的那个元素，并移动该链表的指针，直到其中一个为空，然后让其余的直接指向另外一个链表
 * 2. 递归的方法：使用的是递归的解法，不推荐，递归调用的时候会有方法入栈，需要更多的内存
 * 
 * 注意：（关键之处，代码的鲁棒性）
 * 1. 其中一个链表为空的情况
 *  
 * @author 郑元浩 
 * @date 2017年3月24日 下午2:50:20 
 */
public class T17_MergeList {
	
	/**
	 * 输入两个递增排序的链表，合并这两个链表并使新链表中的结点仍然是按照递增排序的 
	 * @param head1 第一个有序链表
	 * @param head2 第二个有序链表
	 * @return 合并后的有序链表头
	 */
	public static ListNode mergeList(ListNode head1, ListNode head2) {
		// 当链表为空的时候
		if (head1 == null) {
			return head2;
		}
		if (head2 == null) {
			return head1;
		}
		// 设置头结点为两个链表中值小的那个
		ListNode head = new ListNode();
		ListNode cur = head;
		// 循环遍历两个链表直到其中一个链表元素为空，合并所有元素
		while (head1 != null && head2 != null) {
			if (head1.val < head2.val) {
				cur.next = head1;
				head1 = head1.next;
			} else {
				cur.next = head2;
				head2 = head2.next;
			}
			cur = cur.next;
		}
		// 当其中一个链表遍历结束的时候，直接连接剩余的元素
		if (head1 != null) {
			cur.next = head1;
		}
		if (head2 != null) {
			cur.next = head2;
		}
		return head.next;
	}
	
	/**
	 * 输入两个递增排序的链表，合并这两个链表并使新链表中的结点仍然是按照递增排序的
     * 【使用的是递归的解法，不推荐，递归调用的时候会有方法入栈，需要更多的内存】
	 * @param head1 第一个有序链表
	 * @param head2 第二个有序链表
	 * @return 合并后的有序链表头
	 */
	public static ListNode merge2(ListNode head1, ListNode head2) {
		// 如果第一个链表为空，返回第二个链表头结点
		if (head1 == null) {
			return head2;
		}
		// 如果第二个链表为空，返回第一个链表头结点
		if (head2 == null) {
			return head1;
		}
		// 记录两个链表中头部较小的节点
		ListNode tmp = head1;
		if (tmp.val < head2.val) {
			// 如果第一个链表的头结点小，就递归处理第一个链表的下一个结点和第二个链表的头结点
			tmp.next = merge2(head1.next, head2);
		} else {
			// 如果第二个链表的头结点小，就递归处理第一个链表的头结点和第二个链表的头结点的下一个结点
			tmp = head2;
			tmp.next = merge2(head1, head2.next);
		}
		// 返回处理结果
		return tmp;
	}

	/**
	 *
	 * @param head1
	 * @param head2
	 * @return
	 */
	public static ListNode mergeList3(ListNode head1, ListNode head2) {
		if (head1 == null) {
			return head2;
		}
		if (head2 == null) {
			return head1;
		}
		ListNode newHead = new ListNode();
		ListNode tmp = newHead;
		while (head1 != null && head2 != null) {
			if (head1.val < head2.val) {
				tmp.next = head1;
				head1 = head1.next;
			} else {
				tmp.next = head2;
				head2 = head2.next;
			}
			tmp = tmp.next;
		}
		if (head1 != null) {
			tmp.next = head1;
		}
		if (head2 != null) {
			tmp.next = head2;
		}
		return newHead.next;
	}

	public static void main(String[] args) {
		ListNode l1 = new ListNode(1);
		ListNode l2 = new ListNode(3);
		ListNode l3 = new ListNode(5);
		ListNode l4 = new ListNode(7);
		l1.next = l2;
		l2.next = l3;
		l3.next = l4;
		
		ListNode l5 = new ListNode(2);
		ListNode l6 = new ListNode(4);
		ListNode l7 = new ListNode(6);
		ListNode l8 = new ListNode(8);
		l5.next = l6;
		l6.next = l7;
		l7.next = l8;
		
		ListNode l9 = null;
		ListNode.printList(mergeList3(l1, l5));
//		ListNode.printList(mergeList(l9, l5));
	}

}
