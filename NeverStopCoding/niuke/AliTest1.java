package niuke;
/**  
 * 对于一个长度为N的整型数组A， 数组里所有的数都是正整数，对于两个满足0<=X <= Y <N的整数，A[X], A[X+1] … A[Y]构成A的一个切片，记作(X, Y)。
用三个下标 m1, m2, m3下标满足条件 0 < m1, m1 + 1 < m2, m2 +1 < m3 < N – 1。
可以把这个整型数组分成(0, m1-1), (m1+1, m2-1), (m2+1, m3-1), (m3+1, N-1) 四个切片。如果这四个切片中的整数求和相等，称作“四等分”。
编写一个函数，求一个给定的整型数组是否可以四等分，如果可以，返回一个布尔类型的true，如果不可以返回一个布尔类型的false。
限制条件： 数组A最多有1,000,000项，数组中的整数取值范围介于-1,000,000到1,000,000之间。
要求： 函数的计算复杂度为O(N)，使用的额外存储空间（除了输入的数组之外）最多为O(N)。
例子：
对于数组A=[2, 5, 1, 1, 1, 1, 4, 1, 7, 3, 7] 存在下标 2, 7, 9使得数组分成四个分片[2, 5], [1, 1, 1, 4], [7], [7]，
这三个分片内整数之和相等，所以对于这个数组，函数应该返回true。
对于数组 A=[10, 2, 11, 13, 1, 1, 1, 1, 1]， 找不到能把数组四等分的下标，所以函数应该返回false。   
 *  
 * @author 郑元浩 
 * @date 2017年3月3日 下午7:17:52 
 */
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;


public class AliTest1 {

/** 请完成下面这个函数，实现题目要求的功能 **/
 /** 当然，你也可以不按照这个模板来作答，完全按照自己的想法来 ^-^  **/
    static boolean resolve(int[] A) {
    	if (A.length < 7) {
			return false;
		}
    	int N = A.length;
    	int[] pointer = {1, 3, 5};
    	while(pointer[2] < N - 1){
    		int[] sum = new int[4];
    		// 求四分段的和保存到数组中
    		for (int i = 0; i < pointer[0]; i++) {
				sum[0] += A[i];
			}
    		for (int i = pointer[0] + 1; i < pointer[1]; i++) {
				sum[1] += A[i];
			}
    		for (int i = pointer[1] + 1; i < pointer[2]; i++) {
				sum[2] += A[i];
			}
    		for (int i = pointer[2] + 1; i < N; i++) {
				sum[3] += A[i];
			}
    		// 判断四分段的值是否完全相等
    		System.out.println("m1,m2,m3的值：" + pointer[0] + " " + pointer[1] + " " + pointer[2]);
    		System.out.println("四分段的值：" + sum[0] + " " + sum[1] + " " + sum[2] + " " + sum[3]);
    		int count = 0;
    		for (int i = 0; i < 3; i++) {
    			if (sum[i] == sum[i + 1]) {
					count++;
				}
			}
    		if (count == 3) {
				return true;
			} else {
				count = 0;
			}
    		// 求出四分段中值最小的那个分段，并求出需要移动三个指针中的哪一个
    		// 如果是第一分段最小，移动第一个指针p[0]，第二分段移动第二个指针，第三分段移动第三个指针
    		// 第四分段则直接返回false，因为不管怎么移动都不会相同了。
    		int min = sum[0];
    		int index = 0;
    		for (int i = 1; i < 4; i++) {
				if (sum[i] <= min) {
					min = sum[i];
					index = i;
				}
			}
    		System.out.println("每次比较出的四分段的最小值下标: " + index);
    		if (index == 3) {
				return false;
			}
    		System.out.println("需要移动的指针值是: " + pointer[index]);
    		// 将最小分段的那个指针往后移动一格，移动后如果与它后面的指针相差小于等于1的话，后面的指针也需要往后移动一格。（如果有的话）
    		pointer[index]++;
    		if (index < 2 && pointer[index + 1] - pointer[index] <= 1) {
				pointer[index + 1]++;
			}
    		System.out.println("移动一次m1,m2,m3的值：" + pointer[0] + " " + pointer[1] + " " + pointer[2]);
    		System.out.println("-------------------------------------------------------------------------------");
//    		// 每次循环结束，需要将sum数组清零，以防止不断叠加
//    		for (int i = 0; i < sum.length; i++) {
//				
//			}
    	}
    	return false;
    }

    public static void main(String[] args){
        ArrayList<Integer> inputs = new ArrayList<Integer>();
        Scanner in = new Scanner(System.in);
        String line = in.nextLine();
        while(line != null && !line.isEmpty()) {
            int value = Integer.parseInt(line.trim());
            if(value == 0) break;
            inputs.add(value);
            line = in.nextLine();
        }
        int[] A = new int[inputs.size()];
        for(int i=0; i<inputs.size(); i++) {
            A[i] = inputs.get(i).intValue();
        }
        Boolean res = resolve(A);

        System.out.println(String.valueOf(res));
    }
}
