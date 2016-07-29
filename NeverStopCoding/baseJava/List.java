package baseJava;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

/**
 * List的特征是其元素以线性方式存储，集合中可以存放重复对象。
 * List接口主要实现类包括：
 * ArrayList()：代表长度可以改变的数组。可以对元素进行随机的访问，向ArrayList()中插入与删除元素的速度慢。
 * LinkedList()：在实现中采用链表数据结构。插入和删除速度快，访问速度慢。
 * 对于List的随机访问来说，就是只随机来检索位于特定位置的元素。
 * List的get(int index)方法放回集合中由参数index指定的索引位置的对象，下标从"0"开始。
 * @author yuanhao
 *
 * List的功能方法
 * 实际上有两种List: 一种是基本的ArrayList,其优点在于随机访问元素，另一种是更强大的LinkedList,它并不是为快速随机访问设计的，而是具有一套更通用的方法。
 * List : 次序是List最重要的特点：它保证维护元素特定的顺序。List为Collection添加了许多方法，使得能够向List中间插入与移除元素
 	(这只推 荐LinkedList使用。)一个List可以生成ListIterator,使用它可以从两个方向遍历List,也可以从List中间插入和移除元 素。
 * ArrayList : 由数组实现的List。允许对元素进行快速随机访问，但是向List中间插入与移除元素的速度很慢。ListIterator只应该用来由后向前
 	遍历ArrayList,而不是用来插入和移除元素。因为那比LinkedList开销要大很多。
 * LinkedList : 对顺序访问进行了优化，向List中间插入与删除的开销并不大。随机访问则相对较慢。(使用ArrayList代替。)
 	还具有下列方 法：addFirst(), addLast(), getFirst(), getLast(), removeFirst() 和 removeLast(), 
 	这些方法 (没有在任何接口或基类中定义过)使得LinkedList可以当作堆栈、队列和双向队列使用。
 */
public class List {
	
	public static void testList(){
		System.out.println("---------------------------------");
		ArrayList<String> al = new ArrayList<String>();
		al.add("hello");
		al.add("world");
		for(int i = 0; i < al.size(); i++){
			System.out.println(al.get(i));
		}
		Iterator it = al.iterator();
		while(it.hasNext()){
			System.out.println(it.next());
		}
		
		System.out.println("---------------------------------");
		LinkedList<String> list = new LinkedList<String>();
		list.add("ni");
		list.add("hao");
		list.add("zheng");
		list.add("hao");
		for(int i = 0; i < list.size(); i++){
			System.out.println(list.get(i));
		}
		System.out.println("---------------------------------");
		list.removeFirst();
		list.addFirst("haha");
		list.addLast("hahhaha");
		for(int i = 0; i < list.size(); i++){
			System.out.println(list.get(i));
		}
	}

}
