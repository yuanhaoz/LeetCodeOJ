package bishi;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 今日头条 2018校招 后端方向试卷在线考试
编程题 | 20.0分 2/3
第2题
时间限制：C/C++语言 1000MS；其他语言 3000MS
内存限制：C/C++语言 131072KB；其他语言 655360KB
题目描述：
给定一个数组序列, 需要求选出一个区间, 使得该区间是所有区间中经过如下计算的值最大的一个：
区间中的最小数 * 区间所有数的和 
最后程序输出经过计算后的最大值即可，不需要输出具体的区间。如给定序列  [6 2 1]则根据上述公式, 可得到所有可以选定各个区间的计算值:
[6] = 6 * 6 = 36;
[2] = 2 * 2 = 4;
[1] = 1 * 1 = 1;
[6,2] = 2 * 8 = 16;
[2,1] = 1 * 3 = 3;
[6, 2, 1] = 1 * 9 = 9;
从上述计算可见选定区间 [6] ，计算值为 36， 则程序输出为 36。
区间内的所有数字都在[0, 100]的范围内;
输入
第一行输入数组序列个数，第二行输入数组序列。
输出
输出数组经过计算后的最大值。

样例输入
3
6 2 1
样例输出
36

Hint
对于 50%的数据,  1 <= n <= 10000;
对于 100%的数据, 1 <= n <= 500000;
 * @author 郑元浩
 * @date 2017年8月22日 下午8:06:04
 *
 */
public class Test5 {
	
	private static int result = Integer.MIN_VALUE;
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] x = new int[n];
		for (int i = 0; i < n; i++) {
			x[i] = in.nextInt();
		}
		combiantion(x);
		System.out.println(result); 
	}
	
	public static void combiantion(int x[]){  
        if(x==null||x.length==0){  
            return ;  
        }  
        List<Integer> list=new ArrayList();
        for(int i=1;i<=x.length;i++){  
            combine(x,0,i,list);  
        }  
    }  
    //从字符数组中第begin个字符开始挑选number个字符加入list中  
    public static void combine(int []cs,int begin,int number,List<Integer> list){  
        if(number==0){
        	int min = Integer.MAX_VALUE;
        	int sum = 0;
        	for (int i = 0; i < list.size(); i++) {
				sum += list.get(i);
				min = Math.min(min, list.get(i));
			}
        	int plus = min * sum;
        	result = Math.max(result, plus);
        	System.out.println(list.toString() + "     " + min+"*"+sum+"="+plus+",result=" + result);
            return ;  
        }  
        if(begin==cs.length){  
            return;  
        }  
        list.add(cs[begin]);  
        combine(cs,begin+1,number-1,list);  
        list.remove((Integer)cs[begin]);  
        combine(cs,begin+1,number,list);  
    }  
	
	
}
