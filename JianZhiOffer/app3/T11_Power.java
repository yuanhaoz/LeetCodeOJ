package app3;
/**  
 * 类说明   
 *  
 * @author 郑元浩 
 * @date 2017年3月15日 下午8:05:28 
 */
public class T11_Power {

	public static void main(String[] args) {
//		System.out.println(0.000000000000000000000000 == 0);
		System.out.println(0.000000000000000000001111 == 0);
		
		System.out.println(Power(2, 4));
		System.out.println(Power(2, -4));
		System.out.println(Power(2, 0));
		System.out.println(Power(0.00000000000000000000000001, -1));
		System.out.println(Power(0.00000000000000000000000001, 1));
		System.out.println(Power(0.00000000000000000000000001, 0));
		System.out.println(Power(0.00000000000000000000000000, 0));
	}
	
	public static double Power(double base, int exponent) {
		// 指数和底数不能同时为0
		if (base == 0 && exponent == 0) {
			throw new RuntimeException("invalid input. base and exponent both are zero");
		}
		
		// 指数为0就返回1
		if (exponent == 0) {
			return 1;
		}
		
		// 求指数的绝对值
		long exp = exponent;
		if (exp < 0) {
			exp = -exp;
		}
		
		// 求幂次方
		double result = powerWithUnsignedExponent(base, exp);
		
		// 指数是负数，要进行求导数
		if (exponent < 0) {
			result = 1 / result;
		}
		
		// 返回结果
		return result;
	}
	
	public static double powerWithUnsignedExponent(double base, long exp){
		// 如果指数为0，返回1
		if (exp == 0) {
			return 1;
		}
		// 指数为1，返回底数
		if (exp == 1) {
			return base;
		}
		// 递归求一半的值
		double result = powerWithUnsignedExponent(base, exp >> 1);
		// 求最终的值，如果是奇数就还要乘以一次底数
		result *= result;
		if ((exp & 0x01) == 1) { // 用位与运算符代替了求余运算符（%）来判断一个数是奇数还是偶数。位运算效率比乘除法及求余运算的效率要高很多。
			result *= base;
		}
		// 返回结果
		return result;
	}

}
