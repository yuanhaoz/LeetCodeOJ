package dataStructure;

/**
 * 自己实现一个单链表的增删改查操作
 * 
 * @author 郑元浩 
 * @date 2017年3月20日 下午3:23:38 
 */

// 单链表的节点
//class Node {
//	//注：此处的两个成员变量权限不能为private，因为private的权限是仅对本类访问。  
//	int data; // 数据域
//	Node next; // 指针域
//	
//	public Node(int data) { // 构造函数
//		this.data = data;
//		next = null;
//	}
//	
//	public Node(int data, Node next) {
//		this.data = data;
//		this.next = next;
//	}
//}

// 1. 单链表的创建和遍历：ListTest1是一个自己实现的单链表
public class ListTest1 {

	// 头指针和当前指针
	public ListNode head;
	public ListNode current;
	
	// 方法1：向链表中添加数据
	public void add(int data){
		if (head == null) { // 头结点为空，说明这个链表还没有创建，那就把新的节点赋给头结点
			head = new ListNode(data);
			current = head;
		} else {
			current.next = new ListNode(data); // 创建新的节点，放在当前节点的后面
			current = current.next; // 此步操作完成之后，current节点指向新添加的那个节点
		}
	}
	
	// 方法2：查找给定值第一个节点
	public void find(int value){
		current = head;  // 从头结点开始查找
		while(current.data != value && current.next != null){
			current = current.next;
		}
		if (current.data == value) {
			System.out.println("find success");
		} else {
			System.out.println("find failure");
		}
	}
	
	// 方法3：删除指定节点
	public void delete(int value){
		if(value == head.data){ // 删除头结点
			if (head.next != null) {
				System.out.println("删除头结点。。。");
				head = head.next;
			} else {
				System.out.println("删除头结点，链表为空。。。");
			}
		} else {
			current = head;  // 从头结点开始查找，直到找到需要删除的节点
			while(current.next != null && current.next.data != value){
				current = current.next;
			}

			if (current.next == null) { // 查找到最后一个节点没有找到重复的节点
				System.out.println("不存在该节点...");
			} else { // 删除该节点
				System.out.println("删除成功。。。");
				current.next = current.next.next;
			}
		}
	}
	
	// 方法4：遍历链表，打印输出链表。方法的参数表示从节点node开始进行遍历
	public void print(ListNode node){
		if (node == null) {
			return ;
		}
		// 当前节点为需要打印的节点
		current = node;
		while (current != null) {
			System.out.println(current.data);
			current = current.next;
		}
	}

	public static void main(String[] args) {
		
		ListTest1 list = new ListTest1();
		for (int i = 0; i < 10; i++) {
			list.add(i); // 链表增加
		}
		list.print(list.head); // 链表遍历
		
		// 链表查找
		list.find(0);
		list.find(5);
		list.find(9);
		list.find(11);
		
		list.print(list.head);
		// 链表删除
		list.delete(0);
		list.delete(3);
		list.delete(9);
		list.delete(11);
		
		// 链表增加
		list.add(1);
		list.print(list.head);
	}

}
