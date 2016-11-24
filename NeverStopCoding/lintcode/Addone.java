package lintcode;

public class Addone {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		System.out.println((int)Math.pow(10, 2));
		int[] digits = {9,8,7,6,5,4,3,2,1,0};
		plusOne(digits);
	}
	
	/**
     * @param digits a number represented as an array of digits
     * @return the result
     */
    public static int[] plusOne(int[] digits) {
    	// Write your code here
    	int count = 0;
    	for(int i = 0; i < digits.length; i++){
    		if(digits[i] == 9){
    			count++;
    		}
    	}
    	if(count == digits.length){ // 9999
    		int[] newDigits = new int[digits.length + 1];
    		newDigits[0] = 1;
    		for(int i = 1; i < newDigits.length; i++){
    			newDigits[i] = 0;
    		}
    		return newDigits;
    	} else {
    		String str = "";
        	for(int i = 0; i < digits.length ; i++){
//        		System.out.println("第" + i + "位是：" + digits[i]);
        		str += digits[i];
        	}
        	long number = Long.parseLong(str);
//        	int number = Integer.parseInt(str); // 不行，对于987654321超出范围，应该使用长整形
//        	System.out.println(number);
        	number += 1;
        	String num = number + "";
//        	System.out.println(num);
        	int[] newDigits = new int[num.length()];
        	for(int i = 0; i < num.length(); i++){
        		char a = num.charAt(i);
//        		System.out.println("字符串第" + i + "位是：" + a);
        		newDigits[i] = a - 48;
        	}
        	return newDigits;
    	}
    }

}
