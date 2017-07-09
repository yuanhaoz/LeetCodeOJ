package app6;

import java.util.Scanner;

/**  
 * 面试题46：求1+2+...+n
 * 题目：求1+2+...+n，要求不能使用乘除法，for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）
 * 
 * 思路：（C++思路）
 * 1. 使用类的构造函数
 * 2. 利用虚函数求解
 * 3. 利用函数指针求解
 * 4. 利用模板类型求解
 *  
 * @author 郑元浩 
 * @date 2017年4月6日 上午8:59:33 
 */
public class T46_Sum {
	
	public static void main(String[] args) {  
        // TODO Auto-generated method stub  
        int n=0;  
        @SuppressWarnings("resource")
		Scanner scan=new Scanner(System.in);  
        System.out.println("input n:");  
        n=scan.nextInt();  
        int sum=0;  
        sum=plus(sum,n);  
        System.out.println(sum);  
          
    }
	
    public static int plus(int sum,int n){  
        @SuppressWarnings("unused")
		boolean is_end=true;  
        sum+=n;  
        is_end=(n>0) && ((sum=plus(sum,--n))>0);  
        return sum;  
    }
    

}

