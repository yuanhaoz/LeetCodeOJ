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
 * @date 2017年4月12日 上午10:52:56 
 */
public class MyStackArray<E> {
	/**
	 * 2. 采用数组的方式实现
	 */
	private Object[] stack; // 数组保存的栈
	private int size; // 当前栈中包含元素的个数
	
	public MyStackArray() {
		stack = new Object[10];
	}
	
	public boolean isEmpty() {
		return size == 0;
	}
	
	@SuppressWarnings("unchecked")
	public E peek() {
		if (isEmpty()) {
			return null;
		}
		return (E) stack[size - 1]; // 如果有元素就返回最后一个
	}
	
	/**
	 * 移除栈顶元素
	 * @return
	 */
	public E pop() {
		E e = peek(); // 保存最后一个元素的备份
		stack[size - 1] = null; // 给数组最后一个元素赋null
		size--;
		return e;
	}
	
	/**
	 * 把项压入栈顶部
	 * @param item
	 * @return
	 */
	public E push(E item) {
		stack[size++] = item;
		return item;
	}
	
	/**
	 * 检查容量是否足够，不够再原有的数组基础创建新的数组
	 * @param size
	 */
	public void ensureCapacity(int size) {
		int len = stack.length;
		if (size > len) {
			// int newLen = 10;
			// stack = Arrays.copyOf()
			// 如果栈满，则创建空间为当前栈空间两倍的栈
			Object[] temp = stack;
			stack = new Object[2 * stack.length];
			System.arraycopy(temp, 0, stack, 0, temp.length);
		}
	}
	
	/**
	 * 返回对象在堆栈中的位置，以1为基数
	 * @param o
	 * @return
	 */
	public int search(Object o) {
		int index = lastIndexOf(o);
		return index == -1 ? index : size - index;
	}
	
	/**
	 * 查找下标的方法
	 * @param o
	 * @return
	 */
	public int lastIndexOf(Object o) {
		if (isEmpty()) {
			throw new EmptyStackException(); // 如果数组为空，就抛出一个自定义异常
		}
		// 当传进来的元素为空时
		if (o == null) {
			for (int i = size - 1; i >= 0; i--) {
				if (stack[i] == null) {
					return i;
				}
			}
		} else { // 不为空时
			for (int i = size - 1; i >= 0; i--) {
				if (o.equals(stack[i])) {
					return i;
				}
			}
		}
		return -1; // 没有找到，返回-1
	}
	
	// 自定义异常
	private static class EmptyStackException extends RuntimeException {
		
		private static final long serialVersionUID = 1L;

		public EmptyStackException() {
			super("堆栈为空");
		}
	}
	
}
