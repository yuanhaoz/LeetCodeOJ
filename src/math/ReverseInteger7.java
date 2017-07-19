package math;

/**
 * 7. Reverse Integer
Reverse digits of an integer.

Example1: x = 123, return 321
Example2: x = -123, return -321

click to show spoilers.

Note:
The input is assumed to be a 32-bit signed integer. 
Your function should return 0 when the reversed integer overflows.
 * @author 郑元浩
 * @date 2017年7月12日 下午6:19:13
 *
 */
public class ReverseInteger7 {

	public static void main(String[] args) {
		reverse(1201);
		reverse(120100);
		reverse(534236469);
		reverse(1534236469);
	}
	
	/**
	 * 每次对数字除以10的余数加上已有数字乘以10。就是每次该整数的各位数字取出来，然后加上已经倒序了一部分的数乘以10，就是新的倒序的数。
	 * @param x
	 * @return
	 */
	public static int reverse(int x) {
		int result = 0; // 保存最终的结果
		while(x != 0){ // 判断该数有没有处理结束
			int temp = result * 10 + x % 10; // 实现倒序
			if ((temp - x % 10) / 10 != result) { // 判断是否溢出，溢出的话进行逆运算无法得到原来的数
				return 0;
			}
			x = x / 10; // 更新目前的数
			result = temp;
		}
		System.out.println(result);
		return result;
    }

}
