package lintcode;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

public class RemoveList {
	
	/**
     * @param head a ListNode
     * @param val an integer
     * @return a ListNode
     */
	public static ListNode removeElements(ListNode head, int val){
		if(head == null) return head;
		while(head != null && head.val == val){ // case: 1->1->null, 1
			head = head.next;
		}
		if(head == null){
			return head;
		}
		ListNode p = head;
		ListNode q = head.next;
		while(q != null){
			if(val == q.val){
				p.next = q.next;
				q = q.next;
			} else {
				p = p.next;
				q = q.next;
			}
		}
		return head;
	}
	
	/**
     * @param head a ListNode
     * @param val an integer
     * @return a ListNode
     */
	public static ListNode removeElements2(ListNode head, int val){
		while(head != null){
			while(head.val == val){ // case: 1->1->null, 1
				head = head.next;
			}
			ListNode p = head;
			ListNode q = head.next;
			while(q != null){
				if(val == q.val){
					p.next = q.next;
					q = q.next;
				} else {
					p = p.next;
					q = q.next;
				}
			}
		}
		return head;
	}

}
