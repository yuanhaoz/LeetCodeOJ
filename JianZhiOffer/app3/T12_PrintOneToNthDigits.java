package app3;

/**  
 *  输入数字n，按照顺序打印出从1最大的n位十进制数。比如输入3，则打印出1/2/3，一直到最大的3位数即999。
 *  
 *  这个题目看起来很简单。我们看到这个问题之后，最容易想到的方法是先求出最大的n位数，然后用一个循环从1开始逐个打印。
 *  但是当输入的n很大的时候，我们求最大的n位数是不是用整形或者长整形都会溢出？也就是说我们需要考虑大数的问题。
 *  
 *  考虑使用数组存储大数
 *  
 * @author 郑元浩 
 * @date 2017年3月15日 下午8:40:44 
 */
public class T12_PrintOneToNthDigits {

	public static void main(String[] args) {
		printOneToNthDigits(2);
//		printOneToNthDigits(0);
//		printOneToNthDigits(2);
	}
	
	/**
	 *  输入数字n，按照顺序打印出从1最大的n位十进制数。比如输入3，则打印出1/2/3，一直到最大的3位数即999。
	 *  [第二种方法，比上一种少用内存空间]
	 * @param n 数字的最大位数
	 */
	public static void printOneToNthDigits(int n){
		// 输入值必须大于0
		if(n < 1){
			throw new RuntimeException("The input number must be larger than 0");
		}
		// 创建一个长度为n的数组
		int[] arr = new int[n];
		// 为数组元素赋初始值
		for (int i = 0; i < arr.length; i++) {
			arr[i] = 0;
		}
		// 求结果，如果最高位没有进位就一直进行处理
		while(addOne(arr) == 0){
			printArray(arr);
		}
	}
	
	/**
	 * 对arr表示的数组的最低位加1，arr中的每个数都不能超过9或者不能小于0，每个位置模拟一个数位
	 * @param arr 待加数组
	 * @return 判断最高位是否有进位，如果有进位就返回1，否则返回0
	 */
	public static int addOne(int[] arr){
		// 保存进位值，因为每次最低位加1
		int carry = 1;
		// 最低位的位置的后一位
		int index = arr.length;
		
		do{
			// 指向上一个位置
			index--;
			// 处理位置的值加上进位的值
			arr[index] += carry;
			// 求处理位置的进位
			carry = arr[index] / 10;
			// 求处理位置的值
			arr[index] %= 10;
		} while (carry != 0 && index > 0);
		
		// 如果index=0说明已经处理到了最高位，carry>0说明最高位有进位，返回1
		if (carry > 0 && index == 0) {
			return 1;
		}
		// 无进位返回0
		return 0;
	}
	
	/**
	 * 输入数组的元素，从左到右，从第一个非0的值开始输出到最后的元素。
	 * @param arr
	 */
	public static void printArray(int[] arr){
		// 找到第一个非0的元素
		int index = 0;
		while(index < arr.length && arr[index] == 0){
			index++;
		}
		
		// 从第一个非0值开始输出到最后的元素。
		for (int i = index; i < arr.length; i++) {
			System.out.print(arr[i]);
		}
		// 条件成立，说明数组中有非零元素，所以需要换行
		if (index < arr.length) {
			System.out.println();
		}
	}
	
}
