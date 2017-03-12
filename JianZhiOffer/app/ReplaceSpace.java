package app;
/**  
 * 请实现一个函数，将一个字符串中的空格替换成“%20”。例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。   
 *  
 * @author 郑元浩 
 * @date 2017年2月24日 下午8:51:52 
 */
public class ReplaceSpace {

	public static void main(String[] args) {
		StringBuffer str = new StringBuffer();
		str.append("We Are Happy");
		System.out.println(replaceSpace(str));
	}
	
	public static String replaceSpace(StringBuffer str) {
    	String newstr = str.toString();
    	newstr = newstr.replace(" ", "%20");
        return newstr;
    }
	

}
