package niuke;

import java.util.Scanner;

/**  
 * 超级素数幂：
 * 如果 一个数字能表示为p^q（^表示幂运算）且p为一个素数，q为大于1的正整数就称这个数为超级素数幂。现在给出一个正整数n，如果n是一个超级素数幂需要找出对应的p,q 
 *  
 * @author 郑元浩 
 * @date 2017年3月7日 下午7:28:49 
 */
public class JavaSkillTest1 {

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int p = 2, q = 2;
		while (judge(p)) {
			int m = (int)Math.pow(p, q);
			System.out.println(m);
			while (m < n) {
				q++;
			}
			if (m == n) {
				System.out.println(p + " " + q);
			} else {
				p++;
				while (!judge(p)) {
					p++;
				}
			}
		}
	}
	
	public static boolean judge(int p){
		boolean flag = true;
		for (int i = 2; i < p/2; i++) {
			if (p % i == 0) {
				flag = false;
			}
		}
		return flag;
	}

}
