package dataStructure;
/**  
 * 构造链表节点，为了MyStackNode中构建栈数据结构使用，使用泛型
 *  
 * @author 郑元浩 
 * @date 2017年4月12日 上午10:37:31 
 */
public class Node2<E> {
	
	E data; // 数据
	Node2<E> next; // 下一个结点
	
	public Node2(E data) {
		this.data = data;
		next = null;
	}
	
}
