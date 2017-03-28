package bean;
/**  
 * 复杂链表：
 * 一个指针指向下一个元素的位置，另外一个指针指向链表随意的一个元素或者为空   
 *  
 * @author 郑元浩 
 * @date 2017年3月27日 上午10:59:07 
 */
public class ComplexListNode {
	
	public int val;
	public ComplexListNode next;
	public ComplexListNode sibling;
	
	public ComplexListNode(int val){
		this.val = val;
		next = null;
		sibling = null;
	}
}
