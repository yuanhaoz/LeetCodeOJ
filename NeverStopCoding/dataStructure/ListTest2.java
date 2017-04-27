package dataStructure;

import java.util.Stack;

/**  
 * 包含链表的以下内容： 
 * 1、单链表的创建和遍历
　　2、求单链表中节点的个数
　　3、查找单链表中的倒数第k个结点（剑指offer，题15）
　　4、查找单链表中的中间结点
　　5、合并两个有序的单链表，合并之后的链表依然有序【出现频率高】（剑指offer，题17）
　　6、单链表的反转【出现频率最高】（剑指offer，题16）
　　7、从尾到头打印单链表（剑指offer，题5）
　　8、判断单链表是否有环
　　9、取出有环链表中，环的长度
　　10、单链表中，取出环的起始点（剑指offer，题56）。本题需利用上面的第8题和第9题。
　　11、判断两个单链表相交的第一个交点（剑指offer，题37）      
 *  
 * @author 郑元浩 
 * @date 2017年3月20日 下午4:38:15 
 */
public class ListTest2 {

	public static void main(String[] args) {
		ListNode head = new ListNode(0);
		ListNode a = new ListNode(1);
		ListNode b = new ListNode(2);
		ListNode c = new ListNode(3);
		head.next = a;
		a.next = b;
		b.next = c;
//		System.out.println(getLength(head));
//		System.out.println(findLastNode(head, 1).data);
//		System.out.println(findLastNode(head, 1).data);
//		System.out.println(findMidNode(head).data);
//		Node d = new Node(3);
//		c.next = d;
//		System.out.println(findMidNode(head).data);
		
//		Node head1 = new Node(2);
//		Node a1 = new Node(3);
//		Node b1 = new Node(4);
//		Node c1 = new Node(5);
//		head1.next = a1;
//		a1.next = b1;
//		b1.next = c1;
//		Node merge = mergeLinkList(head1, head);
//		System.out.println("---------------------------");
//		while(merge != null){
//			System.out.println(merge.data);
//			merge = merge.next;
//		}
		
//		Node reverse = reverseList(head);
//		System.out.println("---------------------------");
//		while(reverse != null){
//			System.out.println(reverse.data);
//			reverse = reverse.next;
//		}
		
//		System.out.println("---------------------------");
//		reversePrint(head);
//		System.out.println("---------------------------");
//		reversePrintByStack(head);
		
		System.out.println("---------------------------");
//		System.out.println(hasCycle(head));
//		c.next = head;
//		System.out.println(hasCycle(head));
//		System.out.println(getCycleLength(head));
//		System.out.println(getCycleStart(head).data);
		
		ListNode head4 = new ListNode(4);
		ListNode a4 = new ListNode(5);
		head4.next = a4;
		a4.next = b;
		System.out.println(meetNode(head, head4).data);
	}
	
	/**
	 * 2、求单链表中节点的个数：
	 * 注意检查链表是否为空。时间复杂度为O（n）。这个比较简单。
	 * @return
	 */
	public static int getLength(ListNode head) {
		if (head == null) {
			return 0;
		}
		int length = 0;
		ListNode current = head;
		while (current != null) { // 当前元素不为空
			length++;
			current = current.next;
		}
		return length;
	}
	
	/**
	 * 3、查找单链表中的倒数第k个结点（剑指offer，题15）
     * 这里需要声明两个指针：即两个结点型的变量first和second，
     * 首先让first和second都指向第一个结点，然后让second结点往后挪k-1个位置，
     * 此时first和second就间隔了k-1个位置，然后整体向后移动这两个节点，
     * 直到second节点走到最后一个结点的时候，
     * 此时first节点所指向的位置就是倒数第k个节点的位置。时间复杂度为O（n）
	 * 
	 * 考虑k=0和k大于链表长度的情况
	 */
	public static ListNode findLastNode(ListNode head, int k){
		if (head == null || k == 0) { // 考虑k = 0的情况
			return null;
		}
		ListNode first = head;
		ListNode second = head;
		for (int i = 0; i < k - 1; i++) {
			second = second.next;
			if (second == null) { // 说明k的值已经大于链表的长度了
				return null;
			}
		}
		// 让first和second结点整体向后移动，直到second走到最后一个结点  
		while(second.next != null){
			second = second.next;
			first = first.next;
		}
		// 当second结点走到最后一个节点的时候，此时first指向的结点就是我们要找的结点  
		return first;

////		 先得到长度，然后再得到第k个元素
//		if (head == null) {
//			return null;
//		}
//		int length = 0;
//		Node current = head;
//		while (current != null) { // 当前元素不为空
//			length++;
//			current = current.next;
//		}
//		Node current1 = head;
//		while (current1 != null && length != k) { // 当前元素不为空
//			length--;
//			current1 = current1.next;
//		}
//		return current1;
	}
	
