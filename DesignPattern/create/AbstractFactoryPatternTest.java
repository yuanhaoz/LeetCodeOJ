package create;
/**  
 * 抽象工厂模式
抽象工厂模式（Abstract Factory Pattern）是围绕一个超级工厂创建其他工厂。该超级工厂又称为其他工厂的工厂。
这种类型的设计模式属于创建型模式，它提供了一种创建对象的最佳方式。
在抽象工厂模式中，接口是负责创建一个相关对象的工厂，不需要显式指定它们的类。每个生成的工厂都能按照工厂模式提供对象。   
 *  
 * @author 郑元浩 
 * @date 2017年3月7日 下午10:14:08 
 */

/*
 * 步骤 1
为形状创建一个接口。（见FactoryPatternTest中的定义）

 *步骤 2
创建实现接口的实体类。（见FactoryPatternTest中的定义）
 */

/*
 * 步骤 3
为颜色创建一个接口。
 */
interface Color {
	void fill();
}

/*
 * 步骤 4
创建实现接口的实体类。 
 */
class Red implements Color{
	@Override
	public void fill() {
		System.out.println("Inside Red::fill() method.");
	}
}
class Green implements Color{
	@Override
	public void fill() {
		System.out.println("Inside Green::fill() method.");
	}
}
class Blue implements Color{
	@Override
	public void fill() {
		System.out.println("Inside Blue::fill() method.");
	}
}

/*
 * 步骤 5
为 Color 和 Shape 对象创建抽象类来获取工厂。
 */
abstract class AbstractFactory {
	abstract Color getColor(String color);
	abstract Shape getShape(String shape);
}

/*
 * 步骤 6
创建扩展了 AbstractFactory 的工厂类，基于给定的信息生成实体类的对象。
 */
class ShapeFactory1 extends AbstractFactory {

	@Override
	public Shape getShape(String shapeType){
		if(shapeType == null){
			return null;
		}		
		if(shapeType.equalsIgnoreCase("CIRCLE")){
			return new Circle();
		} else if(shapeType.equalsIgnoreCase("RECTANGLE")){
			return new Rectangle();
		} else if(shapeType.equalsIgnoreCase("SQUARE")){
			return new Square();
		}
		return null;
	}

	@Override
	Color getColor(String color) {
		return null;
	}
}

class ColorFactory extends AbstractFactory {

	@Override
	public Shape getShape(String shapeType){
		return null;
	}

	@Override
	Color getColor(String color) {
		if(color == null){
			return null;
		}		
		if(color.equalsIgnoreCase("RED")){
			return new Red();
		} else if(color.equalsIgnoreCase("GREEN")){
			return new Green();
		} else if(color.equalsIgnoreCase("BLUE")){
			return new Blue();
		}
		return null;
	}
}

/*
 * 步骤 7
创建一个工厂创造器/生成器类，通过传递形状或颜色信息来获取工厂。
 */
class FactoryProducer{
	public static AbstractFactory getFactory(String choice){
		if (choice.equalsIgnoreCase("SHAPE")) {
			return new ShapeFactory1();
		} else if (choice.equalsIgnoreCase("COLOR")) {
			return new ColorFactory();
		}
		return null;
	}
}



public class AbstractFactoryPatternTest {

	public static void main(String[] args) {
		// 获取形状工厂
		AbstractFactory shapeFactory = FactoryProducer.getFactory("shape");
		// 获取形状为Circle的对象
		Shape shape1 = shapeFactory.getShape("circle");
		shape1.draw();
		Shape shape2 = shapeFactory.getShape("square");
		shape2.draw();
		Shape shape3 = shapeFactory.getShape("rectangle");
		shape3.draw();
		
		// 获取颜色工厂
		AbstractFactory colorFactory = FactoryProducer.getFactory("color");
		// 获取形状为Circle的对象
		Color color1 = colorFactory.getColor("Red");
		color1.fill();
		Color color2 = colorFactory.getColor("Green");
		color2.fill();
		Color color3 = colorFactory.getColor("Blue");
		color3.fill();
	}

}
