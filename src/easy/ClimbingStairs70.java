package easy;
/**  
 * 70. Climbing Stairs   Add to List QuestionEditorial Solution  My Submissions
Total Accepted: 149599
Total Submissions: 386845
Difficulty: Easy
Contributors: Admin

You are climbing a stair case. It takes n steps to reach to the top.

Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

Note: Given n will be a positive integer.

Subscribe to see which companies asked this question   
 *  
 * @author 郑元浩 
 * @date 2017年1月15日 下午10:32:17 
 */
public class ClimbingStairs70 {

	public static void main(String[] args) {
		System.out.println(climbStairs(0));
		System.out.println(climbStairs(1));
		System.out.println(climbStairs(2));
		System.out.println(climbStairs(3));
		System.out.println(climbStairs(4));
		System.out.println(climbStairs(5));
	}
	
	/**
	 * 斐波那契数列
	 * f(n) = f(n-1) + f(n-2)
	 * @param n
	 * @return
	 */
	public static int climbStairs(int n) {
		int result = 0;
		if (n <= 2) {
			return n;
		}
		if (n > 2) {
			int[] f = new int[n];
			f[0] = 0;
			f[1] = 1;
			f[2] = 2;
			for (int i = 3; i < n; i++) {
				f[i] = f[i - 1] + f[i - 2];
			}
			result = f[n-1] + f[n-2];
		}
		return result;
    }
	

}
