package dataStructure;
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

	}
	
	/**
	 * 2、求单链表中节点的个数：
	 * 注意检查链表是否为空。时间复杂度为O（n）。这个比较简单。
	 * @return
	 */
	public static int getLength(Node head) {
		if (head == null) {
			return 0;
		}
		int length = 0;
		Node current = head;
		while (current != null) { // 当前元素不为空
			length++;
			current = current.next;
		}
		return length;
	}
	
	/**
	 * 3、查找单链表中的倒数第k个结点（剑指offer，题15）
	 */
	

}
