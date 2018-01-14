package app3;
/**  
 * 面试题11：数值的整数次方
 * 题目：实现函数double Power(double base, int exponent)，求base的exponent次方。不得使用库函数，同时不需要考虑大数问题。
 * 考虑base为0，exponent为大于0或0或小于0（求反）等情况
 *
 * 高效解法：
 * base^exponent = (base^(exponent/2))*(base^(exponent/2))   if exponent为偶数
 * base^exponent = (base^(exponent/2))*(base^(exponent/2))*base   if exponent为奇数
 *
 * @author 郑元浩 
 * @date 2017年3月15日 下午8:05:28 
 */
public class T11_Power {

	public static void main(String[] args) {
//		System.out.println(0.000000000000000000000000 == 0);
		System.out.println(0.000000000000000000001111 == 0);
		System.out.println("-----------------------------------");
		System.out.println(Power(2, 4));
		System.out.println(Power(2, -4));
		System.out.println(Power(2, 0));
//		System.out.println(Power(0, 0));
		System.out.println(Power(0, 1));
		System.out.println("-----------------------------------");
		System.out.println(powerWithUnsignedExponent2(2, 4));
		System.out.println(powerWithUnsignedExponent2(2, -4));
		System.out.println(powerWithUnsignedExponent2(2, 0));
		System.out.println(powerWithUnsignedExponent2(0, 0));
		System.out.println(powerWithUnsignedExponent2(0, 1));
//		System.out.println("-----------------------------------");
//		System.out.println(Power(0.00000000000000000000000001, -1));
//		System.out.println(Power(0.00000000000000000000000001, 1));
//		System.out.println(Power(0.00000000000000000000000001, 0));
//		System.out.println(Power(0.00000000000000000000000000, 0));
	}
	
	public static double Power(double base, int exponent) {
		// 指数和底数不能同时为0
		if (equal(base, 0) && exponent == 0) {
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

	/**
	 * 比较两个浮点数是否相同
	 * 由于在计算机内表示小数时（包括float和double型小数）都有误差。判断两个小数是否相等，只能判断它们之差的绝对值是不是
	 * 在一个很小的范围内。如果两个数相差很小，就可以认为它们相等。
	 * @param m1
	 * @param m2
	 * @return
	 */
	public static boolean equal(double m1, double m2) {
		if ((m1 - m2) < 0.0000001 && (m1 - m2) > -0.0000001) {
			return true;
		} else {
			return false;
		}
	}

	public static double powerWithUnsignedExponent2(double base, long exp){
		if (exp == 0) { // 指数为0，返回1
			return 1;
		}
		if (exp == 1) { // 指数为1，返回底数
			return base;
		}
		if (equal(base, 0)) { // 底数为0，返回0
			return 0;
		}
		if (exp > 0) { // 指数为正
			double result = powerWithUnsignedExponent2(base, exp >> 1);
			result *= result;
			if ((exp & 1) == 1) { // 指数为奇数
				result *= base;
			}
			return result;
		} else {  // 指数为负
			exp = -exp; // 求反
			double result = powerWithUnsignedExponent2(base, exp >> 1);
			result *= result;
			if ((exp & 1) == 1) { // 指数为偶数
				result *= base;
			}
			return 1 / result; // 求反
		}
	}

}
