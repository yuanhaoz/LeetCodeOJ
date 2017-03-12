package create;
/**  
 * 单例模式
单例模式（Singleton Pattern）是 Java 中最简单的设计模式之一。这种类型的设计模式属于创建型模式，它提供了一种创建对象的最佳方式。
这种模式涉及到一个单一的类，该类负责创建自己的对象，同时确保只有单个对象被创建。这个类提供了一种访问其唯一的对象的方式，可以直接访问，不需要实例化该类的对象。
注意：
1、单例类只能有一个实例。
2、单例类必须自己创建自己的唯一实例。
3、单例类必须给所有其他对象提供这一实例。   
 *  
 * @author 郑元浩 
 * @date 2017年3月10日 下午6:05:08 
 */

/*
 * 步骤 1
创建一个 Singleton 类。
 */
class SingleObject {
	// 创建SingleObject的一个对象
	private static SingleObject instance = new SingleObject();
	// 让构造函数为private，这样该类就不会被实例化
	private SingleObject(){}
	// 获取唯一可用的对象
	public static SingleObject getInstance(){
		return instance;
	}
	public void showMessage(){
		System.out.println("Hello World!");
	}
}

/*
 * 步骤 2
从 singleton 类获取唯一的对象。
 */
public class SingletonPatternTest {

	public static void main(String[] args) {
		// 不合法的构造函数
		// 编译时错误：构造函数SingleObject()是不可见的
//		SingleObject object = new SingleObject();
		
		// 获取唯一可用的对象
		SingleObject object = SingleObject.getInstance();
		
		// 显示消息
		object.showMessage();
	}

}
