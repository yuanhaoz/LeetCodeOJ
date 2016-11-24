package niuke;

/**
 * [编程题] 单词接龙
拉姆刚开始学习英文单词，对单词排序很感兴趣。
如果给拉姆一组单词，他能够迅速确定是否可以将这些单词排列在一个列表中，使得该列表中任何单词的首字母与前一单词的为字母相同。
你能编写一个程序来帮助拉姆进行判断吗？
输入描述: 输入包含多组测试数据。	对于每组测试数据，第一行为一个正整数n，代表有n个单词。	
		然后有n个字符串，代表n个单词。		保证：2<=n<=200,每个单词长度大于1且小于等于10,且所有单词都是由小写字母组成。
输出描述:
对于每组数据，输出"Yes"或"No"
输入例子:
  3
  abc
  cdefg
  ghijkl
  4
  abc
  cdef
  fghijk
  xyz
输出例子:
  Yes
  No
 * @author yuanhao
 *
 */

import java.util.ArrayList;
import java.util.Scanner;

public class BaiduDancijielong {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		slove();
	}
	
	public static void slove(){
        sc = new Scanner(System.in);
        while(sc.hasNext()){
            int n=sc.nextInt();
            sc.nextLine();
            String word=sc.nextLine();
            char rail=word.charAt(word.length()-1);
            boolean flag=true;
            for(int i=1;i<n;i++){
                word=sc.nextLine();
                if(word.charAt(0)!=rail)
                flag=false;
                rail=word.charAt(word.length()-1);
                 
            }
            if(flag==true)
                System.out.println("Yes");
            else
                System.out.println("No");
        }
    }
	
	private static int count = 0;
	private static Scanner sc;
	private static Scanner in;
	
	public static void judge(){
		ArrayList<String> in = getInput();
		int flag = 0;
		for(int i = 0; i < in.size(); i++){
			count = 0;
			String first = in.get(i);
//			System.out.println("now is recursion: " + first);
			jieLong(first, in);
//			System.out.println(count);
//			System.out.println("---------------------------");
			if (count == in.size()){
				flag = 1;
				break;
			}
		}
		if(flag == 1){
			System.out.println("Yes");
		} else {
			System.out.println("No");
		}
	}
	
	public static void jieLong(String first, ArrayList<String> in){
		count++;
		char ltc = first.charAt(first.length() - 1);
		for(int j = 0; j < in.size(); j++){
			String next = in.get(j);
			char ftc = next.charAt(0);
			if(!first.equals(next)){
				if (ftc == ltc) {
					jieLong(next, in);
//					System.out.println(first + " ----> " + next);
				} else {
//					System.out.println("...................");
				}
			} else {
//				System.out.println("*******************");
			}
			
		}
	}
	
	/**
	 * 得到输入的数据
	 * @return
	 */
	public static ArrayList<String> getInput(){
		in = new Scanner(System.in);
		int n = in.nextInt();
		in.nextLine(); // 匹配换行符
		ArrayList<String> input = new ArrayList<String>(n);
		while(n != 0){
			n = n - 1;
			input.add(in.nextLine());
		}
//		System.out.println("-----------------------");
//		for(int i = 0; i < input.size(); i++){
//			System.out.println("number is: " + input.get(i));
//		}
		return input;
	}

}
