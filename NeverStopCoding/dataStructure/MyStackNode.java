package dataStructure;
/**  
 * 两种方式实现栈：（数组或链表）
 * 1. 采用链表中结点的方式实现
 * 2. 采用数组的方式实现   
 * 
 * 栈(stack)又名堆栈，它是一种先进后出(FILO)的线性表。其限制是仅允许在表的一端进行插入和删除运算。这一端被称为栈顶，相对地，把另一端称为栈底。向一个栈插入新元素又称作进栈、入栈或压栈，它是把新元素放到栈顶元素的上面，使之成为新的栈顶元素；从一个栈删除元素又称作出栈或退栈，它是把栈顶元素删除掉，使其相邻的元素成为新的栈顶元素。 
<1>优点： 
存取速度比堆快，仅次于寄存器，栈数据可以共享； 
<2>缺点： 
存在栈中的数据大小与生存期必须是确定的，缺乏灵活性。
 *  
 * @author 郑元浩 
 * @date 2017年4月12日 上午10:37:55 
 */
public class MyStackNode<E> {

	/**
	 * 1. 采用链表中结点的方式实现
	 */
	Node2<E> top = null; // 指针指向栈顶元素
	
	// 判断栈空
	public boolean isEmpty() {
		return top == null;
	}
	
	// 入栈：使得当前节点指向当前栈顶元素，然后更新栈顶指针指向新插入的元素
	public void push(E data) {
		Node2<E> newNode = new Node2<E>(data);
		newNode.next = top;
		top = newNode;
	}
	
	// 出栈：先返回当前栈顶元素，然后更新栈顶指针指向下一个元素。注意栈空的情况
	public E pop() {
		if (this.isEmpty()) {
			return null;
		}
		E data = top.data;
		top = top.next;
		return data;
	}
	
	// 访问栈顶元素，该元素不出栈
	public E peek(){
		if (isEmpty()) {
			return null;
		}
		return top.data;
	}
	
}
