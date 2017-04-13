package dataStructure;

import java.util.LinkedList;

/**  
 * 队列 是一种先进先出的线性表。其限制仅在表的一端（尾端）进行插入，另一端（首端）进行删除的线性表，先进先出FIFO。 
这里写图片描述 
Quene类尚不在java集合框架中，因此它有很大的灵活性，为了能够进行代码重用，我们试着通过继承（is-a关系）或者合成（have-a关系）
一些实现了List接口的类来定义Queue类。直观的选择是ArrayList和LinkedList。 

1.第一种实现方式：LinkedList插入删除效率比较高，可以实现队列的尾部插入和头部删除只需常量次调用，我们首先选择LinkedList来实现Queue。 
这里我们采用采用合成（have-a关系）的方法，通过包含一个LinkedList字段来定义一个Queue类。   
 *  
 * @author 郑元浩 
 * @date 2017年4月12日 上午11:29:25 
 */
public class MyQueueLink<E> {

	private LinkedList<E> list;
	
	// 入队
	public void put(E e) {
		list.add(e);
	}
	
	// 出队
	public E pop() {
		return list.removeFirst();
	}
	
	public boolean isEmpty() {
		return list.isEmpty();
	}
	
	public int size() {
		return list.size();
	}
	
	// 获得队列的第一个元素
	public E front() {
		return list.getFirst();
	}
	
}
