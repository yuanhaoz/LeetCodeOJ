package easy;

import java.util.HashSet;
import java.util.Set;


/**  
 * 141. Linked List Cycle Add to List
Description  Submission  Solutions
Total Accepted: 160908
Total Submissions: 451022
Difficulty: Easy
Contributors: Admin

给定一个单链表，判断是否存在环
Given a linked list, determine if it has a cycle in it.

Follow up:
Can you solve it without using extra space?（是否可以不使用辅助空间实现）
 *  
 * @author 郑元浩 
 * @date 2017年2月27日 下午9:10:36 
 */


/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */

public class LinkedListCycle141 {

	/**
	 * 利用额外的空间，即Set集合保存每个节点信息，判断是否存在重复的节点
	 * @param head
	 * @return
	 */
	public boolean hasCycle(ListNode head) {
		if (head == null) {
			return false;
		}
		Set<ListNode> set = new HashSet<ListNode>();
		set.add(head);
		ListNode temp = head;
		while (temp.next != null) {
			temp = temp.next;
			if (set.contains(temp)) {
				return true;
			} else {
				set.add(temp);
			}
		}
		return false;
    }
	
	/**
	 * 两个指针，第一个指针每次前进1步，第二个指针每次前进2步，如果存在环，那么两个指针节点就会相遇重合
	 * Use two pointers, walker and runner.
walker moves step by step. runner moves two steps at time.
if the Linked List has a cycle walker and runner will meet at some point.
	 * @param head
	 * @return
	 */
	public boolean hasCycle2(ListNode head) {
		if(head==null) return false;
		ListNode walker = head;
		ListNode runner = head;
		while(runner.next!=null && runner.next.next!=null) {
			walker = walker.next;
			runner = runner.next.next;
			if(walker==runner) return true;
		}
		return false;
	}

}
