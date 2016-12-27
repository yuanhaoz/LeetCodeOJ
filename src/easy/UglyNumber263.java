package easy;
/**  
 * 类说明   
 *  
 * @author 郑元浩 
 * @date 2016年12月29日 下午3:53:21 
 */
public class UglyNumber263 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(isUgly(0) + " " + isUgly2(0));
		System.out.println(isUgly(14) + " " + isUgly2(14));
		System.out.println(isUgly(32) + " " + isUgly2(32));
		System.out.println(isUgly(432) + " " + isUgly2(432));
		System.out.println(isUgly(234424) + " " + isUgly2(234424));
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
	
	public static boolean isUgly2(int num){
		for (int i=2; i<6 && num>0; i++)
		    while (num % i == 0)
		        num /= i;
		return num == 1;
	}

}
