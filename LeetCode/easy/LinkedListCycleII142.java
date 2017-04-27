package easy;

import java.util.HashSet;
import java.util.Set;

/**  
 * 142. Linked List Cycle II Add to List
Description  Submission  Solutions
Total Accepted: 104238
Total Submissions: 336027
Difficulty: Medium
Contributors: Admin

给定一个单链表，返回环的头结点。
Given a linked list, return the node where the cycle begins. If there is no cycle, return null.

Note: Do not modify the linked list.

Follow up:
Can you solve it without using extra space?  （是否可以不使用辅助空间实现） 
 *  
 * @author 郑元浩 
 * @date 2017年2月28日 上午8:48:28 
 */
public class LinkedListCycleII142 {
	
	/**
	 * 两个指针，第一个指针从头结点开始每次移动一步，第二个指针从头结点开始每次移动两步。如果有环，最终两个指针会相交。（第二个指针多走一圈）
	 * 设环的大小为N，从头结点到环起始点大小为A，从环起始点到两个指针相交点的距离为B。
	 * 则相交的时候，第二个指针走的步数（A+B+N）应该是第一个节点（A+B）的2倍。有：A+B+N=2*(A+B)，即有: N-B=A
	 * 因此，从相交处的指针   和   从头结点的指针     移动相同步数（A）即可到达环的头结点。
	 * @param head
	 * @return
	 */
	public ListNode detectCycle(ListNode head) {
		if (head == null) {
			return null;
		}
		ListNode first = head;
		ListNode second = head;
		while (second.next != null && second.next.next != null) {
			first = first.next;
			second = second.next.next; // 每次走两步
			if (first == second) {
				ListNode temp = head; // 重复节点处可以从头开始遍历，当两个节点相同即是头节点
				while (temp != second) {
					temp = temp.next;
					second = second.next;
				}
				return temp;
			}
		}
		return null;
	}
	
	
	/**
	 * 利用额外的空间，即Set集合保存每个节点信息，判断是否存在重复的节点
	 * @param head
	 * @return
	 */
	public ListNode detectCycle2(ListNode head) {
		if (head == null) {
			return null;
		}
        Set<ListNode> set = new HashSet<ListNode>();
        set.add(head);
		ListNode temp = head;
        while (temp.next != null) {
			temp = temp.next;
			if (set.contains(temp)) {
				return temp;
			} else {
				set.add(temp);
			}
		}
        return null;
    }
	
	/**
	 * 不使用额外的空间，O(n^2)
	 * @param head
	 * @return
	 */
	public ListNode detectCycle3(ListNode head) {
		if (head == null) {
			return null;
		}
		ListNode temp1 = head;
		while(temp1.next != null){
			ListNode temp2 = temp1.next;
			while(temp2.next != null) {
				if (temp2 == temp1) {
					return temp2;
				}
				temp2 = temp2.next;
			}
		}
		return null;
	}

}
