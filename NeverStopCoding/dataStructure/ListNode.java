package dataStructure;
/**  
 * 单链表的节点   
 *  
 * @author 郑元浩 
 * @date 2017年3月22日 上午10:04:35 
 */
public class ListNode {
	//注：此处的两个成员变量权限不能为private，因为private的权限是仅对本类访问。  
	int data; // 数据域
	ListNode next; // 指针域

	public ListNode(int data) { // 构造函数
		this.data = data;
		next = null;
	}

	public ListNode(int data, ListNode next) {
		this.data = data;
		this.next = next;
	}
}
