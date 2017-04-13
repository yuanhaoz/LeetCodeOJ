package dataStructure;

import java.util.NoSuchElementException;

/**  
 * Quene类尚不在java集合框架中，因此它有很大的灵活性，为了能够进行代码重用，
 * 我们试着通过继承（is-a关系）或者合成（have-a关系）一些实现了List接口的类来定义Queue类。
 * 
 * 2.第二种可选择的实现方式，用数组的方式实现   
 *  
 * @author 郑元浩 
 * @date 2017年4月12日 下午2:28:48 
 */
public class MyQueueArray {
	
	protected Object[] data;
	protected int size, head, tail;
	
	public MyQueueArray() {
		final int INITIAL_LENGTH = 100;
		data = new Object[INITIAL_LENGTH];
		size = 0;
		head = 0;
		tail = -1;
	}
	
	public int size() {
		return size;
	}
	
	public boolean isEmpty() {
		return size == 0;
	}
	
	public Object front() {
		if (size == 0) {
			throw new NoSuchElementException();
		}
		return data[head];
	}
	
	// 入队
	public void enqueue(Object element) {
		if (size == data.length) {
			Object[] oldData = data;
			data = new Object[data.length * 2];
			System.arraycopy(oldData, head, data, 0, oldData.length - head);
			if (head > 0) {
				System.arraycopy(oldData, 0, data, head + 1, tail - 1);
			}
			head = 0;
			tail = oldData.length - 1;
		}
		tail = (tail + 1) % data.length;
		size++;
		data[tail] = element;
	}
	
	// 出队
	public Object dequeue() {
		if (size == 0) {
			throw new NoSuchElementException();
		}
		Object element = data[head];
		head = (head + 1) % data.length;
		return element;
	}
	
	public static void main(String[] args) {
		MyQueueArray q = new MyQueueArray();
		for (int i = 0; i < 18; i++) {
			q.enqueue(i);
		}
		System.out.println("队列长度：" + q.size());
		System.out.println("队列首元素：" + q.dequeue());
		System.out.println("队列首元素：" + q.dequeue());
	}
	
}
