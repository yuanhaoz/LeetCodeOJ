package easy;

/**  
 * 264. Ugly Number II   Add to List QuestionEditorial Solution  My Submissions
Total Accepted: 48577
Total Submissions: 154643
Difficulty: Medium
Contributors: Admin
Write a program to find the n-th ugly number.

Ugly numbers are positive numbers whose prime factors only include 2, 3, 5. For example, 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 is the sequence of the first 10 ugly numbers.

Note that 1 is typically treated as an ugly number.

Hint:

The naive approach is to call isUgly for every number until you reach the nth one. Most numbers are not ugly. Try to focus your effort on generating only the ugly ones.
An ugly number must be multiplied by either 2, 3, or 5 from a smaller ugly number.
The key is how to maintain the order of the ugly numbers. Try a similar approach of merging from three sorted lists: L1, L2, and L3.
Assume you have Uk, the kth ugly number. Then Uk+1 must be Min(L1 * 2, L2 * 3, L3 * 5).
Credits:
Special thanks to @jianchao.li.fighter for adding this problem and creating all test cases.

Subscribe to see which companies asked this question
   
 *  
 * @author 郑元浩 
 * @date 2016年12月29日 下午3:53:21 
 */

public class UglyNumberII264 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(nthUglyNumber(1) + " " + nthUglyNumber2(1));
		System.out.println(nthUglyNumber(4) + " " + nthUglyNumber2(4));
		System.out.println(nthUglyNumber(7) + " " + nthUglyNumber2(7));
		System.out.println(nthUglyNumber(10) + " " + nthUglyNumber2(10));
		System.out.println(nthUglyNumber(150) + " " + nthUglyNumber2(150));
	}
	
	/**
	 * 动态规划的思想
	 * 找到ugly数
	 * 当前的ugly为之前的某个ugly的ugly*2，ugly*3，ugly*5
	 * @param n
	 * @return
	 */
	public static int nthUglyNumber(int n) {
		int[] ugly = new int[n];
		ugly[0] = 1;
		int p2=0, p3=0, p5=0;
		int up2=ugly[p2]*2;
		int up3=ugly[p3]*3;
		int up5=ugly[p5]*5;
		int smallUgly = 1;
		for (int i = 1; i < n; i++) {
			smallUgly = Math.min(up2, up3);
			smallUgly = Math.min(smallUgly, up5);
			ugly[i] = smallUgly;
			if (smallUgly == up2) {
				p2++;
				up2 = ugly[p2]*2;
			}
			if (smallUgly == up3) {
				p3++;
				up3 = ugly[p3]*3;
			}
			if (smallUgly == up5) {
				p5++;
				up5 = ugly[p5]*5;
			}
		}
		return smallUgly;
	}
	
	/**
	 * 时间复杂度太高，空间复杂度为O(1)，测试的时候超时
	 * 解决思路：空间换时间
	 * @param n
	 * @return
	 */
	public static int nthUglyNumber2(int n) {
        int num=0;
		while(n!=0){
        	num++;
        	if (isUgly(num)) {
				n--;
			}
        }
		return num;
    }
	
	/**
	 * 多比较一次，效果更差
	 * @param num
	 * @return
	 */
	public static boolean isUgly2(int num){
		for (int i=2; i<6 && num>0; i++)
		    while (num % i == 0)
		        num /= i;
		return num == 1;
	}
	
	public static boolean isUgly(int num){
		if (num == 0) {
			return false;
		} else {
			while(num%2==0){
				num/=2;
			}
			if (num==1) {
				return true;
			}
			while(num%3==0){
				num/=3;
			}
			if (num==1) {
				return true;
			}
			while(num%5==0){
				num/=5;
			}
		}
		return num==1;
	}

}
