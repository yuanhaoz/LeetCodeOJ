package easy;
/**  
 * 67. Add Binary   Add to List QuestionEditorial Solution  My Submissions
Total Accepted: 118415
Total Submissions: 390253
Difficulty: Easy
Contributors: Admin
Given two binary strings, return their sum (also a binary string).

For example,
a = "11"
b = "1"
Return "100".

Subscribe to see which companies asked this question   
 *  
 * @author 郑元浩 
 * @date 2017年1月1日 下午12:49:28 
 */
public class AddBinary67 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String a = "11";
		String b = "1001";
		int[] arrayA = stringToArray(a);
        int[] arrayB = stringToArray(b);
        for (int i = 0; i < arrayA.length; i++) {
			System.out.print(arrayA[i] + " ");
		}
        System.out.println();
        for (int i = 0; i < arrayB.length; i++) {
			System.out.print(arrayB[i] + " ");
		}
        System.out.println();
        System.out.println(addBinary(a, b));
	}
	
	/**
	 * 更优化的方法
	 * 字符串从后往前加
	 * 1. 保留进位信息，每次计算加上进位信息
	 * 2. 真正的数为sum和2的余数
	 * 3. 真正的进位为sum和2的商
	 * 4. 最后如果进位不为0，则再添加一位信息
	 * 5. 返回的字符串数组应该是反序的
	 * @param a
	 * @param b
	 * @return
	 */
	public String addBinary2(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int i = a.length() - 1, j = b.length() -1, carry = 0;
        while (i >= 0 || j >= 0) {
            int sum = carry;
            if (j >= 0) sum += b.charAt(j--) - '0';
            if (i >= 0) sum += a.charAt(i--) - '0';
            sb.append(sum % 2);
            carry = sum / 2;
        }
        if (carry != 0) sb.append(carry);
        return sb.reverse().toString();
    }
	
	/**
	 * 先将字符串转化为数组，再将其相加，再将其转化为字符串
	 * @param a
	 * @param b
	 * @return
	 */
	public static String addBinary(String a, String b) {
        int[] arrayA = stringToArray(a);
        int[] arrayB = stringToArray(b);
        int len = Math.min(arrayA.length, arrayB.length);
        int len2 = Math.max(arrayA.length, arrayB.length);
        int[] arrayC = new int[len2];
        int flag = 0;
        int val = 0;
        for (int i = 0; i < len; i++) {
        	int add = arrayA[i] + arrayB[i] + flag;
        	System.out.print("arrayA: " + arrayA[i] + ",arrayB: " + arrayB[i] + ",flag: " + flag + ",add: " + add);
        	System.out.println();
        	if (add == 2) { // 相加为2，进位0
        		val = 0;
				flag = 1;
			}
        	if (add == 3) { // 相加为3，进位1
        		val = 1;
				flag = 1;
			} else if(add < 2) { // 相加小于2
				System.out.println("----------");
				val = arrayA[i] + arrayB[i] + flag;
				flag = 0;
			}
        	arrayC[i] = val;
        	System.out.println("arrayC: " + val);
        }
        if (len < len2) {
        	for (int i = len; i < len2; i++) {
        		int x = 0;
        		if (arrayA.length < arrayB.length) {
        			x = arrayB[i];
            	} else {
            		x = arrayA[i];
            	}
        		int add = x + flag;
        		if (add == 2) { // 相加为2，进位0
        			val = 0;
        			flag = 1;
        		} else { // 相加小于2
        			flag = 0;
        			val = add;
        		}
        		arrayC[i] = val;
        	}
		}
        System.out.println("arrayC:");
        for (int i = 0; i < arrayC.length; i++) {
			System.out.print(arrayC[i] + " ");
			
		}
        return arrayToString(arrayC);
        
    }
	
	/**
	 * 字符串转化为整数数组
	 * 比str多一个元素，该值为0
	 * @param str
	 * @return
	 */
	public static int[] stringToArray(String str){
		int[] array = new int[str.length() + 1];
		for (int i = 0; i < str.length(); i++) {
			array[i] = str.charAt(str.length() - 1 -i) - '0';
//			System.out.print(array[i] + " ");
		}
		array[str.length()] = 0;
		return array;
	}
	
	public static String arrayToString(int[] array){
		String s = "";
		if (array[array.length - 1] == 1) { // 最高一位为1时才保留
			s = s + array[array.length - 1];
		}
		for(int i = array.length - 2; i >= 0; i--){
		   s = s + array[i];//拼接成字符串，最终放在变量s中
		}
		return s;
	}

}
