package niuke;
import java.util.Scanner;
import javax.swing.JOptionPane;


/**
 * 回文描述：正着读过去和倒着读回来的字符串序列相同则为回文，如：1h3gkg3h1是回文
 * @author tong
 *
 */
public class huiwenshuzu {
    public static void main(String[] args) {
     //可以使用javax.swing.JOptionPane类中的showInputDialog()方法提示用户输入字母或者数字串
        String s = JOptionPane.showInputDialog("请输入输入字符串:");  
        //调用isPalindromeByBuffer()方法
        String output = s + (isPalindromeByBuffer(s)?"是":"不是")+"回文。";
        JOptionPane.showMessageDialog(null, output);
        
        s = JOptionPane.showInputDialog("请输入输入字符串:");
        //调用isPalindromeByCharAt()方法
        output = s + (isPalindromeByCharAt(s)?"是":"不是")+"回文。";      
        JOptionPane.showMessageDialog(null, output);
        
        //使用Scanner(System.in)方法提示用户输入字符串
  System.out.println("请输入输入字符串:");
  Scanner in=new Scanner(System.in);
  String strOrigin=in.next(); 
  //调用isPalindromeByCharAtSingle()方法
  System.out.print(strOrigin + (isPalindromeByCharAtSingle(s)?"是":"不是")+"回文。");

 


    }
    
    /**
    * 通过调用StringBuffer的对象的reverse()方法，来判断翻转前后字符串是否相等，确定是否为回文
    * @param s
    * @return
    */
    public static boolean isPalindromeByBuffer(String s) {
        String strOrigin = filterLetterAndDigit(s);
        //将strOrigin作为输入参数，构造一个StringBuffer对象
        StringBuffer strBuf = new StringBuffer(strOrigin);
        //调用StringBuffer对象自带的reverse()方法进行字符串翻转，最后调用toString()返回一个String类型字符串
        String strAfterReverse = strBuf.reverse().toString();  
        //通过equals()方法判断原来的字符串和翻转后的字符串是否相等，来确定是否为回文
        return strOrigin.equals(strAfterReverse);
    }
    
    /**
    * 通过字符串中的对称位置字符串是否相同来判断是否为回文,这里用了两个变量low和high来分别对应字符串对称位置的index
    * @param s
    * @return
    */
    public static boolean isPalindromeByCharAt(String s) {
     //low和high分别对应字符串对称位置的index，以此来判断所有对称位置字符是否相同
        int low = 0;
        int high = s.length() - 1;
        while (low < high) {
            if (s.charAt(low) != s.charAt(high))
                return false;  // 不是回文
            low++;
            high--;
        }
        return true;          // 是回文
    }
    
    /**
    * 通过字符串中的对称位置字符串是否相同来判断是否为回文,这里用了一个变量i来对应字符串对称位置的index
    * @param s
    * @return
    */
    public static boolean isPalindromeByCharAtSingle(String s) {
     //通过对称下标的关系使用一个变量即可判断所有对称位置字符是否相同
     for(int i=0;i<s.length()/2;i++){
      //只有当前一半字符串和后一半字符串对应位置相同，那么才是回文，只有有一个对称位置的字符不同就不是回文
      if(s.charAt(i)!=s.charAt(s.length()-i-1)){
       return false;
      }
     }
        
        return true;  
    }
    
    /**
    * 通过调用Character.isLetterOrDigit(Char char)过滤字母或者数字，判断字母或者数字的组合是否为回文
    * @param s
    * @return String
    */
    public static String filterLetterAndDigit(String s) {
        StringBuffer strBuf = new StringBuffer();
        for (int i = 0; i < s.length(); i++) {
            if (Character.isLetterOrDigit(s.charAt(i))) {
             //调用StringBuffer的append(Char char)方法,将输入的字母或者数字加入其中
                strBuf.append(s.charAt(i));
            }
        }
        //返回String类型，需要将StringBuffer转换为String，需要调用StringBuffer对象的toString()方法
        return strBuf.toString();
    }
    
}