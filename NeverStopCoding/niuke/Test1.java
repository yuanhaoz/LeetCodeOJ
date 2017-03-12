package niuke;

import java.util.Scanner;

/**  
 * 求a+b的和   
 *  
 * @author 郑元浩 
 * @date 2017年3月7日 下午7:25:51 
 */
public class Test1 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {//注意while处理多个case
            int a = in.nextInt();
            int b = in.nextInt();
            System.out.println(a + b);
        }
	}
	
	public static void test1(){
		Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int ans = 0, x;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                x = sc.nextInt();
                ans += x;
            }
        } 
        System.out.println(ans);
	}

}
