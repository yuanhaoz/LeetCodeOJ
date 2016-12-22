package utils;

import java.util.List;

/**  
 * 类说明   
 *  
 * @author 郑元浩 
 * @date 2016年12月21日
 */
public class Log {

	private static final Boolean flag = true;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static void log(Object object){
		if (flag) {
			System.out.println(object);
		}
	}
	
	public static void log(List<Object> object){
		for (int i = 0; i < object.size(); i++) {
			log(object.get(i));
		}
	}
	
}
