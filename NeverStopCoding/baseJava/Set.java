package baseJava;

import java.util.HashSet;
import java.util.Iterator;

/**
 * Set是最简单的一种集合。集合中的对象不按特定的方式排序，并且没有重复对象。存放的是对象的引用，没有重复对象
 * Set接口主要实现了两个实现类：
 * HashSet : HashSet类按照哈希算法来存取集合中的对象，存取速度比较快
 * TreeSet : TreeSet类实现了SortedSet接口，能够对集合中的对象进行排序。
 * @author yuanhao
 *
 * Set具有与Collection完全一样的接口，因此没有任何额外的功能，不像前面有两个不同的List。
 	实际上Set就是 Collection,只是行为不同。(这是继承与多态思想的典型应用：表现不同的行为。)Set不保存重复的元素(至于如何判断元素相同则较为负责)
 * Set : 存入Set的每个元素都必须是唯一的，因为Set不保存重复元素。加入Set的元素必须定义equals()方法以确保对象的唯一性。
	Set与Collection有完全一样的接口。Set接口不保证维护元素的次序。
 * HashSet : 为快速查找设计的Set。存入HashSet的对象必须定义hashCode()。
 * TreeSet : 保存次序的Set, 底层为树结构。使用它可以从Set中提取有序的序列。
 * LinkedHashSet : 具有HashSet的查询速度，且内部使用链表维护元素的顺序(插入的次序)。于是在使用迭代器遍历Set时，结果会按元素插入的次序显示。
 */

public class Set {

	public static void testHashSet(){
		HashSet<String> set = new HashSet<String>();
		String s1 = new String("hello");
		String s2 = s1;
		String s3 = new String("world");
		set.add(s1);
		set.add(s2);
		set.add(s3);
		System.out.println(set.size());
		Iterator<String> it = set.iterator();
		while(it.hasNext()){
			String str = it.next().toString();
			System.out.println(str);
		}
	}

}
