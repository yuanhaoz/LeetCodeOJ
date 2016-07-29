package algorithmJava;

/**
 * 计算两个非负整数p和q的最大公约数：若q是0，则最大公约数为p。否则，将p除以q得到余数r，p和q的最大公约数即为q和r的最大公约数。
 * @author yuanhao
 *
 */
public class Euclidean {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(gcd(10,60));
		System.out.println(gcd(60,10));
		System.out.println(gcd(36,99));
	}
	
	public static int gcd(int p, int q){
		if(p == 0){
			return q;
		} 
		if(q == 0){
			return p;
		}
		int r = p % q;
		return gcd(q, r);
	}
	
}