	/**
	 * 4、查找单链表中的中间结点：
	 * 同样，面试官不允许你算出链表的长度，该怎么做呢？
	 * 思路：和上面的第2节一样，也是设置两个指针first和second，只不过这里是，两个指针同时向前走，
	 * second指针每次走两步，first指针每次走一步，直到second指针走到最后一个结点时，
	 * 此时first指针所指的结点就是中间结点。
	 * 注意链表为空，链表结点个数为1和2的情况。时间复杂度为O（n）。
	 * 
	 * 上方代码中，当n为偶数时，得到的中间结点是第n/2个结点。比如链表有6个节点时，得到的是第3个节点。
	 */
	public static ListNode findMidNode(ListNode head){
		if (head == null || head.next == null || head.next.next == null) {
			return null;
		}
		ListNode first = head;
		ListNode second = head;
		while (second.next != null && second.next.next != null) {
			first = first.next;
			second = second.next.next;
		}
		return first;
	}
	
	/**
	 * 5、合并两个有序的单链表，合并之后的链表依然有序【出现频率高】（剑指offer，题17）
	 *  这道题经常被各公司考察。例如：链表1：　　1->2->3->4            链表2：      2->3->4->5              合并后： 1->2->2->3->3->4->4->5
	 *  解题思路：挨着比较链表1和链表2。这个类似于归并排序。尤其要注意两个链表都为空、和其中一个为空的情况。
	 *  只需要O(1)的空间。时间复杂度为O (max(len1,len2))
	 */
	public static ListNode mergeLinkList(ListNode head1, ListNode head2) {
		if (head1 == null && head2 == null) { // 如果两个链表都为空  
			return null;
		}
		if (head1 == null) {
			return head2;
		}
		if (head2 == null) {
			return head1;
		}
		
		ListNode head; // 新链表的头结点 
		ListNode current;
		
		// 一开始，我们让current结点指向head1和head2中较小的数据，得到head结点  
		if (head1.data < head2.data) {
			head = head1; 
			current = head; // current指针下移
			head1 = head1.next;
		} else {
			head = head2;
			current = head;
			head2 = head2.next;
		}
		while (head1 != null && head2 != null) {
			if (head1.data < head2.data) {
				current.next = head1; // 新链表中，current指针的下一个结点对应较小的那个数据
				head1 = head1.next; //current指针下移
				current = current.next;
			} else {
				current.next = head2;
				head2 = head2.next;
				current = current.next;
			}
		}
		
		// 合并剩余的元素
		if (head1 != null) { // 说明链表2遍历完了，是空的
			current.next = head1;
		}
		
		if (head2 != null) { // 说明链表1遍历完了，是空的  
			current.next = head2;
		}
		return head;
		
	}
	
	/**
	 * 6、单链表的反转：【出现频率最高】（不使用额外的空间）
例如链表：
　　1->2->3->4
反转之后：
　　4->2->2->1
思路：
　　从头到尾遍历原链表，每遍历一个结点，将其摘下放在新链表的最前端。注意链表为空和只有一个结点的情况。时间复杂度为O（n）
	 */
	public static ListNode reverseList(ListNode head) {
		if (head == null || head.next == null) { // 如果链表为空或者只有一个节点，无需反转，直接返回原链表的头结点 
			return head;
		}
		
		ListNode current = head;
		ListNode reverseHead = null; // 反转后新链表的表头 
		ListNode next = null; // 定义当前结点的下一个结点
		
		while (current != null) {
			next = current.next; // 暂时保存住当前结点的下一个结点，因为下一次要用 
			
			current.next = reverseHead; // 将current的下一个结点指向新链表的头结点
			reverseHead = current; // 设置头元素为当前元素
			
			current = next; // 操作结束后，current节点后移  
		}
		
		return reverseHead;
		
	}
	
