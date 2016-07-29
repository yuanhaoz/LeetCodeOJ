package baseJava;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

/**
 * Map是一种把键对象和值对象映射的集合，它的每一个元素都包含一对键对象和值对象。
 * Map没有继承于Collection接口
 * 从Map集合中检索元素时，只要给出键对象，就会返回对应的值对象。
 * Map的常用方法：
 * 1.添加，删除操作：Object put(Object key, Object value): 向集合中加入元素
     Object remove(Object key):   删除与KEY相关的元素
     void putAll(Map t):   将来自特定映像的所有元素添加给该映像
     void clear():从映像中删除所有映射
 * 2.查询操作：
     Object get(Object key): 获得与关键字key相关的值
     Map集合中的键对象不允许重复，也就说，任意两个键对象通过equals()方法比较的结果都是false.
            但是可以将任意多个键独享映射到同一个值对象上。
 * @author yuanhao
 * 方法put(Object key, Object value)添加一个“值”(想要得东西)和与“值”相关联的“键”(key)(使用它来查找)。方法get(Object key)返回与给定“键”相关联的“值”。可以用containsKey()和containsValue()测试Map中是否包含某个“键”或“值”。 标准的Java类库中包含了几种不同的Map：HashMap, TreeMap, LinkedHashMap, WeakHashMap, IdentityHashMap。它们都有同样的基本接口Map，但是行为、效率、排序策略、保存对象的生命周期和判定“键”等价的策略等各不相同。
	执行效率是Map的一个大问题。看看get()要做哪些事，就会明白为什么在ArrayList中搜索“键”是相当慢的。而这正是 HashMap提高速度的地方。HashMap使用了特殊的值，称为“散列码”(hash code)，来取代对键的缓慢搜索。“散列码”是“相对唯一”用以代表对象的int值，它是通过将该对象的某些信息进行转换而生成的。所有Java对象都 能产生散列码，因为hashCode()是定义在基类Object中的方法。
	HashMap就是使用对象的hashCode()进行快速查询的。此方法能够显着提高性能。
	Map : 维护“键值对”的关联性，使你可以通过“键”查找“值”
	HashMap : Map基于散列表的实现。插入和查询“键值对”的开销是固定的。可以通过构造器设置容量capacity和负载因子load factor，以调整容器的性能。
	LinkedHashMap : 类似于HashMap，但是迭代遍历它时，取得“键值对”的顺序是其插入次序，或者是最近最少使用(LRU)的次序。只比HashMap慢一点。而在迭代访问时发而更快，因为它使用链表维护内部次序。
	TreeMap : 基于红黑树数据结构的实现。查看“键”或“键值对”时，它们会被排序(次序由Comparabel或Comparator决定)。TreeMap的特点在 于，你得到的结果是经过排序的。TreeMap是唯一的带有subMap()方法的Map，它可以返回一个子树。
	WeakHashMao : 弱键(weak key)Map，Map中使用的对象也被允许释放: 这是为解决特殊问题设计的。如果没有map之外的引用指向某个“键”，则此“键”可以被垃圾收集器回收。
	IdentifyHashMap : 使用==代替equals()对“键”作比较的hash map。专为解决特殊问题而设计。
 */
public class Map {
	
	public static void testHashMap(){
		System.out.println("---------------------------------");
		HashMap<String, String> map = new HashMap<String, String>();
		map.hashCode();
		map.put("a", "yuanhao");
		map.put("b", "linglng");
		map.put("c", "jianhong");
		for(Entry<String, String> entry : map.entrySet()){
			String key = entry.getKey();
			String value = entry.getValue();
			System.out.println(key);
			System.out.println(value);
		}
		
		System.out.println("---------------------------------");
		for(String key : map.keySet()){
			String value = map.get(key);
			System.out.println(key);
			System.out.println(value);
		}
		
		System.out.println("---------------------------------");
		Iterator<Entry<String, String>> it = map.entrySet().iterator();
		while(it.hasNext()){
			Entry<String, String> entry = it.next();
			String key = entry.getKey();
			String value = entry.getValue();
			System.out.println(key);
			System.out.println(value);
		}
		
	}

}
