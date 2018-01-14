package app3;

import bean.ListNode;

/**  
 * 面试题13：在O(1)时间删除链表结点
 * 给定单向链表的头指针和一个结点指针，定义一个函数在O(1)时间删除该结点。
 * 
 * 思路：
 * 1. 删除结点i之前，先从链表的头结点开始遍历到i前面的一个结点h，把h的m_pNext指向i的下一个结点j，再删除结点i。
 * 2. 把结点j的内容复制覆盖结点i，接下来再把结点i的m_pNext指向j的下一个结点之后删除结点j.这种方法不用遍历链表上结点i前面的结点。
 * 
 * 特例：
 * 1. 删除结点位于链表的尾部，那么它就没有下一个结点，仍然从链表的头结点，顺序遍历得到该结点的前序结点，并完成删除操作。
 * 2. 如果链表中只有一个结点，而我们又要删除链表的头结点（也是尾节点），此时我们在删除结点之后，还需要把链表的头结点设置为NULL。
 * 3. 下面的实现基于假设：要删除的节点的确在链表中。可以和面试官讨论这个假设，这样面试官会觉得我们考虑问题非常全面。
 * 
 * @author 郑元浩 
 * @date 2017年3月24日 上午10:00:36 
 */
public class T13_DeleteNode {

	public static void main(String[] args) {
		ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        ListNode middle = head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
        head.next.next.next.next.next.next = new ListNode(7);
        head.next.next.next.next.next.next.next = new ListNode(8);
        ListNode last = head.next.next.next.next.next.next.next.next = new ListNode(9);

        head = deleteNode(head, null); // 删除的结点为空
        ListNode.printList(head);
        ListNode node = new ListNode(12);

        head = deleteNode(head, head); // 删除头结点
        ListNode.printList(head);
        head = deleteNode(head, last); // 删除尾结点
        ListNode.printList(head);
        head = deleteNode(head, middle); // 删除中间结点
        ListNode.printList(head);

        head = deleteNode(head, node); // 删除的结点不在链表中
        ListNode.printList(head);
	}
	
	/**
	 * 
	 * @param head 链表头结点
	 * @param toBeDeleted 待删除结点
	 * @return 删除后的头结点
	 */
	public static ListNode deleteNode(ListNode head, ListNode toBeDeleted) {
		// 头结点和待删除结点为空结点
		if (head == null || toBeDeleted == null) {
			return head;
		}
		// 待删除结点为头结点
		if (head == toBeDeleted) {
			head = head.next;
			return head;
		}
		// 待删除结点为尾节点
		if (toBeDeleted.next == null) {
			ListNode tmpListNode = head; // 找到待删除结点的前驱
			while (tmpListNode.next != toBeDeleted) {
				tmpListNode = tmpListNode.next;
			}
			tmpListNode.next = null; // 删除待删除结点
		} else { // 在多个结点的情况下，如果删除的是某个中间节点
			toBeDeleted.val = toBeDeleted.next.val; // 将下一个结点的值输入当前待删除的结点
			toBeDeleted.next = toBeDeleted.next.next; // 待删除的结点的下一个指向原先待删除引号的下下个结点，即待删除的下一个结点删除
		}
		return head; // 返回删除结点后的链表头结点
	}

	public static ListNode deleteNode2(ListNode head, ListNode toBeDeleted) {
		if (head == null || toBeDeleted == null) {
			return head;
		}
		if (toBeDeleted == head) { // 删除结点是头结点
			return head.next;
		}
		if (toBeDeleted.next == null) { // 删除结点是尾节点
			ListNode tmp = head;
			while (tmp.next != toBeDeleted) {
				tmp = tmp.next;
			}
			tmp.next = null;
			return head;
		}
		toBeDeleted.val = toBeDeleted.next.val;
		toBeDeleted.next = toBeDeleted.next.next;
		return head;
	}

}
