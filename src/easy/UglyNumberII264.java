package easy;


/**  
 * 类说明   
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
