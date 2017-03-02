package easy;
/**  
 * 83. Remove Duplicates from Sorted List Add to List
Description  Submission  Solutions
Total Accepted: 165413
Total Submissions: 422877
Difficulty: Easy
Contributors: Admin

给定一个有序链表，删除所有重复的元素使得每个元素只出现一次。
Given a sorted linked list, delete all duplicates such that each element appear only once.

For example,
Given 1->1->2, return 1->2.
Given 1->1->2->3->3, return 1->2->3.   
 *  
 * @author 郑元浩 
 * @date 2017年2月28日 上午11:14:25 
 */
public class RemoveDuplicatesfromSortedList83 {
	
	public ListNode deleteDuplicates(ListNode head) {
		if(head == null || head.next == null)return head;
        head.next = deleteDuplicates(head.next);
        return head.val == head.next.val ? head.next : head;
    }

}
