package twoPointer;

import easy.ListNode;

/**
 * 234. Palindrome Linked List
Given a singly linked list, determine if it is a palindrome.

Follow up:
Could you do it in O(n) time and O(1) space?
 * @author 郑元浩
 * @date 2017年7月17日 下午9:27:44
 *
 */
public class PalindromeLinkedList234 {

	public static void main(String[] args) {
		ListNode head = new ListNode(-129);
		head.next = new ListNode(-129);
		System.out.println(isPalindrome(head));
	}
	
	/**
	 * 两个指针，一个快指针走两步，一个慢指针走一步，快指针走到链表尾部时，慢指针指向中间一半的元素。
	 * 对慢指针之后的链表元素进行反转并使慢指针指向反转后的表头指针。令快指针指向原表头指针。
	 * 然后两个指针指向的元素开始进行一一比较。
	 * @param head
	 * @return
	 */
	public static boolean isPalindrome(ListNode head) {
		ListNode fast = head;
		ListNode slow = head;
		// 使得慢指针走到中间元素的位置
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		if(fast != null){
			slow = slow.next;
		}
		// 反转后半部分的链表并对之后的两个一半一半链表元素的值进行对比。
		slow = reverse(slow);
		fast = head;
		while (slow != null) {
			if (slow.val != fast.val) {
				return false;
			}
			slow = slow.next;
			fast = fast.next;
		}
		return true;
    }
	
	public static ListNode reverse(ListNode head) {
		ListNode newHead = null;
		while (head != null) {
			ListNode temp = head.next;
			head.next = newHead;
			newHead = head;
			head = temp;
		}
		return newHead;
	}

}
