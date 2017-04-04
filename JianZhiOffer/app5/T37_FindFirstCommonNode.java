package app5;

import bean.ListNode;

/**  
 * 面试题37：两个链表的第一个公共结点
 * 题目：输入两个链表，找出它们的第一个公共结点。
 * 
 * 思路：
 * 1. 先循环遍历第一个链表中的结点，每遍历一个结点在第二个链表上顺序遍历每个结点。如果在第二个链表上有一个结点和第一个链表上的结点一样，说明这两个链表在这个结点上重合，
 *    于是就找到了它们的公共结点。如果第一个和第二个链表长度分别是m和n，显然该方法的时间复杂度是O(mn)。
 * 2. 发现如果两个链表有公共结点，那么公共结点出现在两个链表的尾部。如果我们从两个链表的尾部开始往前比较，最后一个相同的结点就是我们要找的结点。可问题是在单向链表中，
 *    我们只能从头结点开始遍历，最后才能到达尾节点。于是考虑使用栈：分别把两个链表的节点放到两个栈中，这样两个链表的尾节点就位于两个栈的栈顶，接下来比较两个栈顶的结点
 *    是否相同。如果相同，则把栈弹出接着比较下一个栈顶，直到找到最后一个相同的结点。在该方法中，我们需要用两个辅助栈。如果链表长度分别为m和n，那么空间复杂度为O(m+n)
 * 3. 之所以用到栈是因为我们想同时遍历到达两个栈的尾节点。当两个链表的长度不相同时，如果我们从头开始遍历到达尾节点的时间就不一致。还有一个更简单的方法：
 * 	     首先遍历两个链表得到它们的长度，就能知道哪个链表比较长，以及长的链表比短的链表多几个结点。在第二次遍历的时候，在较长的链表上先走若干步，接着再同时在两个链表上遍历，
 *    找到的第一个相同的节点就是它们的第一个公共结点。该思路相比于第二种思路，时间复杂度都是O(m+n)，但我们不再需要辅助栈，因此提高了空间效率。
 *  
 * @author 郑元浩 
 * @date 2017年3月31日 上午11:27:42 
 */
public class T37_FindFirstCommonNode {
	
	public static ListNode findFirstCommonNode(ListNode root1, ListNode root2){
		if (root1 == null || root2 == null) {
			return null;
		}
		int len1 = getLength(root1);
		int len2 = getLength(root2);
		
		int lenMin = len1 - len2;
		ListNode head1 = root1;
		ListNode head2 = root2;
		
		if (len1 < len2) {
			lenMin = len2 - len1;
			head1 = root2;
			head2 = root1;
		}
		
		for (int i = 0; i < lenMin; i++) {
			head1 = head1.next;
		}
		
		while (head1 != null && head2 != null && head1 != head2) {
			head1 = head1.next;
			head2 = head2.next;
		}
		
		// 返回第一个相同的公共结点，如果没有返回null
		return head1;
		
	}
	
	public static int getLength(ListNode root){
		int length = 0;
		while (root != null) {
			length++;
			root = root.next;
		}
		return length;
	}

	public static void main(String[] args) {
        test1();
        test2();
        test3();
        test4();
    }

    private static void test1() {
        // 第一个公共结点在链表中间
        // 1 - 2 - 3 \
        //            6 - 7
        //     4 - 5 /
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        ListNode n6 = new ListNode(6);
        ListNode n7 = new ListNode(7);

        n1.next = n2;
        n2.next = n3;
        n3.next = n6;
        n6.next = n7;

        n4.next = n5;
        n5.next = n6;

        System.out.println(findFirstCommonNode(n1, n4).val); // 6
    }


    private static void test2() {
        // 没有公共结点
        // 1 - 2 - 3 - 4
        //
        // 5 - 6 - 7
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        ListNode n6 = new ListNode(6);
        ListNode n7 = new ListNode(7);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;

        n5.next = n6;
        n6.next = n7;
        System.out.println(findFirstCommonNode(n1, n5)); // null
    }

    private static void test3() {
        // 公共结点是最后一个结点
        // 1 - 2 - 3 - 4 \
        //                7
        //         5 - 6 /
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        ListNode n6 = new ListNode(6);
        ListNode n7 = new ListNode(7);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n7;

        n5.next = n6;
        n6.next = n7;
        System.out.println(findFirstCommonNode(n1, n5).val); // 7
    }

    private static void test4() {
        // 公共结点是第一个结点
        // 1 - 2 - 3 - 4 - 5
        // 两个链表完全重合
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;

        System.out.println(findFirstCommonNode(n1, n1).val); // 1
    }

}