	/**
	 * 7、从尾到头打印单链表：
     　　   对于这种颠倒顺序的问题，我们应该就会想到栈，后进先出。
     所以，这一题要么自己使用栈，要么让系统使用栈，也就是递归。注意链表为空的情况。时间复杂度为O（n）
     */
	// 用递归实现
	// 总结：方法2是基于递归实现的，戴安看起来简洁优雅，但有个问题：当链表很长的时候，就会导致方法调用的层级很深，有可能造成栈溢出。
	// 而方法1的显式用栈，是基于循环实现的，代码的鲁棒性要更好一些。
	public static void reversePrint(ListNode head) {
		if (head == null) {
			return ;
		}
		reversePrint(head.next); // 递归调用
		System.out.println(head.data); // 递归到最后一个元素开始倒着打印元素
	}
	// 用栈实现
	public static void reversePrintByStack(ListNode head) {
		if (head == null) {
			return ;
		}
		Stack<ListNode> stack = new Stack<ListNode>(); // 定义栈存储元素
		while (head != null) { // 元素入栈
			stack.push(head);
			head = head.next;
		}
		
		while (!stack.isEmpty()) { // 元素反序出栈
			System.out.println(stack.pop().data);
		}
	}
	
	/**
	 * 8、判断单链表是否有环：
　　这里也是用到两个指针，如果一个链表有环，那么用一个指针去遍历，是永远走不到头的。
　　因此，我们用两个指针去遍历：first指针每次走一步，second指针每次走两步，如果first指针和second指针相遇，说明有环。时间复杂度为O (n)。
	 */
	public static boolean hasCycle(ListNode head) {
		if (head == null) {  
			return false;  
		}  

		ListNode first = head;
		ListNode second = head;  

		while (second != null) {  
			first = first.next; //first指针走一步  
			second = second.next.next; // second指针走两步  

			if (first == second) { //一旦两个指针相遇，说明链表是有环的
				return true;  
			}  
		}  

		return false;  

//		if (head == null || head.next == null || head.next.next == null) {
//			return false;
//		}
//		Node first = head;
//		Node second = head;
//		while (second.next.next != null && first.next != second.next.next) {
//			first = first.next;
//			second = second.next.next;
//		}
//		if (first.next == second.next.next) {
//			return true;
//		} else {
//			return false;
//		}
		
	}
	
	/**
	 * 9、取出有环链表中，环的长度：从开始到相遇处first走的步数
	 */
	public static int getCycleLength(ListNode head){
		if (head == null) {
			return 0;
		}
		ListNode first = head;
		ListNode second = head;
		int length = 0;
		while (second != null) {
			first = first.next;
			second = second.next.next;
			length++; // 长度为：从开始到相遇处first走的步数
			if (first == second) {
				return length;
			}
		}
		return 0;
	}
	
	/**
	 * 10、单链表中，取出环的起始点：从相遇点开始，设置一个节点从头开始，然后最终相遇的节点就是环的起始点。
	 */
	public static ListNode getCycleStart(ListNode head) {
		if (head == null) {
			return null;
		}
		
		ListNode first = head;
		ListNode second = head;
		
		while (second != null) {
			first = first.next;
			second = second.next.next;
			
			// 从相遇节点开始，不断往后移动节点
			if (first == second) {
				first = head; // 重新设置第一个指针从头开始
				while (first != second) {
					first = first.next;
					second = second.next;
				}
				// 最终相遇的节点就是环的起始节点
				return first;
			}
		}
		return null;
		
	}
	
	/**
	 * 11、判断两个单链表相交的第一个交点：
	 * 让其中一个单链表的节点在遍历到最后一个元素时候指向另外一个单链表的头结点，然后继续移动。
	 * 另外一个单链表的节点类似，最终两个指针会相遇，该相遇节点就是两个单链表相交的第一个节点。
	 */
	public static ListNode meetNode(ListNode head1, ListNode head2){
		if(head1 == null || head2 == null || (head1.next == null && head2.next == null)) {
			return null;
		}
		ListNode first = head1;
		ListNode second = head2;
		int times = 0; // 当不存在相交节点的情况的标志位
		
		while (first != second && times < 2) { // 当两个节点没有相交的时候
			first = first.next;
			second = second.next;
			
			if (first == null) { // 第一个指针遍历结束后指向第二个链表的头
				times++;
				first = head2;
			}
			
			if (second == null) { // 第二个指针遍历结束后指向第一个链表的头
				second = head1;
			}
		}
		
		if (times != 2) { // 存在相交的情况
			return first;
		} else { // 不存在相交的情况
			return null;
		}
		
	}
	

}
