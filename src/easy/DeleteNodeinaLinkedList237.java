package easy;
/**  
 * 237. Delete Node in a Linked List Add to List
Description  Submission  Solutions
Total Accepted: 135245
Total Submissions: 296326
Difficulty: Easy
Contributors: Admin

写一个函数删除单链表中的一个节点（不是尾节点），假设只给定待删除的节点
Write a function to delete a node (except the tail) in a singly linked list, given only access to that node.

Supposed the linked list is 1 -> 2 -> 3 -> 4 and you are given the third node with value 3, 
the linked list should become 1 -> 2 -> 4 after calling your function.   
 *  
 * @author 郑元浩 
 * @date 2017年2月28日 上午11:00:07 
 */
public class DeleteNodeinaLinkedList237 {

	/**
	 * 不是真正删除节点，而是替换下一个节点的数据到当前节点
	 * We can't really delete the node, but we can kinda achieve the same effect by instead 
	 * removing the next node after copying its data into the node that we were asked to delete.
	 * @param node
	 */
	public void deleteNode(ListNode node) {
		node.val = node.next.val;
	    node.next = node.next.next;
    }

}
